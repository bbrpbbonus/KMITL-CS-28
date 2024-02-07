import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.*;
import java.util.Queue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Assignment extends JPanel implements Runnable {

    // private int size = 100;
    // private double circleMove = 0;
    // private int circleDirection = 1;
    // private double circleSpeed = 100;
    // private double circleRotate = 0;
    // private double squareRotate = 0;

    // private double squareY = 600;
    // private double squareSpeed = 100;
    // private boolean startMovingSquare = false;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            JFrame f = new JFrame();

            Assignment m = new Assignment();

            m.setPreferredSize(new Dimension(600, 600));
            f.setTitle("~~~~~~~~~~~~~      FROM BABIES TO.....      ~~~~~~~~~~~~~");
            f.setSize(600, 600);
            f.add(m);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);

            // m.saveImage();
            (new Thread(m)).start();

        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage buffer = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON));

        drawWorm(g2, buffer);
        // g2.translate(circleMove, 0);
        // g2.drawOval(0, 400, 100, 100);
        // g2.translate(-circleMove, 0);

        // g2.rotate(circleRotate, 300, 300);
        // g2.drawOval(0, 200, size, size);

        // g2.rotate(-squareRotate, 300, 300);
        // g2.drawRect(2, (int) squareY, size, size);
        g.drawImage(buffer, 0, 0, null);
    }

    

    // worm
    private void drawWorm(Graphics g2, BufferedImage buffer) {
  
        // plotdot(g2, 40, 410, 2);

        // body
        midpointCircle(g2, 50, 400, 30, 1);
        midpointCircle(g2, 80, 400, 30, 1);
        midpointCircle(g2, 110, 400, 30, 1);
        midpointCircle(g2, 140, 400, 30, 1);
        midpointCircle(g2, 170, 400, 30, 1);
        // head
        midpointCircle(g2, 200, 380, 30, 1);

        floodfill(buffer, 50, 400, Color.WHITE,Color.decode("#436850"));
        // floodfill(buffer, 50, 400, Color.WHITE,Color.BLUE);

    }

    public void run() {
        // double lastTime = System.currentTimeMillis();
        // double currentTime, elapsedTime;

        // while (true) {
        //     currentTime = System.currentTimeMillis();
        //     elapsedTime = currentTime - lastTime;
        //     lastTime = currentTime;

        //     if (currentTime >= 3000) {
        //         startMovingSquare = true;
        //     }

        //     circleMove += circleDirection * circleSpeed * elapsedTime / 1000.0;
        //     if (circleMove >= getWidth() - size) {
        //         circleMove = getWidth() - size;
        //         circleDirection = -1;
        //     } else if (circleMove <= 0) {
        //         circleMove = 0;
        //         circleDirection = 1;
        //     }

        //     if (startMovingSquare) {
        //         squareY -= squareSpeed * elapsedTime / 1000.0;
        //         if (squareY <= 0) {
        //             squareY = 0;
        //         }
        //     }

        //     circleRotate += 0.5 * elapsedTime / 1000.0;

        //     // Display
        //     repaint();

        //     try {
        //         Thread.sleep(10);
        //     } catch (InterruptedException e) {
        //         e.printStackTrace();
        //     }
        // }
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

   

    private void bresenhamLine(Graphics g, int x1, int y1, int x2, int y2) {
        double dx = Math.abs(x2 - x1);
        double dy = Math.abs(y2 - y1);

        double sx = (x1 < x2) ? 1 : -1;
        double sy = (y1 < y2) ? 1 : -1;

        boolean isSwap = false;

        if (dy > dx) {
            double dd = dx;
            dx = dy;
            dy = dd;
            isSwap = true;
        }

        double D = 2 * dy - dx;
        double x = x1;
        double y = y1;

        for (int i = 1; i < dx; i++) {
            plot(g, (int) x, (int) y, 3);

            if (D >= 0) {
                if (isSwap) {
                    x += sx;
                } else {
                    y += sy;
                }
                D -= 2 * dx;
            }

            if (isSwap) {
                y += sy;
            } else {
                x += sx;
            }

            D += 2 * dy;
        }
    }

    private void bezierCurve(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        for (int i = 0; i <= 1000; i++) {
            double t = i / 1000.0;

            int x = (int) (Math.pow((1 - t), 3) * x1 +
                    3 * t * Math.pow((1 - t), 2) * x2 +
                    3 * Math.pow(t, 2) * (1 - t) * x3 +
                    Math.pow(t, 3) * x4);

            int y = (int) (Math.pow((1 - t), 3) * y1 +
                    3 * t * Math.pow((1 - t), 2) * y2 +
                    3 * Math.pow(t, 2) * (1 - t) * y3 +
                    Math.pow(t, 3) * y4);

                    plot(g, x, y, 3);
        }
    }
    private BufferedImage floodfill(BufferedImage m, int x, int y, Color targetColor, Color replacementColor) {
        Graphics2D g2 = m.createGraphics();
        Queue<Point> q = new LinkedList<Point>();

        if (m.getRGB(x, y) == targetColor.getRGB()) {
            g2.setColor(replacementColor);
            plot(g2, x, y, 1);
            q.add(new Point(x, y));
        }

        while (!q.isEmpty()) {
            Point p = q.poll();

            // South
            if (p.y < 600 && m.getRGB(p.x, p.y + 1) == targetColor.getRGB()) {
                g2.setColor(replacementColor);
                plot(g2, p.x, p.y + 1, 1);
                q.add(new Point(p.x, p.y + 1));
            }

            // North
            if (p.y > 0 && m.getRGB(p.x, p.y - 1) == targetColor.getRGB()) {
                g2.setColor(replacementColor);
                plot(g2, p.x, p.y - 1, 1);
                q.add(new Point(p.x, p.y - 1));
            }

            // East
            if (p.x < 600 && m.getRGB(p.x + 1, p.y) == targetColor.getRGB()) {
                g2.setColor(replacementColor);
                plot(g2, p.x + 1, p.y, 1);
                q.add(new Point(p.x + 1, p.y));
            }

            // West
            if (p.x > 0 && m.getRGB(p.x - 1, p.y) == targetColor.getRGB()) {
                g2.setColor(replacementColor);
                plot(g2, p.x - 1, p.y, 1);
                q.add(new Point(p.x - 1, p.y));
            }
        }

        return m;
    }

    private void plot(Graphics g, int x, int y, int size) {
        g.fillRect(x, y, size, size);
    }


}
