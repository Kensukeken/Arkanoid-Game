/* 
 * Paddle.java
 * This is the paddle the player controls in the game
 */

 import java.awt.*;
 import java.awt.event.KeyEvent;
 
 class Paddle {
     private int x, y;  // Where the paddle is on the screen
     private int width, height;  // How big the paddle is
     private int dx;  // How fast the paddle moves horizontally
     private int speed;  // Overall speed of the paddle
     private boolean leftPressed, rightPressed;  // Flags for left and right movement
 
     // Creates a new paddle at the specified position
     public Paddle(int x, int y) {
         this.x = x;
         this.y = y;
         this.width = 100;  // Initial width of the paddle
         this.height = 10;  // Initial height of the paddle
         this.dx = 5;  // Initial horizontal speed
         this.speed = 5;  // Overall speed of the paddle
         this.leftPressed = false;  // No left movement at the start
         this.rightPressed = false;  // No right movement at the start
     }
 
     // Gets the horizontal position of the paddle
     public int getX() {
         return x;
     }
 
     // Gets the vertical position of the paddle
     public int getY() {
         return y;
     }
 
     // Gets the width of the paddle
     public int getWidth() {
         return width;
     }
 
     // Gets the height of the paddle
     public int getHeight() {
         return height;
     }
 
     // Moves the paddle to the left
     public void moveLeft() {
         x -= speed;
     }
 
     // Moves the paddle to the right
     public void moveRight() {
         x += speed;
     }
 
     // Handles the pressing of keys to control paddle movement
     public void keyPressed(KeyEvent e) {
         int key = e.getKeyCode();
         if (key == KeyEvent.VK_LEFT) {
             leftPressed = true;
         }
         if (key == KeyEvent.VK_RIGHT) {
             rightPressed = true;
         }
     }
 
     // Handles the releasing of keys to stop paddle movement
     public void keyReleased(KeyEvent e) {
         int key = e.getKeyCode();
         if (key == KeyEvent.VK_LEFT) {
             leftPressed = false;
         }
         if (key == KeyEvent.VK_RIGHT) {
             rightPressed = false;
         }
     }
 
     // Empty method for handling keyTyped events (not used in this case)
     public void keyTyped(KeyEvent e) {
     }
 
     // Draws the paddle on the screen
     public void draw(Graphics g) {
         g.setColor(Color.GRAY);
         g.fillRect(x, y, width, height);
     }
 }