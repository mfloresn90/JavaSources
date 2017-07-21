package pingpong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class GameField {

    int minX, maxX, minY, maxY;
    private Color colorFilled;
    private Color colorBorder;
    private static final Color DEFAULT_COLOR_FILLED = Color.WHITE;
    private static final Color DEFAULT_COLOR_BORDER = Color.GREEN;
    public static final int goalPostRadius = 100;
    private String curDir = null;
    private BufferedImage bgnd;
    

    public GameField(int x, int y, int width, int height, Color colorFilled, Color colorBorder) {
        try {
            minX = x;
            minY = y;
            maxX = x + width - 1;
            maxY = y + height - 1;
            this.colorFilled = colorFilled;
            this.colorBorder = colorBorder;
            curDir = System.getProperty("user.dir");
            curDir += "//src//img//";
            bgnd = ImageIO.read(new File(curDir + "background.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(GameField.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public GameField(int x, int y, int width, int height) {
        this(x, y, width, height, DEFAULT_COLOR_FILLED, DEFAULT_COLOR_BORDER);
    }

    public void set(int x, int y, int width, int height) {
        minX = x;
        minY = y;
        maxX = x + width - 1;
        maxY = y + height - 1;
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(bgnd, minX, minY, maxX - minX - 1, maxY - minY - 1, null);
        
        g2.drawRect(minX, minY, maxX - minX - 1, maxY - minY - 1);
    }

}
