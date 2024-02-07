import javax.swing.*;
import java.awt.*;

class AllGraphics extends JPanel implements Runnable {

    private int size = 100;
    private double circleMove = 0;
    private int circleDirection = 1;
    private double circleSpeed = 100;
    private double squareRotate = 0;

    private double squareY = 600;
    private double squareSpeed = 100;
    private boolean startMovingSquare = false;

    public static void main(String[] args) {
        AllGraphics m = new AllGraphics();

        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("All Graphics");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        (new Thread(m)).start();
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        double lastTime = System.currentTimeMillis();
        double currentTime, elapsedTime;

        while (true) {
            currentTime = System.currentTimeMillis();
            elapsedTime = currentTime - lastTime;
            lastTime = currentTime;

            if (currentTime >= 3000) {
                startMovingSquare = true; 
            }

            circleMove += circleDirection * circleSpeed * elapsedTime / 1000.0;
            if (circleMove >= getWidth() - size) {
                circleMove = getWidth() - size;
                circleDirection = -1; 
            } else if (circleMove <= 0) {
                circleMove = 0;
                circleDirection = 1; 
            }

            if (startMovingSquare) {
                squareY -= squareSpeed * elapsedTime / 1000.0;
                if (squareY <= 0) {
                    squareY = 0;
                }
            }

            squareRotate += 0.5 * elapsedTime / 1000.0;

            // Display
            repaint();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON));
        g2.translate(circleMove, 0);
        g2.drawOval(0, 2, 100, 100);
        g2.translate(-circleMove, 0);

        g2.rotate(squareRotate, 300, 300);
        g2.drawRect(0, 200, size, size);

        g2.rotate(-squareRotate, 300, 300);
        g2.drawRect(2, (int) squareY, size, size);
    }

}
