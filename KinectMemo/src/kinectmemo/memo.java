package kinectmemo;

import processing.core.*;
import SimpleOpenNI.*;
import java.awt.*;
import java.util.*;

/**
 *
 * @author MFNicolás
 */
public class memo extends PApplet {

    SimpleOpenNI context;
    Map<Integer, ArrayList<PVector>> handPathList = new HashMap<Integer, ArrayList<PVector>>();
    String curDir = "";
    PImage rHand;
    PImage bg;
    PImage bgImg;
    float handSize = 50;
    boolean userH = false;
    boolean selected = false;
    int handVecListSize = 30;
    int cuadrant = 0;
    int cnt = 0;
    int ft = 99;
    int sd = 99;
    int[] mem;

    public void setup() {
        mem = new int[4];
        size(640, 480);
        context = new SimpleOpenNI(this);
        curDir = System.getProperty("user.dir");
        curDir += "//src//imgs//";
        rHand = loadImage(curDir + "r_hand.png");
        bg = loadImage(curDir + "bgPS.jpg");
        bgImg = loadImage(curDir + "bgGame.jpg");
        if (context.isInit() == false) {
            println("Can't init SimpleOpenNI, maybe the camera is not connected!");
            exit();
            return;
        }
        context.enableDepth();
        context.setMirror(true);
        context.enableHand();
        context.startGesture(SimpleOpenNI.GESTURE_CLICK);
        context.startGesture(SimpleOpenNI.GESTURE_WAVE);
    }

    public void draw() {
        context.update();
        if (!userH) {
            image(bg, 0, 0, getWidth(), getHeight());
        } else {
            image(bgImg, 0, 0, getWidth(), getHeight());
            if (handPathList.size() > 0) {
                Iterator itr = handPathList.entrySet().iterator();
                while (itr.hasNext()) {
                    Map.Entry mapEntry = (Map.Entry) itr.next();
                    int handId = (Integer) mapEntry.getKey();
                    ArrayList<PVector> vecList = (ArrayList<PVector>) mapEntry.getValue();
                    PVector p;
                    pushStyle();
                    Iterator itrVec = vecList.iterator();
                    beginShape();
                    while (itrVec.hasNext()) {
                        p = (PVector) itrVec.next();
                        vertex(p.x, p.y, p.z);
                    }
                    endShape();
                    strokeWeight(4);
                    p = vecList.get(0);
                    point(p.x, p.y, p.z);
                    PVector nP = new PVector();
                    context.convertRealWorldToProjective(p, nP);
                    if (insideRect01(nP)) {
                        fill(0, 0, 255, 127);
                        rect(getX(), getY(), getWidth() / 2, getHeight() / 2);
                        if (selected && cnt == 0) {
                            cuadrant = 1;
                        }
                    } else if (insideRect02(nP)) {
                        fill(0, 0, 255, 127);
                        rect(getX(), getHeight() / 2, getWidth() / 2, getHeight() / 2);
                        if (selected  && cnt == 0) {
                            cuadrant = 2;
                        }
                    } else if (insideRect03(nP)) {
                        fill(255, 255, 0, 127);
                        rect(getWidth() / 2, getY(), getWidth(), getHeight() / 2);
                        if (selected  && cnt == 0) {
                            cuadrant = 3;
                        }
                    } else if (insideRect04(nP)) {
                        fill(255, 255, 0, 127);
                        rect(getWidth() / 2, getHeight() / 2, getWidth(), getHeight());
                        if (selected  && cnt == 0) {
                            cuadrant = 4;
                        }
                    } else {
                        cuadrant = 0;
                    }

                    switch (cuadrant) {
                        case 1:
                            if (mem[0] == 0 && cnt == 0) {
                                fill(0, 0, 255);
                                rect(getX(), getY(), getWidth() / 2, getHeight() / 2);
                                
                                mem[0] = 1;
                                if (ft == 99 && sd == 99) {
                                    ft = 0;
                                } else if (ft != 99 && sd == 99) {
                                    sd = 0;
                                }
                            }
                            selected = false;
                            break;
                        case 2:
                            if (mem[1] == 0 && cnt == 0) {
                                fill(0, 0, 255);
                                rect(getX(), getHeight() / 2, getWidth() / 2, getHeight() / 2);
                                mem[1] = 1;
                                if (ft == 99 && sd == 99) {
                                    ft = 1;
                                } else if (ft != 99 && sd == 99) {
                                    sd = 1;
                                }
                            }
                            selected = false;
                            break;
                        case 3:
                            if (mem[2] == 0 && cnt == 0) {
                                fill(255, 255, 0);
                                rect(getWidth() / 2, getY(), getWidth(), getHeight() / 2);
                                mem[2] = 2;
                                if (ft == 99 && sd == 99) {
                                    ft = 2;
                                } else if (ft != 99 && sd == 99) {
                                    sd = 2;
                                }
                            }
                            selected = false;
                            break;
                        case 4:
                            if (mem[3] == 0 && cnt == 0) {
                                fill(255, 255, 0);
                                rect(getWidth() / 2, getHeight() / 2, getWidth(), getHeight());
                                mem[3] = 2;
                                if (ft == 99 && sd == 99) {
                                    ft = 3;
                                } else if (ft != 99 && sd == 99) {
                                    sd = 3;
                                }
                            }
                            selected = false;
                            break;
                    }
                    popStyle();
                    image(rHand, nP.x, nP.y, handSize, handSize);
                    if ((ft != 99) && (sd != 99)) {
                        if (mem[ft] == mem[sd]) {
                            println("Igualessssss");
                        } else {
                            println("sorry my friend :P");
                        }
                        cnt = 1;
                    }
                }
            }
        }

    }

// -----------------------------------------------------------------
// hand events
    public void onNewHand(SimpleOpenNI curContext, int handId, PVector pos) {
        ArrayList<PVector> vecList = new ArrayList<PVector>();
        vecList.add(pos);
        handPathList.put(handId, vecList);
        println("Mano detectada...");
    }

    public void onTrackedHand(SimpleOpenNI curContext, int handId, PVector pos) {
        ArrayList<PVector> vecList = handPathList.get(handId);
        if (vecList != null) {
            vecList.add(0, pos);
            if (vecList.size() >= handVecListSize) {
                vecList.remove(vecList.size() - 1);
            }
        }
    }

    public void onLostHand(SimpleOpenNI curContext, int handId) {
        userH = false;
        selected = false;
        println("Mano perdida...");
        handPathList.remove(handId);
    }

    public void onCompletedGesture(SimpleOpenNI curContext, int gestureType, PVector pos) {
        context.startTrackingHand(pos);
        int handId = context.startTrackingHand(pos);
        if (gestureType == 0) {
            println("Saludo detectado.");
            println("Iniciando juego...");
            userH = true;
        } else if (gestureType == 1) {
            if (cnt == 0) {
                println("Click detectado.");
                selected = true;
            }
        }
    }

    public void keyPressed() {
        switch (key) {
            case ' ':
                context.setMirror(!context.mirror());
                break;
        }
    }

    private boolean insideRect01(PVector p) {
        Rectangle rect = new Rectangle(0, 0, getWidth() / 2, getHeight() / 2);
        if (rect.contains(p.x, p.y)) {
            if (cnt == 0) {
                return true;
            } else if (cnt == 1) {
                cnt = 0;
                ft = 99;
                sd = 99;
                Arrays.fill(mem, 0);
                selected = false;
                return false;
            }
        }
        return false;
    }

    private boolean insideRect02(PVector p) {
        Rectangle rect = new Rectangle(0, getHeight() / 2, getWidth() / 2, getHeight() / 2);
        if (rect.contains(p.x, p.y)) {
            if (cnt == 0) {
                return true;
            } else if (cnt == 1) {
                cnt = 0;
                ft = 99;
                sd = 99;
                Arrays.fill(mem, 0);
                selected = false;
                return false;
            }
        }
        return false;
    }

    private boolean insideRect03(PVector p) {
        Rectangle rect = new Rectangle(getWidth() / 2, 0, getWidth(), getHeight() / 2);
        if (rect.contains(p.x, p.y)) {
            if (cnt == 0) {
                return true;
            } else if (cnt == 1) {
                cnt = 0;
                ft = 99;
                sd = 99;
                Arrays.fill(mem, 0);
                selected = false;
                return false;
            }
        }
        return false;
    }

    private boolean insideRect04(PVector p) {
        Rectangle rect = new Rectangle(getWidth() / 2, getHeight() / 2, getWidth(), getHeight());
        if (rect.contains(p.x, p.y)) {
            if (cnt == 0) {
                return true;
            } else if (cnt == 1) {
                cnt = 0;
                ft = 99;
                sd = 99;
                Arrays.fill(mem, 0);
                selected = false;
                return false;
            }
        }
        return false;
    }

}