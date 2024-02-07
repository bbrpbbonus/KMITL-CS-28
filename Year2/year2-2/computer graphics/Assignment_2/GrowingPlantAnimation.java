import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class GrowingPlantAnimation extends JPanel implements Runnable {

    private int size = 5;
    private double scale = 1.0;
    private double growSpeed = 0.01;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            JFrame f = new JFrame();

            GrowingPlantAnimation m = new GrowingPlantAnimation();

            m.setPreferredSize(new Dimension(600, 600));
            f.setTitle("~~~~~~~~~~~~~      FROM BABIES TO.....      ~~~~~~~~~~~~~");
            f.setSize(600, 600);
            f.add(m);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);

            (new Thread(m)).start();

        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage buffer = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = (Graphics2D) buffer.getGraphics();
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON));

        drawFlower(g2);
        g.drawImage(buffer, 0, 0, null);
    }

    public void run() {
        while (true) {
            size += growSpeed * scale;
            if (size > 50 || size < 5) {
                growSpeed = -growSpeed;
            }

            repaint();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void drawFlower(Graphics2D g) {
        int x = getWidth() / 2;
        int y = getHeight() / 2;
        
        int petalSize = (int) (size * scale);
        int stemLength = (int) (50 * scale);
        
        // Adjust position based on growth
        int yOffset = (int) ((size - 5) * scale); // Adjust the yOffset based on the growth of the flower
        
        // Draw stem
        g.setColor(Color.decode("#008000"));
        g.fillRect(x - 2, y + yOffset, 4, -stemLength);
        
        // Draw petals
        g.setColor(Color.decode("#FF69B4"));
        midpointEllipse(g, x - petalSize, y + yOffset - stemLength - petalSize, petalSize * 2, petalSize, 1);
        midpointEllipse(g, x - petalSize, y + yOffset - stemLength - petalSize, petalSize * 2, petalSize, 1);
        
        // Draw center
        g.setColor(Color.decode("#FFFF00"));
        midpointCircle(g, x - size / 2, y + yOffset - stemLength - size / 2, size, 1);
        
        // Update the scale for next iteration
        scale += growSpeed;
    }
    

    private void midpointCircle(Graphics g, int xc, int yc, int r, int size) {
        int x = 0;
        int y = r;
        int dx = 2 * x;
        int dy = 2 * y;
        int d = 1 - r;
        while (x <= y) {
            g.setColor(Color.decode("#000000"));

            plot(g, x + xc, y + yc, size);
            plot(g, x + xc, -y + yc, size);
            plot(g, -x + xc, -y + yc, size);
            plot(g, -x + xc, y + yc, size);
            plot(g, y + xc, x + yc, size);
            plot(g, y + xc, -x + yc, size);
            plot(g, -y + xc, -x + yc, size);
            plot(g, -y + xc, x + yc, size);

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

            plot(g, x + xc, y + yc, size);
            plot(g, x + xc, -y + yc, size);
            plot(g, -x + xc, -y + yc, size);
            plot(g, -x + xc, y + yc, size);

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

            plot(g, x + xc, y + yc, size);
            plot(g, x + xc, -y + yc, size);
            plot(g, -x + xc, -y + yc, size);
            plot(g, -x + xc, y + yc, size);

            y++;
            dy += twoA2;
            d = d + dy + a2;
            if (d >= 0) {
                x--;
                dx -= twoB2;
                d = d - dx;
            }
        }
    }

    private void plot(Graphics g, int x, int y, int size) {
        g.fillRect(x, y, size, size);
    }
}
