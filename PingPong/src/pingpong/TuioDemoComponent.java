package pingpong;

import java.awt.*;
import java.awt.image.*;
import java.util.*;
import javax.swing.*;
import TUIO.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;


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
    private BufferedImage red;
    private BufferedImage blue;
    private Rectangle blueRec;
    private Rectangle redRec;
    private String curDir = null;
    private float scale_img = 1.0f;
    private int bX, bY, bW, bH;
    private int rX, rY, rW, rH;

    private int curbx = 0, curby = 0;
    private int currx = 0, curry = 0;
    private int cur2x = 0;
    private int cur2y = 0;
    private int cur3x = 0;
    private int cur3y = 0;
    //private int bcnt = 2;
    //private int rcnt = -1;

    public int difbX = 0, difbY = 0;
    public int difrX = 0, difrY = 0;
    public boolean startMoving = false;
    public boolean startMoving2 = false;

    /**
     * *****************************************
     */
    
    List<Ball> ballsL = new ArrayList<Ball>();
    private GameField gameField;

    public TuioDemoComponent() {
        curDir = System.getProperty("user.dir");
        curDir += "//src//img//";
        try {
            //bgnd = ImageIO.read(new File(curDir + "background.jpg"));
            blue = ImageIO.read(new File(curDir + "lBlue.png"));
            bW = Math.round(blue.getWidth() * scale_img);
            bH = Math.round(blue.getHeight() * scale_img);
            red = ImageIO.read(new File(curDir + "lRed.png"));
            rW = Math.round(red.getWidth() * scale_img);
            rH = Math.round(red.getHeight() * scale_img);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        // init balls
        ballsL.add(new Ball(100, 410, 25, 3, 34, Color.WHITE));
        ballsL.add(new Ball(80, 350, 25, 2, -114, Color.WHITE));

        gameField = new GameField(0, 0, 1280, 720, Color.BLACK, Color.WHITE);

        //canvas = new DrawCanvas();

        this.setLayout(new BorderLayout());
        //this.add(canvas, BorderLayout.CENTER);
        // Handling window resize. Adjust container box to fill the screen.
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Component c = (Component) e.getSource();
                Dimension dim = c.getSize();
                //gameField.set(0, 0, dim.width, dim.height);
            }
        });
        // Start the ball bouncing
        gameStart();
        /**/

    }

    public void setSize(int w, int h) {
        super.setSize(w, h);
        width = w;
        height = h;
        scale = height / (float) TuioDemoComponent.table_size;
        bX = (getWidth() - bW) / 8;
        bY = (getHeight() - bH) / 2;
        rX = (int) ((getWidth() - rW) / 1.2);
        rY = (getHeight() - rH) / 2;
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

            if (tcur.getCursorID() == 0) {
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
        
        gameField.draw(g2);
        for (Ball ball : ballsL) {
            ball.draw(g2);
        }
        
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        Font font = new Font("Arial", Font.PLAIN, 100);
        g2.setFont(font);
        
        g2.drawString(Integer.toString(PhysicsUtils.bluecnt), 10, 100);
        g2.drawString(Integer.toString(PhysicsUtils.redcnt), 1150, 100);
        
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        int w = (int) Math.round(width - scale * finger_size / 1.0f);
        int h = (int) Math.round(height - scale * finger_size / 1.0f);
        
        g2.drawImage(blue, bX, bY, bW, bH, null);
        blueRec = new Rectangle(bX, bY, bW, bH);
        
        g2.drawImage(red, rX, rY, rW, rH, null);
        redRec = new Rectangle(rX, rY, rW, rH);

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
            //g2.setPaint(Color.WHITE);
            //Font font2 = new Font("Arial", Font.PLAIN, 12);
            //g2.setFont(font2);
            //g2.drawString("Point: " + tcur.getCursorID() + " (" + current_point.getScreenX(w) + ", " + current_point.getScreenY(h) + ")", current_point.getScreenX(w), current_point.getScreenY(h));

            
            if (cursorList.size() == 1) {
                TuioCursor cursor0 = cursorList.get(cursorList.keySet().toArray()[0]);
                curbx = cursor0.getScreenX(w);
                curby = cursor0.getScreenY(h);
            } else if (cursorList.size() == 2) {
                TuioCursor cursor0 = cursorList.get(cursorList.keySet().toArray()[1]);
                curbx = cursor0.getScreenX(w);
                curby = cursor0.getScreenY(h);
                TuioCursor cursor1 = cursorList.get(cursorList.keySet().toArray()[0]);
                currx = cursor1.getScreenX(w);
                curry = cursor1.getScreenY(h);
            }

            if (blueRec.contains(curbx, curby)) {
                if (startMoving) {
                    //difX = cur0x - bX;
                    difbY = curby - bY;
                    startMoving = false;
                }
                //bX = cur0x - difX;
                bY = curby - difbY;
            } else {
                startMoving = true;
            }
            
            if (redRec.contains(currx, curry)) {
                if (startMoving2) {
                    //difX = cur0x - bX;
                    difrY = curry - rY;
                    startMoving2 = false;
                }
                //bX = cur0x - difX;
                rY = curry - difrY;
            } else {
                startMoving2 = true;
            }

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

    /**
     * Start the ball bouncing.
     */
    public void gameStart() {
        Thread gameThread = new Thread() {
            public void run() {
                while (true) {
                    gameUpdate(false);
                    repaint();
                    // Delay and give other thread a chance
                    try {
                        Thread.sleep(4);
                    } catch (InterruptedException ex) {
                    }
                }
            }
        };
        gameThread.start(); // Invoke GaemThread.run()
    }

    /**
     * detects collision, bounces, calculate final velocities
     *
     * @param isStriker
     */
    public void gameUpdate(boolean isStriker) {
        // Check collision between the balls and the box bX, bY, bW, bH
        for (int i = 0; i < ballsL.size(); i++) {
            PhysicsUtils.collisionWithWall(new Rectangle(gameField.minX, gameField.minY, gameField.maxX, gameField.maxY), ballsL.get(i)); 
        }
        
        // Check collision between two balls
        for (int i = 0; i < ballsL.size(); i++) {
            for (int j = 0; j < ballsL.size(); j++) {
                if (i < j) {
                    PhysicsUtils.intersect(ballsL.get(i), ballsL.get(j));
                }
            }
        }
        
        // update positions increments
        for (int i = 0; i < ballsL.size(); i++) {
            ballsL.get(i).update(1);
        }
    }

}
