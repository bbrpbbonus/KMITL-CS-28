import java.awt.*;
import java.awt.geom.*;
import javax.swing.JComponent;

public class Cat extends JComponent {

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        // Set background color
        setBackground(Color.RED);

        // Translate the origin to the center of the component
        g2.translate(getWidth() / 2, getHeight() / 2);

        // Draw head
        Ellipse2D.Double head = new Ellipse2D.Double(-240, -240, 480, 480);
        g2.setColor(Color.BLACK);
        g2.fill(head);

        // Draw eyes
        g2.setColor(Color.BLUE);
        g2.fill(new Ellipse2D.Double(-170, -100, 100, 50));
        g2.fill(new Ellipse2D.Double(50, -100, 90, 50));

        // Draw mouth
        g2.setColor(Color.BLUE);
        g2.setStroke(new BasicStroke(4));
        g2.drawArc(-60, 100, 60, 60, 50, 100);
        g2.drawArc(-20, 100, 60, 60, 40, 100);

        // Draw whiskers (adjust coordinates as needed)
        drawWhisker(g2, -280, 75, -105, 55);
        drawWhisker(g2, -280, 120, -100, 55);
        drawWhisker(g2, -280, 35, -100, 55);
        drawWhisker(g2, 280, 75, 105, 55);
        drawWhisker(g2, 280, 120, 100, 55);
        drawWhisker(g2, 280, 35, 100, 55);

        // Draw ears
        drawEar(g2, Color.BLACK, -170, -260, -200, -100, -100, -150);
        drawEar(g2, Color.BLACK, 170, -260, 200, -100, 100, -150);
        drawEar(g2, Color.YELLOW, -170, -260, -200, -100, -100, -150);
        drawEar(g2, Color.YELLOW, 170, -260, 200, -100, 100, -150);

        // Draw nose
        g2.setColor(Color.BLUE);
        drawPolygon(g2, Color.BLUE, new int[]{-5, -20, 10}, new int[]{-15, 30, 30});

        // Draw lightsabers
        g2.setColor(Color.GREEN);
        drawLightsaber(g2, -285, 25, -250, -200);
        g2.setColor(Color.BLUE);
        drawLightsaber(g2, 285, -25, 250, -200);

        // Draw text
        g2.setColor(Color.YELLOW);
        Font font = new Font("SansSerif", Font.BOLD, 24);
        g2.setFont(font);
        g2.drawString("THE FORCE IS STRONG WITH THIS ONE", -250, -270);
    }

    private void drawWhisker(Graphics2D g2, double x1, double y1, double x2, double y2) {
        g2.setStroke(new BasicStroke(2));
        g2.draw(new Line2D.Double(x1, y1, x2, y2));
    }

    private void drawEar(Graphics2D g2, Color color, int x1, int y1, int x2, int y2, int x3, int y3) {
        Polygon ear = new Polygon();
        g2.setColor(color);
        ear.addPoint(x1, y1);
        ear.addPoint(x2, y2);
        ear.addPoint(x3, y3);
        g2.fill(ear);
    }

    private void drawLightsaber(Graphics2D g2, double x1, double y1, double x2, double y2) {
        g2.setStroke(new BasicStroke(8));
        g2.draw(new Line2D.Double(x1, y1, x2, y2));

        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(15));
        g2.draw(new Line2D.Float());
    }

    private void drawPolygon(Graphics2D g2, Color color, int[] xPoints, int[] yPoints) {
        Polygon polygon = new Polygon();
        g2.setColor(color);
        for (int i = 0; i < xPoints.length; i++) {
            polygon.addPoint(xPoints[i], yPoints[i]);
        }
        g2.fill(polygon);
    }
}
