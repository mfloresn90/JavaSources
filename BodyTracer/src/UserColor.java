
import processing.core.*;

import SimpleOpenNI.*;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UserColor extends PApplet {

    /* --------------------------------------------------------------------------
     * SimpleOpenNI User Test
     * --------------------------------------------------------------------------
     * Processing Wrapper for the OpenNI/Kinect 2 library
     * http://code.google.com/p/simple-openni
     * --------------------------------------------------------------------------
     * prog:  Max Rheiner / Interaction Design / Zhdk / http://iad.zhdk.ch/
     * date:  12/12/2012 (m/d/y)
     * ----------------------------------------------------------------------------
     */
    SimpleOpenNI context;
    int[] userClr = new int[]{color(255, 0, 0),
        color(0, 255, 0),
        color(0, 0, 255),
        color(255, 255, 0),
        color(255, 0, 255),
        color(0, 255, 255)
    };
    PVector com = new PVector();
    PVector com2d = new PVector();
    Map<Integer, ArrayList<PVector>> handPathList = new HashMap<Integer, ArrayList<PVector>>();
    int handVecListSize = 30;
    // a 50 pixel diameter hand
    float handSize = 30;
    
    int cuadrante = 0;
    boolean seleccionado = false;

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

        context.setMirror(true);

        // enable hands + gesture generation
        context.enableHand();
        context.startGesture(SimpleOpenNI.GESTURE_CLICK);

        //background(200, 0, 0);
        stroke(0, 0, 255);
        strokeWeight(3);
        smooth();
    }

    public void draw() {
        // update the cam
        context.update();

        // draw depthImageMap
        image(context.depthImage(), 0, 0);
        //image(context.userImage(), 0, 0);
        stroke(0);
        line(getWidth() / 2, getY(), getWidth() / 2, getHeight());
        line(getX(), getHeight() / 2, getWidth(), getHeight() / 2);
        // draw the tracked hands
        if (handPathList.size() > 0) {

            Iterator itr = handPathList.entrySet().iterator();
            while (itr.hasNext()) {
                Map.Entry mapEntry = (Map.Entry) itr.next();
                int handId = (Integer) mapEntry.getKey();
                ArrayList<PVector> vecList = (ArrayList<PVector>) mapEntry.getValue();
                PVector p;

                pushStyle();
                //stroke(userClr[(handId - 1) % userClr.length]);
                //noFill();
                Iterator itrVec = vecList.iterator();
                beginShape();
                while (itrVec.hasNext()) {
                    p = (PVector) itrVec.next();
                    vertex(p.x, p.y, p.z);

                }
                endShape();

                //stroke(userClr[(handId - 1) % userClr.length]);
                strokeWeight(4);
                p = vecList.get(0);
                point(p.x, p.y, p.z);
                PVector nP = new PVector();
                context.convertRealWorldToProjective(p, nP);
                fill(255, 0, 0);
                ellipse(nP.x, nP.y, handSize, handSize);
                
                if (insideRect01(nP)) {
                    fill(0, 0, 255, 127);
                    rect(getX(), getY(), getWidth() / 2, getHeight() / 2);
                    if (seleccionado) cuadrante = 1;
                } else if (insideRect02(nP)) {
                    fill(255, 0, 0, 127);
                    rect(getX(), getHeight() / 2, getWidth() / 2, getHeight() / 2);
                    if (seleccionado) cuadrante = 2;
                } else if (insideRect03(nP)) {
                    fill(255, 255, 0, 127);
                    rect(getWidth() / 2, getY(), getWidth(), getHeight() / 2);
                    if (seleccionado) cuadrante = 3;
                } else if (insideRect04(nP)) {
                    fill(0, 255, 0, 127);
                    rect(getWidth() / 2, getHeight() / 2, getWidth(), getHeight());
                    if (seleccionado) cuadrante = 4;
                } else {
                    cuadrante = 0;
                }

                switch (cuadrante) {
                    case 1:
                        fill(0, 0, 255);
                        rect(getX(), getY(), getWidth() / 2, getHeight() / 2);
                        seleccionado = false;
                        break;
                    case 2:
                        fill(255, 0, 0);
                        rect(getX(), getHeight() / 2, getWidth() / 2, getHeight() / 2);
                        seleccionado = false;
                        break;
                    case 3:
                        fill(255, 255, 0);
                        rect(getWidth() / 2, getY(), getWidth(), getHeight() / 2);
                        seleccionado = false;
                        break;
                    case 4:
                        fill(0, 255, 0);
                        rect(getWidth() / 2, getHeight() / 2, getWidth(), getHeight());
                        seleccionado = false;
                        break;
                }
                popStyle();

            }
        }
    }

// -----------------------------------------------------------------
// hand events
    public void onNewHand(SimpleOpenNI curContext, int handId, PVector pos) {
        println("onNewHand - handId: " + handId + ", pos: " + pos);

        ArrayList<PVector> vecList = new ArrayList<PVector>();
        vecList.add(pos);

        handPathList.put(handId, vecList);

    }

    public void onTrackedHand(SimpleOpenNI curContext, int handId, PVector pos) {
        //println("onTrackedHand - handId: " + handId + ", pos: " + pos );

        ArrayList<PVector> vecList = handPathList.get(handId);
        if (vecList != null) {
            vecList.add(0, pos);
            if (vecList.size() >= handVecListSize) // remove the last point 
            {
                vecList.remove(vecList.size() - 1);
            }
        }
    }

    public void onLostHand(SimpleOpenNI curContext, int handId) {
        println("onLostHand - handId: " + handId);

        handPathList.remove(handId);

    }

    public void onCompletedGesture(SimpleOpenNI curContext, int gestureType, PVector pos) {
        println("onCompletedGesture - gestureType: " + gestureType + ", pos: " + pos);
        context.startTrackingHand(pos);
        int handId = context.startTrackingHand(pos);
        println("hand stracked: " + handId);
        seleccionado = true;

    }

    public void keyPressed() {
        switch (key) {
            case ' ':
                context.setMirror(!context.mirror());
                break;
        }
    }

    static public void main(String[] passedArgs) {
        String[] appletArgs = new String[]{"User"};
        if (passedArgs != null) {
            PApplet.main(concat(appletArgs, passedArgs));
        } else {
            PApplet.main(appletArgs);
        }
    }

    private boolean insideRect01(PVector p) {
        Rectangle rect = new Rectangle(getX(), getY(), getWidth() / 2, getHeight() / 2);
        if (rect.contains(p.x, p.y)) {
            return true;
        }
        return false;
    }

    private boolean insideRect02(PVector p) {
        Rectangle rect = new Rectangle(getX(), getHeight() / 2, getWidth() / 2, getHeight() / 2);
        if (rect.contains(p.x, p.y)) {
            return true;
        }
        return false;
    }

    private boolean insideRect03(PVector p) {
        Rectangle rect = new Rectangle(getWidth() / 2, getY(), getWidth(), getHeight() / 2);
        if (rect.contains(p.x, p.y)) {
            return true;
        }
        return false;
    }

    private boolean insideRect04(PVector p) {
        Rectangle rect = new Rectangle(getWidth() / 2, getHeight() / 2, getWidth(), getHeight());
        if (rect.contains(p.x, p.y)) {
            return true;
        }
        return false;
    }
}
