import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

class FlowerPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int radius = 50;

        int petals = 8;
        double angleIncrement = 2 * Math.PI / petals;

        g2d.setColor(Color.RED);

        for (int i = 0; i < petals; i++) {
            double angle = i * angleIncrement;

            int x1 = centerX + (int) (radius * Math.cos(angle));
            int y1 = centerY + (int) (radius * Math.sin(angle));
            int x2 = centerX + (int) (2 * radius * Math.cos(angle));
            int y2 = centerY + (int) (2 * radius * Math.sin(angle));
            midpointEllipse(g2d, x1, y1, 10, 5, 5);
            midpointEllipse(g2d, x2, y2, 10, 5, 5);
        }

        // Draw circle around center
        drawCircleAroundCenter(g2d, centerX, centerY, 50);
    }

    private void midpointEllipse(Graphics g, int xc, int yc, int a, int b, int size) {
        // Implementation of midpoint ellipse algorithm here...
    }

    private void plot(Graphics g, int x, int y, int size) {
        g.fillRect(x, y, size, size);
    }

    // Function to rotate midpoint ellipses
    private void rotateMidpointEllipses(Graphics2D g2d, int xc, int yc, int a, int b, double angle, int size) {
        // Implementation of midpoint ellipse rotation here...
    }

    // Function to draw a circle around the center
    private void drawCircleAroundCenter(Graphics2D g2d, int centerX, int centerY, int radius) {
        Ellipse2D.Double circle = new Ellipse2D.Double(centerX - radius, centerY - radius, radius * 2, radius * 2);
        g2d.setColor(Color.BLUE);
        g2d.draw(circle);
    }

    public void drawRotatedMidpointEllipses(Graphics2D g2d, int xc, int yc, int a, int b, double angle, int size) {
        rotateMidpointEllipses(g2d, xc, yc, a, b, angle, size);
    }
}

public class FlowerDrawing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Flower Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        FlowerPanel panel = new FlowerPanel();
        frame.add(panel);
        frame.setVisible(true);

        // Rotate midpoint ellipses
        Graphics2D g2d = (Graphics2D) panel.getGraphics();
        panel.drawRotatedMidpointEllipses(g2d, 100, 100, 10, 5, 45, 5);
    }
}
