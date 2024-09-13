/*
 * Brick.java
 * This class defines the characteristics and behavior of a brick in the game
 */

 import java.awt.*;

 class Brick {
     private int x, y;  // Position of the brick
     private int width, height;  // Size of the brick
     private boolean visible;  // Indicates if the brick is visible or not
     private Color color;  // Color of the brick
 
     // Constructor to create a brick with specified properties
     public Brick(int x, int y, int width, int height, Color color) {
         this.x = x;
         this.y = y;
         this.width = width;
         this.height = height;
         this.visible = true;  // The brick is initially visible
         this.color = color;
     }
 
     // Getter methods to access the properties of the brick
     public int getX() {
         return x;
     }
 
     public int getY() {
         return y;
     }
 
     public int getWidth() {
         return width;
     }
 
     public int getHeight() {
         return height;
     }
 
     // Checks if the brick is currently visible
     public boolean isVisible() {
         return visible;
     }
 
     // Sets the visibility of the brick to invisible
     public void setInvisible() {
         visible = false;
     }
 
     // Draws the brick on the screen if it is visible
     public void draw(Graphics g) {
         if (visible) {
             g.setColor(color);
             g.fillRect(x, y, width, height);
         }
     }
 }