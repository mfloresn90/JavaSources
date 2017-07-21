
import processing.core.*;
import SimpleOpenNI.*;

public class cuadrante extends PApplet {

    SimpleOpenNI context;
    int[] userClr = new int[]{color(255, 0, 0),
        color(0, 255, 0),
        color(255, 0, 255),
        color(255, 255, 255),
        color(255, 0, 255),
        color(0, 255, 255)

    };
    PVector com = new PVector();
    PVector com2d = new PVector();

    public void setup() {
        size(640, 480);

        context = new SimpleOpenNI(this);
        if (context.isInit() == false) {
            println("Can't init SimpleOpenNI, maybe the camera is not connected!");
            exit();
            return;
        }

        // enable depthMap generation 
        context.enableDepth();

        // enable skeleton generation for all joints
        context.enableUser();

        background(200, 0, 0);

        stroke(0, 0, 255);
        //****3
        strokeWeight(5);
        smooth();

    }

    public void draw() {
        // update the cam
        context.update();

  //**********esta parte se manipula para indicar qué se quiere mostrar en pantalla
        // draw depthImageMap
        //image(context.depthImage(),0,0);
        image(context.userImage(), 0, 0);

        // draw the skeleton if it's available
        int[] userList = context.getUsers();
        for (int i = 0; i < userList.length; i++) {
            if (context.isTrackingSkeleton(userList[i])) {
                stroke(userClr[ (userList[i] - 1) % userClr.length]);
                //drawSkeleton(userList[i]);
                circleForHand(userList[i]);
            }

            // draw the center of mass
            if (context.getCoM(userList[i], com)) {
                context.convertRealWorldToProjective(com, com2d);
                stroke(100, 255, 0);
                strokeWeight(1);
                beginShape(LINES);
                vertex(com2d.x, com2d.y - 5);
                vertex(com2d.x, com2d.y + 5);

                vertex(com2d.x - 5, com2d.y);
                vertex(com2d.x + 5, com2d.y);
                endShape();

                fill(0, 255, 100);
                text(Integer.toString(userList[i]), com2d.x, com2d.y);
            }
        }
    }

// draw the skeleton with the selected joints
    public void drawSkeleton(int userId) {
  // to get the 3d joint data
  /*
         PVector jointPos = new PVector();
         context.getJointPositionSkeleton(userId,SimpleOpenNI.SKEL_NECK,jointPos);
         println(jointPos);
         */
        stroke(255, 0, 0);

        context.drawLimb(userId, SimpleOpenNI.SKEL_HEAD, SimpleOpenNI.SKEL_NECK);

        context.drawLimb(userId, SimpleOpenNI.SKEL_NECK, SimpleOpenNI.SKEL_LEFT_SHOULDER);
        context.drawLimb(userId, SimpleOpenNI.SKEL_LEFT_SHOULDER, SimpleOpenNI.SKEL_LEFT_ELBOW);
        stroke(75, 75, 255);
        context.drawLimb(userId, SimpleOpenNI.SKEL_LEFT_ELBOW, SimpleOpenNI.SKEL_LEFT_HAND);
        stroke(255, 0, 0);

        context.drawLimb(userId, SimpleOpenNI.SKEL_NECK, SimpleOpenNI.SKEL_RIGHT_SHOULDER);
        context.drawLimb(userId, SimpleOpenNI.SKEL_RIGHT_SHOULDER, SimpleOpenNI.SKEL_RIGHT_ELBOW);
        stroke(75, 75, 255);
        context.drawLimb(userId, SimpleOpenNI.SKEL_RIGHT_ELBOW, SimpleOpenNI.SKEL_RIGHT_HAND);
        stroke(255, 0, 0);

        context.drawLimb(userId, SimpleOpenNI.SKEL_LEFT_SHOULDER, SimpleOpenNI.SKEL_TORSO);
        context.drawLimb(userId, SimpleOpenNI.SKEL_RIGHT_SHOULDER, SimpleOpenNI.SKEL_TORSO);

        context.drawLimb(userId, SimpleOpenNI.SKEL_TORSO, SimpleOpenNI.SKEL_LEFT_HIP);
        context.drawLimb(userId, SimpleOpenNI.SKEL_LEFT_HIP, SimpleOpenNI.SKEL_LEFT_KNEE);
        context.drawLimb(userId, SimpleOpenNI.SKEL_LEFT_KNEE, SimpleOpenNI.SKEL_LEFT_FOOT);

        context.drawLimb(userId, SimpleOpenNI.SKEL_TORSO, SimpleOpenNI.SKEL_RIGHT_HIP);
        context.drawLimb(userId, SimpleOpenNI.SKEL_RIGHT_HIP, SimpleOpenNI.SKEL_RIGHT_KNEE);
        context.drawLimb(userId, SimpleOpenNI.SKEL_RIGHT_KNEE, SimpleOpenNI.SKEL_RIGHT_FOOT);
    }

    public void circleForHand(int userId) {
        PVector joinPosHead = new PVector();
        context.getJointPositionSkeleton(userId, SimpleOpenNI.SKEL_HEAD, joinPosHead);
        PVector jointPosRH = new PVector();
        context.getJointPositionSkeleton(userId, SimpleOpenNI.SKEL_RIGHT_HAND, jointPosRH);
        PVector jointPosLH = new PVector();
        context.getJointPositionSkeleton(userId, SimpleOpenNI.SKEL_LEFT_HAND, jointPosLH);
        // convert real world point to projective space
        PVector jointPos_ProjHead = new PVector();
        context.convertRealWorldToProjective(joinPosHead, jointPos_ProjHead);
        PVector jointPos_ProjRH = new PVector();
        context.convertRealWorldToProjective(jointPosRH, jointPos_ProjRH);
        PVector jointPos_ProjLH = new PVector();
        context.convertRealWorldToProjective(jointPosLH, jointPos_ProjLH);
        // a 50 pixel diameter hand
        float handSize = 50;
        // set the fill colour to make the circle green
        fill(0, 255, 0);
        // draw the circle at the position of the head with the specified head size
        ellipse(jointPos_ProjHead.x, jointPos_ProjHead.y, handSize, handSize);
        fill(255, 0, 255);
        ellipse(jointPos_ProjRH.x, jointPos_ProjRH.y, handSize, handSize);
        fill(125, 125, 0);
        ellipse(jointPos_ProjLH.x, jointPos_ProjLH.y, handSize, handSize);
    }

// -----------------------------------------------------------------
// SimpleOpenNI events
    public void onNewUser(SimpleOpenNI curContext, int userId) {
        println("onNewUser - userId: " + userId);
        println("\tstart tracking skeleton");

        curContext.startTrackingSkeleton(userId);
    }

    public void onLostUser(SimpleOpenNI curContext, int userId) {
        println("onLostUser - userId: " + userId);
    }

    public void onVisibleUser(SimpleOpenNI curContext, int userId) {
  //println("onVisibleUser - userId: " + userId);
    }

    public void keyPressed() {
        switch (key) {
            case ' ':
                context.setMirror(!context.mirror());
                break;
        }
    }

    static public void main(String[] passedArgs) {
        String[] appletArgs = new String[]{"UserModificado"};
        if (passedArgs != null) {
            PApplet.main(concat(appletArgs, passedArgs));
        } else {
            PApplet.main(appletArgs);
        }
    }

}
