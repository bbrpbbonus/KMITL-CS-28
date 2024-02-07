import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Assment_2_65050492_65050579 extends JPanel implements Runnable {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private static final int DELAY = 50;
    private int stemX = WIDTH / 2;
    private int stemY = HEIGHT - 2;
    private int ellisesX = 150;
    private int ellisesY = 350;
    private int circleRadius = 0;
    private Queue<Point> rainDrops = new LinkedList<>();
    private long rainFullTime;
    private boolean startStem = false;
    private boolean startMovingSeeds = false;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Flower Animation");
            Assment_2_65050492_65050579 animation = new Assment_2_65050492_65050579();
            frame.add(animation);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            animation.startRainFall();

            Thread thread = new Thread(animation);
            thread.start();
        });
    }

    public Assment_2_65050492_65050579() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage buffer = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = buffer.createGraphics();

        g2d.setColor(Color.decode("#C9D7DD")); // Columbia Blue
        g2d.fillRect(0, 0, WIDTH, HEIGHT);

        drawSeeds(g2d, buffer);

        if (startStem) {
            g2d.setColor(Color.GREEN);
            g2d.fillRect(stemX - 15, stemY, 30, 300);
            repaint();
        }

        if (stemY <= 300) {
            g2d.setColor(Color.YELLOW);
            midpointCircle(g2d, 300, 300, circleRadius, 2);
            floodfill(buffer, 300, 300, Color.GREEN, Color.YELLOW);
            floodfill(buffer, 270, 300, Color.decode("#C9D7DD"), Color.YELLOW);
            repaint();
        }

        drawRain(g2d);

        g2d.setColor(Color.PINK);
        drawEllipse(g2d, WIDTH / 2, 300, 50, 100);

        g.drawImage(buffer, 0, 0, null);
    }

    private void drawSeeds(Graphics2D g2d, BufferedImage buffer) {
        if (!startStem) {
            g2d.setColor(Color.decode("#503C3C")); // Dark Puce
            midpointEllipse(g2d, ellisesX, ellisesY, 15, 3, 2, buffer);
        }
    }

    private void drawEllipse(Graphics2D g2d, int centerX, int centerY, int a, int b) {
        int x = 0, y = b;
        int a2 = a * a;
        int b2 = b * b;
        int crit1 = -a2 * (2 * b + 1);
        int crit2 = -b2 * (2 * a + 1);
        int crit3 = -b2 * (2 * a + 1) + a2;
        int t = -a2 * 2 * y;
        int dxt = 0, dyt = -a2 * 2 * y, d2xt = 2 * b2, d2yt = -2 * a2;
        while (y >= 0 && x <= a) {
            g2d.drawLine(centerX + x, centerY + y, centerX + x, centerY + y);
            g2d.drawLine(centerX - x, centerY + y, centerX - x, centerY + y);
            g2d.drawLine(centerX + x, centerY - y, centerX + x, centerY - y);
            g2d.drawLine(centerX - x, centerY - y, centerX - x, centerY - y);
            if (t + b2 * x <= crit1 || t + a2 * y <= crit2) {
                x++;
                dxt += d2xt;
                t += dxt;
            } else if (t - a2 * (y - 1) >= crit3) {
                y--;
                dyt += d2yt;
                t += dyt;
            } else {
                x++;
                dxt += d2xt;
                t += dxt;
                y--;
                dyt += d2yt;
                t += dyt;
            }
        }
    }

    private void drawRain(Graphics2D g2d) {
        Random random = new Random();

        g2d.setColor(Color.BLUE);
        for (int i = 0; i < 50; i++) {
            int x = random.nextInt(getWidth());
            int y = random.nextInt(getHeight());
            int size = random.nextInt(5) + 2; // Snowflake size between 2 and 6

            midpointCircle(g2d, x, y, 1, 2);
        }
    }

    private void startRainFall() {
        rainFullTime = System.currentTimeMillis();
        Timer timer = new Timer(100, e -> {
            repaint();
        });
        timer.start();
    }

    @Override
    public void run() {
        double lastTime = System.currentTimeMillis();
        double currentTime, elapsedTime;

        try {
            // Wait for 1 second before starting to draw the seed
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        while (true) {
            currentTime = System.currentTimeMillis();
            elapsedTime = currentTime - lastTime;
            lastTime = currentTime;

            if (currentTime >= rainFullTime + 1000) {
                startMovingSeeds = true;
            }

            ellisesX += 6;
            ellisesY += 10;

            if (ellisesY == 610) {
                startStem = true;
            }

            if (startStem) {
                stemY -= 10;
            }

            if (stemY <= 300) {
                for (int i = 0; i <= 50; i++) {
                    circleRadius += 1;
                }
            }

            if (stemY <= 300) {
                break;
            }

            if (Math.random() < 0.1) {
                int randomX = (int) (Math.random() * WIDTH);
                rainDrops.add(new Point(randomX, 0));
            }

            for (Point rainDrop : rainDrops) {
                rainDrop.y += 5;
                rainDrop.x -= 2;
            }

            rainDrops.removeIf(drop -> drop.y > HEIGHT || drop.x < 0);

            // Show FPS
            getToolkit().sync();
            System.out.println("FPS: " + (1000 / elapsedTime));

            repaint();

            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            // Loop after 1 second
            int TIMER = 100;
            
            try {
                Thread.sleep(TIMER);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            TIMER += 10;
        }
    }

    private void midpointCircle(Graphics g, int xc, int yc, int r, int size) {
        int x = 0;
        int y = r;
        int dx = 2 * x;
        int dy = 2 * y;
        int d = 1 - r;
        while (x <= y) {

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

    private void midpointEllipse(Graphics g, int xc, int yc, int a, int b, int size, BufferedImage buffer) {
        int a2 = a * a, b2 = b * b;
        int twoA2 = 2 * a2, twoB2 = 2 * b2;

        int x = 0;
        int y = b;
        int d = Math.round(b2 - a2 * b + a2 / 4);
        int dx = 0, dy = twoA2 * y;
        while (dx <= dy) {

            g.drawLine(x + xc, y + yc, x + xc, -y + yc);
            g.drawLine(-x + xc, y + yc, -x + xc, -y + yc);
            g.drawLine(x + xc, -y + yc, -x + xc, -y + yc);
            g.drawLine(-x + xc, -y + yc, -x + xc, y + yc);

            x++;
            dx += twoB2;
            d = d + dx + b2;

            if (d >= 0) {
                y--;
                dy -= twoA2;
                d = d - dy;
            }
        }

        x = a;
        y = 0;
        d = Math.round(a2 - b2 * a + b2 / 4);
        dx = twoB2 * x;
        dy = 0;
        while (dx >= dy) {

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

            if (p.y < 600 && m.getRGB(p.x, p.y + 1) == targetColor.getRGB()) {
                g2.setColor(replacementColor);
                plot(g2, p.x, p.y + 1, 1);
                q.add(new Point(p.x, p.y + 1));
            }

            if (p.y > 0 && m.getRGB(p.x, p.y - 1) == targetColor.getRGB()) {
                g2.setColor(replacementColor);
                plot(g2, p.x, p.y - 1, 1);
                q.add(new Point(p.x, p.y - 1));
            }

            if (p.x < 600 && m.getRGB(p.x + 1, p.y) == targetColor.getRGB()) {
                g2.setColor(replacementColor);
                plot(g2, p.x + 1, p.y, 1);
                q.add(new Point(p.x + 1, p.y));
            }

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
