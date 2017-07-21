package tuio_demo;
/*
 TUIO Java GUI Demo
 Copyright (c) 2005-2014 Martin Kaltenbrunner <martin@tuio.org>
 
 Permission is hereby granted, free of charge, to any person obtaining
 a copy of this software and associated documentation files
 (the "Software"), to deal in the Software without restriction,
 including without limitation the rights to use, copy, modify, merge,
 publish, distribute, sublicense, and/or sell copies of the Software,
 and to permit persons to whom the Software is furnished to do so,
 subject to the following conditions:
 
 The above copyright notice and this permission notice shall be
 included in all copies or substantial portions of the Software.
 
 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR
 ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF
 CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

import TUIO.*;
import com.sun.javafx.iio.common.ImageTools;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import static tuio_demo.ImageTool.rotate;

public class TuioDemoComponent extends JComponent implements TuioListener {

    private Hashtable<Long, TuioDemoObject> objectList = new Hashtable<Long, TuioDemoObject>();
    private Hashtable<Long, TuioCursor> cursorList = new Hashtable<Long, TuioCursor>();
    private Hashtable<Long, TuioDemoBlob> blobList = new Hashtable<Long, TuioDemoBlob>();
    
    public static final int finger_size = 35;
    public static final int object_size = 60;
    public static final int table_size = 760;
    public static String curDir = null;

    //nuevas variables
    public int difX = 0;
    public int difY = 0;
    public boolean startMoving = false;
    public boolean zoomStart = false;
    public boolean rotateStart = false;

    public static int width, height;
    private float scale = 1.0f;
    public boolean verbose = false;

    private BufferedImage img1;
    private float scale_img = 1.0f;
    private int cImgW, cImgH;
    private int cImgX, cImgY;
    private Rectangle imgRec;
    private float initialDistance;
    private float initialDegrees;
    private float currentDegrees;
    private float imgDegrees;
    //private AffineTransform at;
    //private float i;
    //private ImageTool imgt;

    public TuioDemoComponent() {
        curDir = System.getProperty("user.dir");
        curDir += "//src//img//";
        try {
            img1 = ImageIO.read(new File(curDir+"forza.jpg"));
            cImgW = Math.round(img1.getWidth() * scale_img);
            cImgH = Math.round(img1.getHeight() * scale_img);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void setSize(int w, int h) {
        super.setSize(w, h);
        width = w;
        height = h;
        scale = height / (float) TuioDemoComponent.table_size;
        cImgX = (getWidth() - cImgW) / 2;
        cImgY = (getHeight() - cImgH) / 2;
    }

    public void addTuioObject(TuioObject tobj) {
        TuioDemoObject demo = new TuioDemoObject(tobj);
        objectList.put(tobj.getSessionID(), demo);
        if (verbose) {
            System.out.println("add obj " + tobj.getSymbolID() + " (" + tobj.getSessionID() + ") " + tobj.getX() + " " + tobj.getY() + " " + tobj.getAngle());
        }
    }

    public void updateTuioObject(TuioObject tobj) {
        TuioDemoObject demo = (TuioDemoObject) objectList.get(tobj.getSessionID());
        demo.update(tobj);
        if (verbose) {
            System.out.println("set obj " + tobj.getSymbolID() + " (" + tobj.getSessionID() + ") " + tobj.getX() + " " + tobj.getY() + " " + tobj.getAngle() + " " + tobj.getMotionSpeed() + " " + tobj.getRotationSpeed() + " " + tobj.getMotionAccel() + " " + tobj.getRotationAccel());
        }
    }

    public void removeTuioObject(TuioObject tobj) {
        objectList.remove(tobj.getSessionID());
        if (verbose) {
            System.out.println("del obj " + tobj.getSymbolID() + " (" + tobj.getSessionID() + ")");
        }
    }

    public void addTuioCursor(TuioCursor tcur) {
        if (!cursorList.containsKey(tcur.getSessionID())) {
            cursorList.put(tcur.getSessionID(), tcur);
            startMoving = true;
            repaint();
        }
        if (verbose) {
            System.out.println("add cur " + tcur.getCursorID() + " (" + tcur.getSessionID() + ") " + tcur.getX() + " " + tcur.getY());
        }
    }

    public void updateTuioCursor(TuioCursor tcur) {
        repaint();
        if (verbose) {
            System.out.println("set cur " + tcur.getCursorID() + " (" + tcur.getSessionID() + ") " + tcur.getX() + " " + tcur.getY() + " " + tcur.getMotionSpeed() + " " + tcur.getMotionAccel());
        }
    }

    public void removeTuioCursor(TuioCursor tcur) {
        cursorList.remove(tcur.getSessionID());
        repaint();
        if (verbose) {
            System.out.println("del cur " + tcur.getCursorID() + " (" + tcur.getSessionID() + ")");
        }
    }

    public void addTuioBlob(TuioBlob tblb) {
        TuioDemoBlob demo = new TuioDemoBlob(tblb);
        blobList.put(tblb.getSessionID(), demo);
        if (verbose) {
            System.out.println("add blb " + tblb.getBlobID() + " (" + tblb.getSessionID() + ") " + tblb.getX() + " " + tblb.getY() + " " + tblb.getAngle());
        }
    }

    public void updateTuioBlob(TuioBlob tblb) {
        TuioDemoBlob demo = (TuioDemoBlob) blobList.get(tblb.getSessionID());
        demo.update(tblb);
        if (verbose) {
            System.out.println("set blb " + tblb.getBlobID() + " (" + tblb.getSessionID() + ") " + tblb.getX() + " " + tblb.getY() + " " + tblb.getAngle() + " " + tblb.getMotionSpeed() + " " + tblb.getRotationSpeed() + " " + tblb.getMotionAccel() + " " + tblb.getRotationAccel());
        }
    }

    public void removeTuioBlob(TuioBlob tblb) {
        blobList.remove(tblb.getSessionID());
        if (verbose) {
            System.out.println("del blb " + tblb.getBlobID() + " (" + tblb.getSessionID() + ")");
        }
    }

    public void refresh(TuioTime frameTime) {
        repaint();
    }

    public void paint(Graphics g) {
        update(g);
    }

    public void update(Graphics g) {
        //at = AffineTransform.getTranslateInstance(cImgX, cImgY);
        //at.scale(1, 1);
        
        //if (i <= 360) {
            //i++;
            //at.rotate(Math.toRadians(i), img1.getWidth()/2, img1.getHeight()/2);
        
        //}
        
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, width, height);
        int w = (int) Math.round(width - scale * finger_size / 2.0f);
        int h = (int) Math.round(height - scale * finger_size / 2.0f);

        //Draw IMAGE 
        g2.drawImage(rotate(img1, imgDegrees), cImgX, cImgY, cImgW, cImgH, null);
        
        //g2.drawImage(img1, at, null);
        imgRec = new Rectangle(cImgX, cImgY, cImgW, cImgH);
        

        Enumeration<TuioCursor> cursors = cursorList.elements();
        while (cursors.hasMoreElements()) {
            TuioCursor tcur = cursors.nextElement();
            if (tcur == null) {
                continue;
            }
            ArrayList<TuioPoint> path = tcur.getPath();
            TuioPoint current_point = path.get(0);
            
            if (current_point != null) {
                // draw the cursor path
                //g2.setPaint(Color.YELLOW);
                for (int i = 0; i < path.size(); i++) {
                    TuioPoint next_point = path.get(i);
                    //g2.drawLine(current_point.getScreenX(w), current_point.getScreenY(h), next_point.getScreenX(w), next_point.getScreenY(h));
                    current_point = next_point;
                }
            }

            // draw the finger tip
            g2.setPaint(Color.GREEN);
            int s = (int) (scale * finger_size);
            g2.fillOval(current_point.getScreenX(w - s / 2), current_point.getScreenY(h - s / 2), s, s);
            //g2.setPaint(Color.black);
            //g2.drawString(tcur.getCursorID() + "", current_point.getScreenX(w), current_point.getScreenY(h));

            //resolver punto fuera de la imagen
            if (cursorList.size() == 1) {
                int ncImgX = current_point.getScreenX(w);
                int ncImgY = current_point.getScreenY(h);

                if (imgRec.contains(ncImgX, ncImgY)) {
                    if (startMoving) {
                        difX = ncImgX - cImgX;
                        difY = ncImgY - cImgY;
                        startMoving = false;
                    }
                    cImgX = ncImgX - difX;
                    cImgY = ncImgY - difY;
                    zoomStart = false;
                }

            } else if (cursorList.size() == 2) {
                TuioCursor cursor1 = cursorList.get(cursorList.keySet().toArray()[0]);
                TuioCursor cursor2 = cursorList.get(cursorList.keySet().toArray()[1]);

                float cur1x = cursor1.getScreenX(w);
                float cur1y = cursor1.getScreenY(h);

                float cur2x = cursor2.getScreenX(w);
                float cur2y = cursor2.getScreenY(h);

                if (imgRec.contains(cur1x, cur1y) && imgRec.contains(cur2x, cur2y)) {
                    if (zoomStart == false) {
                        zoomStart = true;
                        initialDistance = cursor1.getDistance(cursor2.getPosition());
                        initialDegrees = imgDegrees + cursor1.getAngleDegrees(cursor2.getPosition());
                    }
                    float currentDistance = cursor1.getDistance(cursor2.getPosition());
                    
                    if (Math.abs(initialDistance - currentDistance) * 10 > 0.3f) {
                        /*String strGesture = "";*/
                        if (currentDistance > initialDistance) {
                            //strGesture = "Zoom Out";
                            scale_img += 0.05f;
                            if (scale_img >= 1.5f) {
                                scale_img = 1.5f;
                            }
                        } else {
                            //strGesture = "Zoom In";
                            scale_img -= 0.005f;
                            if (scale_img <= 0.5f) {
                                scale_img = 0.5f;
                            }
                        }
                        cImgW = Math.round(img1.getWidth() * scale_img);
                        cImgH = Math.round(img1.getHeight() * scale_img);
                    }

                    /*String strGesture = "";*/
                    currentDegrees = cursor1.getAngleDegrees(cursor2.getPosition());
                    imgDegrees = initialDegrees - currentDegrees;
                    
                    /*g2.drawString("Distancia Inicial:" + initialDistance + " -- Distancia actual:" + currentDistance, 10, 10);
                    g2.drawString("Evento: " + strGesture, 10, 30);*/
                    //float move = initialDegrees - currentDegrees;
                    g2.drawString("Grados Inicial:" + initialDegrees, 10, 60);
                    g2.drawString("Grados actuales: " + currentDegrees, 10, 80);
                
                }

                
            }

            /*
             if ((current_point.getScreenX(w) >= wStart && current_point.getScreenX(w) <= wFinal)  && (current_point.getScreenX(h) >= hStart && current_point.getScreenX(h) <= hFinal)) {
             cImgX = current_point.getScreenX(w) - (image.getWidth()/4);
             cImgY = current_point.getScreenY(h) - (image.getHeight()/4);
             }
             */
        }

        // draw the objects
        Enumeration<TuioDemoObject> objects = objectList.elements();
        while (objects.hasMoreElements()) {
            TuioDemoObject tobj = objects.nextElement();
            if (tobj != null) {
                tobj.paint(g2, width, height);
            }

        }
    }

}
