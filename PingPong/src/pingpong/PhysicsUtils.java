package pingpong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class PhysicsUtils {
    
    public static int bluecnt;
    public static int redcnt;

    public static void collisionWithWall(Rectangle wall, Ball ball) {
        float ballMinX = wall.x + ball.radius;
        float ballMinY = wall.y + ball.radius;
        float ballMaxX = wall.width - ball.radius;
        float ballMaxY = wall.height - ball.radius;
        
        //int value = 0;
        if (ball.x < ballMinX) {
            ball.speedX = -ball.speedX; // Reflect along normal
            ball.x = ballMinX; // Re-position the ball at the edge
            //value = 1;
            redcnt++;
            //System.out.println("Anotacion right to left");
        } else if (ball.x > ballMaxX) {
            ball.speedX = -ball.speedX;
            ball.x = ballMaxX;
            //value = 2;
            bluecnt++;
            //System.out.println("Anotacion left to rigth");
        }
        // May cross both x and y bounds
        if (ball.y < ballMinY) {
            ball.speedY = -ball.speedY;
            ball.y = ballMinY;
            //value = 3;
        } else if (ball.y > ballMaxY) {
            ball.speedY = -ball.speedY;
            ball.y = ballMaxY;
            //value = 4;
        }
        
        //return value;
    }

    public static void intersect(Ball a, Ball b) {
        //ref http://gamedev.stackexchange.com/questions/20516/ball-collisions-sticking-together
        double xDist, yDist;
        xDist = a.x - b.x;
        yDist = a.y - b.y;
        double distSquared = xDist * xDist + yDist * yDist;
		// Check the squared distances instead of the the distances, same
        // result, but avoids a square root.
        if (distSquared <= (a.radius + b.radius) * (a.radius + b.radius)) {
            double speedXocity = b.speedX - a.speedX;
            double speedYocity = b.speedY - a.speedY;
            double dotProduct = xDist * speedXocity + yDist * speedYocity;
			// Neat vector maths, used for checking if the objects moves towards
            // one another.
            if (dotProduct > 0) {
                double collisionScale = dotProduct / distSquared;
                double xCollision = xDist * collisionScale;
                double yCollision = yDist * collisionScale;
				// The Collision vector is the speed difference projected on the
                // Dist vector,
                // thus it is the component of the speed difference needed for
                // the collision.
                double combinedMass = a.getMass() + b.getMass();
                double collisionWeightA = 2 * b.getMass() / combinedMass;
                double collisionWeightB = 2 * a.getMass() / combinedMass;
                a.speedX += (collisionWeightA * xCollision);
                a.speedY += (collisionWeightA * yCollision);
                b.speedX -= (collisionWeightB * xCollision);
                b.speedY -= (collisionWeightB * yCollision);
            }
        }
    }

}
