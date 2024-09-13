/* 
 * Ball.java
 * This class is for the bouncing ball in the game
 */
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ball {
    public static int randint(int low, int high){
    return (int)(Math.random()*(high-low+1)+low);
  }
    private double x, y;  // Position of the ball
    private double dx, dy;  // Speed and direction of the ball
    private int radius;  // Size of the ball

    // Sets up the ball's initial position and movement speed
    public Ball(double x, double y, double dx, double dy) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.radius = 10;  // Size of the ball
    }

    // Moves the ball based on its speed
    public void move() {
        x += dx;
        y += dy;
    }

    // Draws the ball on the screen
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        g2d.fill(new Ellipse2D.Double(x - radius, y - radius, 2 * radius, 2 * radius));
    }

    // Gets the horizontal position of the ball
    public double getX() {
        return x;
    }

    // Gets the vertical position of the ball
    public double getY() {
        return y;
    }

    // Gets the size of the ball
    public int getDiameter() {
        return 2 * radius;
    }

    // Checks if the ball hits the paddle
    public boolean hitsPaddle(Paddle paddle) {
        Rectangle ballRect = new Rectangle((int) x - radius, (int) y - radius, 2 * radius, 2 * radius);
        Rectangle paddleRect = new Rectangle(paddle.getX(), paddle.getY(), paddle.getWidth(), paddle.getHeight());
        return ballRect.intersects(paddleRect);
    }

    // Checks if the ball hits a brick
    public boolean hitsBrick(Brick brick) {
        Rectangle ballRect = new Rectangle((int) x - radius, (int) y - radius, 2 * radius, 2 * radius);
        Rectangle brickRect = new Rectangle(brick.getX(), brick.getY(), brick.getWidth(), brick.getHeight());
        return ballRect.intersects(brickRect);
    }

    // Changes the ball's up-and-down direction
    public void RYD() {
        dy = -dy;
    }

    // Changes the ball's left-and-right direction
    public void RXD() {
        dx = -dx;
    }
}