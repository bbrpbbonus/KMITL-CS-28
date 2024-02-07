import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.LinkedList;
import java.util.Random;
import java.util.Queue;

public class Assignment1_65050492_65050579 extends JPanel {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame();
            
            Assignment1_65050492_65050579 m = new Assignment1_65050492_65050579();
            m.setPreferredSize(new Dimension(600, 600));
            f.setTitle(" ==> OLAF <==");
            f.setSize(600, 600);
            f.add(m);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);

            m.saveImage();

        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        BufferedImage buffer = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = buffer.createGraphics();

        g2d.setColor(Color.decode("#B4D4FF")); // Pale Cornflower Blue
        g2d.fillRect(0, 0, 600, 600);

        drawSnow(g2d);

        drawOlaf(g2d, buffer);

        drawTree(g2d, buffer);

        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Helvetica", Font.ITALIC, 55));
        String text = "Happy New Year";
        int x = getWidth() / 6 - 4;
        int y = 80;
        int x2 = getWidth() / 6;
        int y2 = 80;
        g2d.drawString(text, x, y);
        g2d.setColor(Color.decode("#E36414"));
        g2d.drawString(text, x2, y2);

        g.drawImage(buffer, 0, 0, null);
    }

    private void drawSnow(Graphics2D g2d) {
        Random random = new Random();
        g2d.setColor(Color.WHITE);
        for (int i = 0; i < 100; i++) {
            int x = random.nextInt(getWidth());
            int y = random.nextInt(getHeight());
            int size = random.nextInt(5) + 2; // Snowflake size between 2 and 6
            
            // ปรับความเร็วของ snowflake โดยการเพิ่มหรือลดค่า x และ y ที่สุ่มได้
            int deltaX = random.nextInt(3) - 1; // -1, 0, 1
            int deltaY = random.nextInt(3) - 1; // -1, 0, 1
            
            // ตรวจสอบให้แน่ใจว่า snowflake ไม่ออกนอกขอบหน้าจอ
            x = Math.max(0, Math.min(getWidth() - size, x + deltaX));
            y = Math.max(0, Math.min(getHeight() - size, y + deltaY));
            
            g2d.fillOval(x, y, size, size);
        }
    }

    private void drawOlaf(Graphics g2d, BufferedImage buffer) {
        // เท้าซ้าย
        g2d.setColor(Color.BLACK);
        bezierCurve(g2d, 236, 453, 200, 500, 315, 500, 280, 456);
        bezierCurve(g2d, 236, 453, 238, 465, 295, 455, 280, 456);
        floodfill(buffer, 240, 470, Color.decode("#B4D4FF"), Color.WHITE);

        // เท้าขวา
        bezierCurve(g2d, 353, 404, 400, 450, 440, 350, 365, 375);
        bezierCurve(g2d, 354, 404, 363, 400, 371, 362, 366, 375);
        floodfill(buffer, 360, 404, Color.decode("#B4D4FF"), Color.WHITE);

        // ตัวส่วนที่ 3
        g2d.setColor(Color.BLACK);
        bezierCurve(g2d, 218, 360, 180, 485, 295, 470, 330, 430);
        bezierCurve(g2d, 330, 430, 360, 415, 410, 330, 295, 310);
        g2d.setColor(Color.WHITE);
        bezierCurve(g2d, 218, 360, 272, 340, 250, 346, 295, 310);
        floodfill(buffer, 240, 404, Color.decode("#B4D4FF"), Color.WHITE);

        // ตัวส่วนที่ 2
        g2d.setColor(Color.BLACK);
        bezierCurve(g2d, 225, 285, 170, 290, 195, 397, 255, 343);
        bezierCurve(g2d, 255, 343, 320, 300, 287, 295, 270, 290);
        g2d.setColor(Color.WHITE);
        bezierCurve(g2d, 225, 285, 250, 290, 270, 295, 270, 290);
        floodfill(buffer, 250, 300, Color.decode("#B4D4FF"), Color.WHITE);

        // เส้นผม
        g2d.setColor(Color.decode("#76453B")); // Bole
        bezierCurve(g2d, 345, 115, 375, 90, 365, 50, 360, 30);
        bezierCurve(g2d, 340, 115, 360, 90, 340, 50, 330, 70);
        bezierCurve(g2d, 340, 115, 360, 90, 360, 50, 350, 70);
        bezierCurve(g2d, 352, 120, 370, 80, 400, 60, 410, 100);

        // ส่วนหัว
        g2d.setColor(Color.BLACK);
        bezierCurve(g2d, 278, 136, 360, 85, 365, 130, 355, 190);
        bezierCurve(g2d, 278, 136, 260, 140, 260, 130, 235, 190);
        bezierCurve(g2d, 355, 190, 380, 205, 328, 270, 270, 290);
        bezierCurve(g2d, 235, 190, 223, 285, 210, 295, 270, 290);
        floodfill(buffer, 270, 150, Color.decode("#B4D4FF"), Color.WHITE);

        // ปาก
        g2d.setColor(Color.WHITE);
        bezierCurve(g2d, 280, 200, 280, 205, 300, 225, 318, 225);
        g2d.setColor(Color.BLACK);
        bezierCurve(g2d, 262, 170, 225, 280, 275, 285, 335, 230);
        bezierCurve(g2d, 280, 150, 268, 138, 225, 150, 300, 217);
        bezierCurve(g2d, 342, 195, 370, 195, 365, 260, 300, 217);
        bezierCurve(g2d, 261, 170, 280, 198, 280, 215, 336, 230);
        floodfill(buffer, 275, 250, Color.WHITE, Color.decode("#E0E0EC")); // Platinum

        g2d.setColor(Color.decode("#E5E1DA")); // White Coffee
        bezierCurve(g2d, 240, 255, 250, 275, 260, 285, 285, 275);

        // ฟัน
        g2d.setColor(Color.BLACK);
        bezierCurve(g2d, 280, 200, 255, 220, 320, 260, 318, 225);

        floodfill(buffer, 284, 215, Color.decode("#E0E0EC"), Color.WHITE); // Platinum
        // ตาซ้าย
        g2d.setColor(Color.BLACK);
        midpointCircle(g2d, 310, 148, 16, 2);
        midpointCircle(g2d, 310, 150, 8, 2);
        floodfill(buffer, 310, 155, Color.WHITE, Color.BLACK);

        // ตาขวา
        g2d.setColor(Color.BLACK);
        midpointCircle(g2d, 338, 163, 15, 2);
        midpointCircle(g2d, 335, 165, 8, 2);
        floodfill(buffer, 335, 165, Color.WHITE, Color.BLACK);

        // กระดุม 1
        g2d.setColor(Color.BLACK);
        bezierCurve(g2d, 239, 310, 252, 340, 272, 315, 267, 310);
        bezierCurve(g2d, 239, 310, 245, 300, 260, 287, 267, 310);
        floodfill(buffer, 253, 310, Color.WHITE, Color.BLACK);

        // กระดุม 2
        g2d.setColor(Color.BLACK);
        bezierCurve(g2d, 260, 380, 258, 372, 275, 350, 292, 370);
        bezierCurve(g2d, 260, 380, 270, 397, 290, 390, 293, 370);
        floodfill(buffer, 285, 370, Color.WHITE, Color.BLACK);

        // กระดุม 3
        g2d.setColor(Color.BLACK);
        bezierCurve(g2d, 302, 415, 296, 388, 315, 385, 326, 392);
        bezierCurve(g2d, 302, 415, 319, 423, 328, 410, 326, 392);
        floodfill(buffer, 315, 400, Color.WHITE, Color.BLACK);

        // จมูก
        Color customColor1 = Color.decode("#E36414"); // Metallic Orange
        g2d.setColor(customColor1);
        int[] noseTopX = { 310, 320, 375 };
        int[] noseTopY = { 190, 165, 205 };
        g2d.fillPolygon(noseTopX, noseTopY, 3);
        bezierCurve(g2d, 320, 165, 320, 160, 290, 180, 310, 185);
        bresenhamLine(g2d, 310, 185, 320, 170);
        floodfill(buffer, 315, 170, Color.WHITE, Color.decode("#E36414"));

        // คิ้ว
        g2d.setColor(Color.decode("#76453B")); // Bole
        bezierCurve(g2d, 310, 125, 320, 120, 330, 120, 335, 125);
        bezierCurve(g2d, 345, 130, 355, 130, 360, 140, 355, 155);

        // แขนซ้าย
        g2d.setColor(Color.decode("#76453B")); // Bole
        bresenhamLine2(g2d, 202, 290, 180, 180);

        // แขนขวา
        g2d.setColor(Color.decode("#76453B")); // Bole
        bresenhamLine2(g2d, 287, 295, 383, 247);

        // นิ้วมือ ซ้าย
        g2d.setColor(Color.decode("#76453B")); // Bole
        bresenhamLine(g2d, 179, 182, 170, 168);
        bresenhamLine(g2d, 183, 182, 182, 162);
        bresenhamLine(g2d, 185, 185, 195, 167);
        bresenhamLine(g2d, 188, 198, 198, 188);

        // นิ้วมือ ขวา
        g2d.setColor(Color.decode("#76453B")); // Bole
        bresenhamLine(g2d, 370, 255, 365, 245);
        bresenhamLine(g2d, 380, 245, 385, 230);
        bresenhamLine(g2d, 385, 247, 400, 236);
        bresenhamLine(g2d, 385, 252, 400, 250);
    }

    private void drawTree(Graphics g2d, BufferedImage buffer) {

        // g2d.setColor(Color.RED);
        // plot(g2d, 50, 200, 3);
        g2d.setColor(Color.decode("#43766C"));
        bresenhamLine2(g2d, 0, 110, 0, 400);
        // ส่วนบนสุด
        bezierCurve2(g2d, 0, 110, 20, 30, 50, 190, 100, 200);
        bresenhamLine2(g2d, 0, 200, 100, 200);
        floodfill(buffer, 10, 110, Color.decode("#B4D4FF"), Color.decode("#43766C"));
        // ส่วนกลาง
        bezierCurve2(g2d, 75, 200, 90, 250, 120, 290, 150, 300);
        bresenhamLine2(g2d, 0, 300, 150, 300);
        floodfill(buffer, 10, 280, Color.decode("#B4D4FF"), Color.decode("#43766C"));

        // g2d.setColor(Color.BLACK);
        bezierCurve2(g2d, 120, 300, 130, 330, 150, 390, 200, 400);
        bresenhamLine2(g2d, 0, 400, 200, 400);
        floodfill(buffer, 10, 390, Color.decode("#B4D4FF"), Color.decode("#43766C"));
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

    private void bresenhamLine2(Graphics g, int x1, int y1, int x2, int y2) {
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
            plot(g, (int) x, (int) y, 6);

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

    private void bezierCurve2(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
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

            plot(g, x, y, 5);
        }
    }

    private void midpointCircle(Graphics g2d, int xc, int yc, int r, int size) {
        int x = 0;
        int y = r;
        int dx = 2 * x;
        int dy = 2 * y;
        int d = 1 - r;
        while (x <= y) {
            plot(g2d, x + xc, y + yc, size);
            plot(g2d, x + xc, -y + yc, size);
            plot(g2d, -x + xc, -y + yc, size);
            plot(g2d, -x + xc, y + yc, size);
            plot(g2d, y + xc, x + yc, size);
            plot(g2d, y + xc, -x + yc, size);
            plot(g2d, -y + xc, -x + yc, size);
            plot(g2d, -y + xc, x + yc, size);

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

    private void saveImage() {
        BufferedImage imageBuffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = imageBuffer.createGraphics();

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        paintComponent(g2d);

        g2d.dispose();

        try {
            ImageIO.write(imageBuffer, "png", new File("Assignment1_65050492_65050579.png"));
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

}