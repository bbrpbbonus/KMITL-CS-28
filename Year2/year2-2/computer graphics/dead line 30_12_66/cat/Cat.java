package cat;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JComponent;

public class Cat extends JComponent {

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        // Set background color
        setBackground(Color.CYAN);

        // Translate the origin to the center of the component
        g2.translate(getWidth() / 2, getHeight() / 2);

        // Draw body
        Ellipse2D.Double body = new Ellipse2D.Double(-100, 0, 200, 150);
        g2.setColor(Color.GRAY);
        g2.fill(body);

        // Draw legs
        drawLeg(g2, -70, 75);
        drawLeg(g2, 70, 75);
        drawLeg(g2, -50, 150);
        drawLeg(g2, 50, 150);

        // Draw tail
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(5));
        g2.draw(new Line2D.Double(-120, 50, -150, 100));

        // Draw head (reuse the head from the previous example)
        drawHead(g2);
    }

    private void drawLeg(Graphics2D g2, double x, double y) {
        g2.setColor(Color.GRAY);
        g2.setStroke(new BasicStroke(10));
        g2.draw(new Line2D.Double(x, y, x, y + 50));
    }

    private void drawHead(Graphics2D g2) {
        // Draw head
        Ellipse2D.Double head = new Ellipse2D.Double(-50, -100, 100, 100);
        g2.setColor(Color.GRAY);
        g2.fill(head);

        // Draw eyes
        g2.setColor(Color.BLUE);
        g2.fill(new Ellipse2D.Double(-30, -70, 20, 10));
        g2.fill(new Ellipse2D.Double(10, -70, 20, 10));

        // Draw nose
        g2.setColor(Color.PINK);
        int[] xPoints = {-5, -20, 10};
        int[] yPoints = {-85, -50, -50};
        Polygon nose = new Polygon(xPoints, yPoints, 3);
        g2.fill(nose);
    }
}
