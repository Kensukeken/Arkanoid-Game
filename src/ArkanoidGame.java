import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class ArkanoidGame extends JFrame implements ActionListener, KeyListener, MouseListener {

    public static final int WIDTH = 400;
    public static final int HEIGHT = 600;

    private Ball ball;
    private Paddle paddle;
    private List<Brick> bricks;
    private boolean[] keys = new boolean[256];
    private boolean gameOver = false;
    private int score = 0;

    private GamePanel gamePanel;

    public ArkanoidGame() {
        setTitle("Arkanoid Game");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        ball = new Ball(WIDTH / 2, HEIGHT / 2, 2, -2);
        paddle = new Paddle(WIDTH / 2 - 50, HEIGHT - 40);
        bricks = createBricks();

        gamePanel = new GamePanel();
        gamePanel.setBackground(Color.BLACK);
        add(gamePanel, BorderLayout.CENTER);

        Timer timer = new Timer(20, this);
        timer.start();

        gamePanel.addKeyListener(this);
        gamePanel.setFocusable(true);
        gamePanel.requestFocusInWindow();

        addMouseListener(this);
    }

    private List<Brick> createBricks() {
        List<Brick> brickList = new ArrayList<>();
        int brickWidth = 50;
        int brickHeight = 20;
        int space = 5;
        int rows = 4;
        int cols = WIDTH / (brickWidth + space);
        Color[] rowColors = {Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int brickX = j * (brickWidth + space);
                int brickY = i * (brickHeight + space) + 50;
                brickList.add(new Brick(brickX, brickY, brickWidth, brickHeight, rowColors[i]));
            }
        }
        return brickList;
    }

    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            move();
            checkCollisions();
            gamePanel.repaint(); // Triggering the repaint
        }
    }

    private void move() {
        ball.move();
        if ((keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A]) && paddle.getX() > 0) {
            paddle.moveLeft();
        }
        if ((keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D]) && paddle.getX() + paddle.getWidth() < WIDTH) {
            paddle.moveRight();
        }
    }

    private void checkCollisions() {
        if (ball.getY() - ball.getDiameter() / 2 <= 0) {
            ball.RYD();
        }

        if (ball.getX() - ball.getDiameter() / 2 <= 0 || ball.getX() + ball.getDiameter() / 2 >= WIDTH) {
            ball.RXD();
        }

        if (ball.getY() + ball.getDiameter() / 2 >= HEIGHT) {
            gameOver = true;
        }

        if (gameOver) {
            return;
        }

        if (ball.hitsPaddle(paddle)) {
            ball.RYD();
        }

        List<Brick> bricksToRemove = new ArrayList<>();
        for (Brick brick : bricks) {
            if (ball.hitsBrick(brick) && brick.isVisible()) {
                brick.setInvisible();
                bricksToRemove.add(brick);
                ball.RYD();
                score++;
            }
        }
        bricks.removeAll(bricksToRemove);

        if (bricks.isEmpty()) {
            gameOver = true;
        }
    }

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        keys[code] = true;

        if (gameOver && (e.getKeyChar() == 'r' || e.getKeyChar() == 'R')) {
            resetGame();
        }
    }

    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        keys[code] = false;
    }

    public void keyTyped(KeyEvent e) {}

    public void mousePressed(MouseEvent e) {
        if (gameOver && e.getButton() == MouseEvent.BUTTON1) {
            resetGame();
        }
    }

    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}

    private void resetGame() {
        ball = new Ball(WIDTH / 2, HEIGHT / 2, 2, -2);
        paddle = new Paddle(WIDTH / 2 - 50, HEIGHT - 40);
        bricks = createBricks();
        gameOver = false;
        score = 0;
        gamePanel.repaint();
    }
    class GamePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WIDTH, HEIGHT);
        
            ball.draw(g);
            paddle.draw(g);
            for (Brick brick : bricks) {
                brick.draw(g);
            }
        
            // Draw the score at the top-left of the screen
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 16));
            g.drawString("Score: " + score, 10, 20);  // Score display at the top-left
        
            if (gameOver) {
                // Set the font for the "Press 'R' to play again" message
                g.setFont(new Font("Arial", Font.BOLD, 20));
                String restartMessage = "Press 'R' to play again";
        
                // Fixed position for the message
                int x = 90;  // Horizontal position (50 px from the left)
                int y = 310;  // Vertical position (70 px from the top)
        
                g.drawString(restartMessage, x, y);  // Drawing the message at the fixed position
            }
        }
    }
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ArkanoidGame game = new ArkanoidGame();
            game.setVisible(true);
        });
    }

    
}
