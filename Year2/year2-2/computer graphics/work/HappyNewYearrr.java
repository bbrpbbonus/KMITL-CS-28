import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Random;
import java.util.Queue;

public class HappyNewYearrr extends JPanel {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame();

            f.add(new HappyNewYearrr());
            f.setTitle("New Year theme Olaf");
            f.setSize(600, 600);

            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        BufferedImage buffer = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = buffer.createGraphics();

        // Color color1 = Color.decode("#7FC7D9"); // Dark Sky Blue
        // Color color2 = Color.decode("#365486"); // Metallic Blue
        // Color color3 = Color.decode("#0F1035"); // Cetacean Blue

        // float[] fractions = { 0.1f, 0.5f, 0.9f };
        // Color[] colors = { color1, color2, color3 };

        // LinearGradientPaint gradientPaint = new LinearGradientPaint(0, 0, getWidth(),
        // getHeight(), fractions, colors);

        // g2d.setPaint(gradientPaint);
        // g2d.fillRect(0, 0, getWidth(), getHeight());

        g2d.setColor(Color.GRAY);
        g2d.fillRect(0, 0, 600, 600);

        drawSnow(g2d);

        drawSnowman(g2d, buffer);

        drawGift(g2d, buffer);

        g.drawImage(buffer, 0, 0, null);
    }

    private void drawSnow(Graphics2D g2d) {
        Random random = new Random();
        g2d.setColor(Color.WHITE);
        for (int i = 0; i < 100; i++) {
            int x = random.nextInt(getWidth());
            int y = random.nextInt(getHeight());
            int size = random.nextInt(5) + 2; // Snowflake size between 2 and 6
            g2d.fillOval(x, y, size, size);
        }
    }

    // Add this method to the DrawNewYear class
    private void drawSnowman(Graphics2D g2d, BufferedImage buffer) {

        // Draw snowman's body
        // g2d.setColor(Color.red);
        // plot(g2d, 180, 200, 5);

        g2d.setColor(Color.WHITE);
        bezierCurve(g2d, 175, 200, 175, 55, 375, 55, 375, 200);
        bezierCurve(g2d, 175, 200, 190, 320, 360, 320, 375, 200);
        floodfill(buffer, 181, 200, Color.GRAY, Color.WHITE);

        g2d.setColor(Color.WHITE);
        bezierCurve(g2d, 125, 335, 140, 140, 415, 140, 425, 335);
        bezierCurve(g2d, 125, 335, 130, 540, 415, 540, 425, 335);
        floodfill(buffer, 130, 335, Color.GRAY, Color.WHITE);

        g2d.setColor(Color.WHITE);
        bezierCurve(g2d, 75, 600, 45, 255, 505, 255, 475, 600);
        bresenhamLine(g2d, 75, 560, 475, 560);
        floodfill(buffer, 80, 550, Color.GRAY, Color.WHITE);
        // ปาก
        g2d.setColor(Color.BLACK);
        bezierCurve(g2d, 230, 200, 260, 230, 300, 230, 330, 200);

        // กระดุม
        // 1
        bezierCurve(g2d, 260, 280, 265, 255, 295, 255, 300, 280);
        bezierCurve(g2d, 260, 280, 265, 305, 295, 305, 300, 280);
        floodfill(buffer, 265, 280, Color.WHITE, Color.BLACK);

        // 2
        bezierCurve(g2d, 260, 340, 265, 315, 295, 315, 300, 340);
        bezierCurve(g2d, 260, 340, 265, 365, 295, 365, 300, 340);
        floodfill(buffer, 265, 340, Color.WHITE, Color.BLACK);

        // 3
        bezierCurve(g2d, 260, 400, 260, 370, 300, 370, 300, 400);

        // ตาซ้าย
        g2d.setColor(Color.BLACK);
        bezierCurve(g2d, 240, 160, 240, 145, 260, 145, 260, 160);
        bezierCurve(g2d, 240, 160, 240, 175, 260, 175, 260, 160);
        floodfill(buffer, 250, 160, Color.WHITE, Color.BLACK);
        g2d.setColor(Color.WHITE);
        plot(g2d, 248, 160, 10);

        // ตาขวา

        g2d.setColor(Color.BLACK);
        bezierCurve(g2d, 295, 160, 295, 145, 315, 145, 315, 160);
        bezierCurve(g2d, 295, 160, 295, 175, 315, 175, 315, 160);
        floodfill(buffer, 300, 160, Color.WHITE, Color.BLACK);
        g2d.setColor(Color.WHITE);
        plot(g2d, 300, 160, 10);
        // d หมวก

        Color customColor = Color.decode("#65B741"); // Apple
        g2d.setColor(customColor);
        bresenhamLine(g2d, 202, 90, 352, 90);
        bresenhamLine(g2d, 202, 90, 202, 110);
        bresenhamLine(g2d, 352, 90, 352, 110);
        bresenhamLine(g2d, 202, 110, 354, 110);
        floodfill(buffer, 210, 95, Color.GRAY, Color.decode("#65B741"));
        floodfill(buffer, 340, 95, Color.GRAY, Color.decode("#65B741"));
        floodfill(buffer, 255, 95, Color.WHITE, Color.decode("#65B741"));

        String hexColor1 = "#BF3131"; // International Orange (Golden Gate Bridge)
        Color customColor1 = Color.decode(hexColor1);
        g2d.setColor(customColor1);
        int[] hatTopX = { 229, 279, 329 };
        int[] hatTopY = { 90, 10, 90 };
        g2d.fillPolygon(hatTopX, hatTopY, 3);

        // // d แขน 1
        g2d.setColor(Color.BLACK);
        bresenhamLine(g2d, 125, 320, 200, 440);

        // // d แขน 2
        bresenhamLine(g2d, 425, 320, 350, 440);
    }

    // drawGift ยังไม่เสร็จ
    private void drawGift(Graphics g, BufferedImage buffer) {

        String hexColor = "#BF3131"; // International Orange (Golden Gate Bridge)
        Color customColor = Color.decode(hexColor);
        g.setColor(Color.RED);
        bresenhamLine(g, 200, 400, 350, 400);
        bresenhamLine(g, 200, 400, 200, 500);
        bresenhamLine(g, 350, 400, 350, 500);
        bresenhamLine(g, 200, 500, 350, 500);
        g.setColor(customColor);
        // floodfill(buffer,200, 400, Color.decode("#BF3131"), 100);

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

    private void plot(Graphics g, int x, int y, int size) {
        g.fillRect(x, y, size, size);
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
}
