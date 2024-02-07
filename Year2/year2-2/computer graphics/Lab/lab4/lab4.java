import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;;

public class lab4 extends JPanel {
    public static void main(String[] args) {
        lab4 m = new lab4();

        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("Lab 4 circle & ellipe");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        midpointCircle(g, 300, 300, 100, 5);
        midpointEllipse(g, 300, 300, 200, 100, 5);
    }

    private void midpointEllipse(Graphics g, int xc, int yc, int a, int b, int size) {
        int a2 = a * a, b2 = b * b;
        int twoA2 = 2 * a2, twoB2 = 2 * b2;

        // region1
        int x = 0;
        int y = b;
        int d = Math.round(b2 - a2 * b + a2 / 4);
        int dx = 0, dy = twoA2 * y;
        while (dx <= dy) {
            g.setColor(Color.decode("#28749f"));

            plotdot(g, x + xc, y + yc, size);
            plotdot(g, x + xc, -y + yc, size);
            plotdot(g, -x + xc, -y + yc, size);
            plotdot(g, -x + xc, y + yc, size);

            x++;
            dx += twoB2;
            d = d + dx + b2;

            if (d >= 0) {
                y--;
                dy -= twoA2;
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
            g.setColor(Color.decode("#649bbb"));

            plotdot(g, x+xc, y+yc, size);
            plotdot(g, x+xc, -y+yc, size);
            plotdot(g, -x+xc, -y+yc, size);
            plotdot(g, -x+xc, y+yc, size);

            y++;
            dy +=twoA2;
            d = d + dy + a2;
            if (d >= 0) {
                x--;
                dx-= twoB2;
                d = d - dx;
            }
        }
    }

    private void midpointCircle(Graphics g, int xc, int yc, int r, int size) {
        int x = 0;
        int y = r;
        int dx = 2 * x;
        int dy = 2 * y;
        int d = 1 - r;
        while (x <= y) {
            g.setColor(Color.decode("#000000"));

            plotdot(g, x + xc, y + yc, size);
            plotdot(g, x + xc, -y + yc, size);
            plotdot(g, -x + xc, -y + yc, size);
            plotdot(g, -x + xc, y + yc, size);
            plotdot(g, y + xc, x + yc, size);
            plotdot(g, y + xc, -x + yc, size);
            plotdot(g, -y + xc, -x + yc, size);
            plotdot(g, -y + xc, x + yc, size);

            x++;
            dx += 2;
            d = d + dx + 1;
            if (d >= 0) {
                y--;
                dy -= 2;
                d = d - dy;
            }
        }
    }

    private void plotdot(Graphics g, int x, int y, int size) {
        g.fillRect(x, y, size, size);
    }
}