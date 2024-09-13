<<<<<<< HEAD
# Arkanoid-Game
Arkanoid Game using Java.
=======
# Arkanoid Game
![](/assets/maxresdefault.jpg)
## Overview

This project is a Java implementation of the classic *Arkanoid* game, developed using **Swing** for the graphical interface. The objective of the game is to control a paddle to prevent the ball from falling while breaking all the bricks on the screen.

## Features

- **Ball and Paddle Interaction**: Move the paddle left and right to deflect the ball and break bricks.
- **Brick Layout**: Multiple rows of bricks are positioned at the top of the screen, each with unique colors.
- **Game Controls**:
  - Use the **arrow keys** or **A/D** keys to move the paddle.
  - Press **R** or click the mouse to restart the game after a game over.
- **Score Tracking**: Score is displayed on the top-left of the screen as you progress through the game.
- **Dynamic Gameplay**: The game continues until either all bricks are destroyed or the ball falls past the paddle.

## Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/arkanoid-game.git
   cd arkanoid-game
   ```

2. **Compile the Java files**:
   Make sure you have JDK installed, and then compile the source files using:
   ```bash
   javac ArkanoidGame.java Ball.java Paddle.java
   ```

3. **Run the Game**:
   Execute the game using:
   ```bash
   java ArkanoidGame
   ```

## How to Play

- **Move the Paddle**: Use the left (`←`) and right (`→`) arrow keys, or `A` and `D` keys to move the paddle.
- **Restart**: After the game ends, press the `R` key or click the mouse to restart.
- The game ends when the ball falls below the paddle or when all bricks are destroyed.

## Game Mechanics

- **Ball**: The ball starts at the center of the screen and moves in random directions. It bounces off walls, bricks, and the paddle.
- **Paddle**: Positioned at the bottom, the paddle is used to keep the ball in play.
- **Bricks**: The game contains rows of bricks that disappear when hit by the ball.

## Project Structure

```
arkanoid-game/
│
├── ArkanoidGame.java  # Main game logic and UI handling
├── Ball.java          # Handles ball movement and collisions
├── Paddle.java        # Manages paddle movement
├── Brick.java         # Defines brick properties
└── README.md          # Project description and setup guide
```

## Contributions

Feel free to submit issues or pull requests to enhance the game's features or fix bugs.

>>>>>>> 979460b (Updated)
