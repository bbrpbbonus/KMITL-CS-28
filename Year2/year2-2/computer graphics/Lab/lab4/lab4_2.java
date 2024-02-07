import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class lab4_2 extends JPanel {
    int WIDTH = 600;
    int HEIGHT = 600;
    int CIRCLE_RADIUS = 100;
    int ELLIPSE_A = 200;
    int ELLIPSE_B = 100;
    int DOT_SIZE = 5;

    public static void main(String[] args) {
        lab4_2 drawer = new lab4_2();

        JFrame frame = new JFrame();
        frame.add(drawer);
        frame.setTitle("Circle & Ellipse");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        drawMidpointCircle(g, WIDTH / 2, HEIGHT / 2, CIRCLE_RADIUS, DOT_SIZE);
        drawMidpointEllipse(g, WIDTH / 2, HEIGHT / 2, ELLIPSE_A, ELLIPSE_B, DOT_SIZE);
    }

    private void drawMidpointEllipse(Graphics g, int xc, int yc, int a, int b, int size) {
        int a2 = a * a, b2 = b * b;
        int twoA2 = 2 * a2, twoB2 = 2 * b2;

        // region1
        int x = 0;
        int y = b;
        int d = Math.round(b2 - a2 * b + a2 / 4);
        int dx = 0, dy = twoA2 * y;
        while (dx <= dy) {
            plotDot(g, x + xc, y + yc, size);
            plotDot(g, x + xc, -y + yc, size);
            plotDot(g, -x + xc, -y + yc, size);
            plotDot(g, -x + xc, y + yc, size);

            x++;
            dx = dx + twoB2;
            d = d + dx + b2;

            if (d >= 0) {
                y = y - 1;
                dy = dy - twoA2;
                d = d - dy;
            }
        }

        // region2
        x = a;
        y = 0;
        d = Math.round(a2 - b2 * a + b2 / 4);
        dx = twoB2 * x;
        dy = 0;
        while (dx >= dy) {
            plotDot(g, x + xc, y + yc, size);
            plotDot(g, x + xc, -y + yc, size);
            plotDot(g, -x + xc, -y + yc, size);
            plotDot(g, -x + xc, y + yc, size);

            y = y + 1;
            dy = dy + twoA2;
            d = d + dy + a2;
            if (d >= 0) {
                x = x - 1;
                dx = dx - twoB2;
                d = d - dx;
            }
        }
    }

    private void drawMidpointCircle(Graphics g, int xc, int yc, int r, int size) {
        int x = 0;
        int y = r;
        int dx = 2 * x;
        int dy = 2 * y;
        int d = 1 - r;
        while (x <= y) {
            plotDot(g, x + xc, y + yc, size);
            plotDot(g, x + xc, -y + yc, size);
            plotDot(g, -x + xc, -y + yc, size);
            plotDot(g, -x + xc, y + yc, size);
            plotDot(g, y + xc, x + yc, size);
            plotDot(g, y + xc, -x + yc, size);
            plotDot(g, -y + xc, -x + yc, size);
            plotDot(g, -y + xc, x + yc, size);

            x = x + 1;
            dx = dx + 2;
            d = d + dx + 1;
            if (d >= 0) {
                y = y - 1;
                dy = dy - 2;
                d = d - dy;
            }
        }

    }

    private void plotDot(Graphics g, int x, int y, int size) {
        g.fillRect(x, y, size, size);
    }
}
