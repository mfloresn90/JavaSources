package tuioclases;

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
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import javax.swing.*;
import TUIO.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TuioDemoComponent extends JComponent implements TuioListener {

    private Hashtable<Long, TuioDemoObject> objectList = new Hashtable<Long, TuioDemoObject>();
    private Hashtable<Long, TuioCursor> cursorList = new Hashtable<Long, TuioCursor>();
    private Hashtable<Long, TuioDemoBlob> blobList = new Hashtable<Long, TuioDemoBlob>();

    public static final int finger_size = 20;
    public static final int object_size = 60;
    public static final int table_size = 760;
    public static int width, height;
    private float scale = 1.0f;
    public boolean verbose = false;

    /**
     * *****************************************
     */
    private Filename fname;
    private BufferedImage img1;
    private Rectangle imgRec;
    private BufferedImage img2;
    private Rectangle imgRec2;
    private String curDir = null;
    private float scale_img = 1.0f;
    private int cImgW, cImgH;
    private int cImgX, cImgY;
    private int cImgW2, cImgH2;
    private int cImgX2, cImgY2;
    
    private int cur0x = 0;
    private int cur0y = 0;
    private int cur1x = 0;
    private int cur1y = 0;
    private int cur2x = 0;
    private int cur2y = 0;
    private int cur3x = 0;
    private int cur3y = 0;
    
    public int difX = 0;
    public int difY = 0;
    public int difX2 = 0;
    public int difY2 = 0;
    public boolean startMoving = false;
    public boolean startMoving2 = false;
    /**
     * *****************************************
     */
    
    public TuioDemoComponent() {
        curDir = System.getProperty("user.dir");
        curDir += "//src//img//";
        File fe = new File(curDir);
        File[] ficheros = fe.listFiles();
        for (int x = 0; x < ficheros.length; x++) {
            fname = new Filename(ficheros[x].toString());
            if (fname.getExtension().equals(".jpg") || fname.getExtension().equals(".png")) {
                if (x == 1) {
                    try {
                        img1 = ImageIO.read(new File(ficheros[x].toString()));
                        cImgW = Math.round(img1.getWidth() * scale_img);
                        cImgH = Math.round(img1.getHeight() * scale_img);
                    } catch (IOException ex) {
                        //ex.printStackTrace()
                    }
                } else if (x == 2) {
                    try {
                        img2 = ImageIO.read(new File(ficheros[x].toString()));
                        cImgW2 = Math.round(img2.getWidth() * scale_img);
                        cImgH2 = Math.round(img2.getHeight() * scale_img);
                    } catch (IOException ex) {
                        //ex.printStackTrace()
                    }
                }
                
            }
        }
    }

    public void setSize(int w, int h) {
        super.setSize(w, h);
        width = w;
        height = h;
        scale = height / (float) TuioDemoComponent.table_size;
        cImgX = (getWidth() - cImgW) / 2;
        cImgY = (getHeight() - cImgH) / 2;
        cImgX2 = 0;
        cImgY2 = 0;
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
            
            if (tcur.getCursorID() == 1) {
                startMoving = true;
            } else if (tcur.getCursorID() == 1) {
                startMoving2 = true;
            }
            
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
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, width, height);

        int w = (int) Math.round(width - scale * finger_size / 1.0f);
        int h = (int) Math.round(height - scale * finger_size / 1.0f);

        //Draw Images
        g2.drawImage(img1, cImgX, cImgY, cImgW, cImgH, null);
        imgRec = new Rectangle(cImgX, cImgY, cImgW, cImgH);
        
        g2.drawImage(img2, cImgX2, cImgY2, cImgW2, cImgH2, null);
        imgRec2 = new Rectangle(cImgX2, cImgY2, cImgW2, cImgH2);

        Enumeration<TuioCursor> cursors = cursorList.elements();
        while (cursors.hasMoreElements()) {
            
            TuioCursor tcur = cursors.nextElement();
            ArrayList<TuioPoint> path = tcur.getPath();
            TuioPoint current_point = path.get(0);
            
            if (tcur == null) {
                continue;
            }
            
            if (current_point != null) {
                // draw the cursor path
                for (int i = 0; i < path.size(); i++) {
                    TuioPoint next_point = path.get(i);
                    current_point = next_point;
                }
            }

            // draw the finger tip
            g2.setPaint(Color.GREEN);
            int s = (int) (scale * finger_size);
            g2.fillOval(current_point.getScreenX(w - s / 2), current_point.getScreenY(h - s / 2), s, s);
            g2.setPaint(Color.WHITE);
            g2.drawString("Point: " + tcur.getCursorID() + " (" + current_point.getScreenX(w) + ", " + current_point.getScreenY(h) + ")", current_point.getScreenX(w), current_point.getScreenY(h));

            /**/
            
            
            if (cursorList.size() == 1) {
                TuioCursor cursor0 = cursorList.get(cursorList.keySet().toArray()[0]);
                cur0x = cursor0.getScreenX(w);
                cur0y = cursor0.getScreenY(h);
            } else if (cursorList.size() == 2) {
                TuioCursor cursor0 = cursorList.get(cursorList.keySet().toArray()[0]);
                cur0x = cursor0.getScreenX(w);
                cur0y = cursor0.getScreenY(h);
                TuioCursor cursor1 = cursorList.get(cursorList.keySet().toArray()[1]);
                cur1x = cursor1.getScreenX(w);
                cur1y = cursor1.getScreenY(h);
            } else if (cursorList.size() == 3) {
                TuioCursor cursor2 = cursorList.get(cursorList.keySet().toArray()[2]);
                cur2x = cursor2.getScreenX(w);
                cur2y = cursor2.getScreenY(h);
            } else if (cursorList.size() == 4) {
                TuioCursor cursor3 = cursorList.get(cursorList.keySet().toArray()[3]);
                cur3x = cursor3.getScreenX(w);
                cur3y = cursor3.getScreenY(h);
            }
            
            if (imgRec.contains(cur0x, cur0y)) {
                if (startMoving) {
                    difX = cur0x - cImgX;
                    difY = cur0y - cImgY;
                    startMoving = false;
                }
                cImgX = cur0x - difX;
                cImgY = cur0y - difY;
            } else
                startMoving = true;
            
            if (imgRec2.contains(cur1x, cur1y)) {
                if (startMoving2) {
                    difX2 = cur1x - cImgX2;
                    difY2 = cur1y - cImgY2;
                    startMoving = false;
                }
                cImgX2 = cur1x - difX2;
                cImgY2 = cur1y - difY2;
            } else
                startMoving2 = true; 
            /**/
            
            /*
            if (imgRec.contains(ncImgX, ncImgY)) {
                    difX = ncImgX - cImgX;
                    difY = ncImgY - cImgY;
            }
            cImgX = ncImgX - difX;
            cImgY = ncImgY - difY;
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
