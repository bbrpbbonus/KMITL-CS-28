import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawNewYear extends JPanel {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame();

            f.add(new DrawNewYear());
            f.setTitle("New Year theme");
            f.setSize(600, 600);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Color color1 = Color.decode("#7FC7D9"); // Dark Sky Blue
        Color color2 = Color.decode("#365486"); // Metallic Blue
        Color color3 = Color.decode("#0F1035"); // Cetacean Blue

        float[] fractions = { 0.1f, 0.5f, 0.9f };
        Color[] colors = { color1, color2, color3 };

        LinearGradientPaint gradientPaint = new LinearGradientPaint(0, 0, getWidth(), getHeight(), fractions, colors);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(gradientPaint);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        drawSnow(g2d);

        drawSnowman(g2d);

        drawGift(g2d);
    }

    private void drawHeart(Graphics g) {

        g.setColor(Color.RED);

        // สร้างรูปหัวใจด้วยเส้น
        int[] xPoints = { 100, 200, 300 };
        int[] yPoints = { 160, 350, 160 };
        g.fillPolygon(xPoints, yPoints, 3);

        // วาดวงรีบอกบน (สำหรับ Graphics ไม่ใช่ Graphics2D)
        g.fillArc(100, 100, 100, 100, 0, 180);
        g.fillArc(200, 100, 100, 100, 0, 180);
    }

    private void drawCurve(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // ปรับความหนาของเส้น
        float strokeWidth = 5.0f;
        g2d.setStroke(new BasicStroke(strokeWidth));

        // วาดเส้นโค้งด้วย GeneralPath
        g2d.setColor(Color.BLACK);
        GeneralPath curvePath = new GeneralPath();
        int startX = 50;
        int startY = 200;
        int controlX1 = 150;
        int controlY1 = 50;
        int controlX2 = 250;
        int controlY2 = 350;
        int endX = 350;
        int endY = 200;
        curvePath.moveTo(startX, startY);
        curvePath.curveTo(controlX1, controlY1, controlX2, controlY2, endX, endY);
        g2d.draw(curvePath);

        // วาดเส้นโค้งด้วย drawArc()
        g2d.setColor(Color.BLUE);
        int x = 50;
        int y = 50;
        int width = 300;
        int height = 300;
        int startAngle = 45; // มุมเริ่มต้น
        int arcAngle = 90; // มุมของเส้นโค้ง
        g2d.drawArc(x, y, width, height, startAngle, arcAngle);

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

    private void drawOlaf(Graphics g) {
        // Draw Olaf's bottom circle (body)
        g.setColor(Color.WHITE);
        g.fillOval(50, 100, 200, 200);

        // Draw Olaf's middle circle
        g.fillOval(110, 50, 80, 80);

        // Draw Olaf's top circle (head)
        g.fillOval(130, 20, 40, 40);

        // Draw Olaf's eyes
        g.setColor(Color.BLACK);
        g.fillOval(145, 35, 8, 8);
        g.fillOval(165, 35, 8, 8);

        // Draw Olaf's mouth
        g.drawArc(150, 45, 20, 10, 0, -180);

        // Draw Olaf's carrot nose
        g.setColor(new Color(255, 165, 0)); // Orange color
        int[] noseX = { 160, 155, 165 };
        int[] noseY = { 38, 48, 48 };
        g.fillPolygon(noseX, noseY, 3);

        // Draw Olaf's buttons
        g.setColor(Color.BLACK);
        int buttonY = 150;
        for (int i = 0; i < 3; i++) {
            g.fillOval(150, buttonY, 20, 20);
            buttonY += 50;
        }
    }

    private void drawFlowerFirework(Graphics2D g2d, int x, int y, int branches) {
        Random random = new Random();

        int petalCount = 10; // Number of petals in the flower
        int petalSize = 10; // Size of each petal

        for (int i = 0; i < branches; i++) {
            int size = random.nextInt(15) + 5; // Smaller size for a more delicate look

            int offsetX = random.nextInt(100) - 10; // Vary the X position within a smaller range
            int offsetY = random.nextInt(100) - 10; // Vary the Y position within a smaller range

            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);

            g2d.setColor(new Color(red, green, blue));

            // Draw the central circle of the firework
            g2d.fillOval(x + offsetX - size / 2, y + offsetY - size / 2, size, size);

            // Draw petals around the central circle
            for (int j = 0; j < petalCount; j++) {
                double angle = 2 * Math.PI * j / petalCount;
                int petalX = (int) (x + offsetX - size / 2 + size * Math.cos(angle));
                int petalY = (int) (y + offsetY - size / 2 + size * Math.sin(angle));
                g2d.fillOval(petalX - petalSize / 2, petalY - petalSize / 2, petalSize, petalSize);
            }
        }
    }

    // Add this method to the DrawNewYear class
    private void drawSnowman(Graphics2D g2d) {

        
        // Draw snowman's body
        g2d.setColor(Color.WHITE);
        g2d.fillOval(175, 90, 200, 200);
        g2d.fillOval(125, 190, 300, 300);
        g2d.fillOval(75, 340, 400, 400);

        // d ปุ่ม
        g2d.setColor(Color.BLACK);
        g2d.fillOval(260, 260, 40, 40);
        g2d.fillOval(260, 320, 40, 40);
        g2d.fillOval(260, 380, 40, 40);

        // d ตาและปาก
        g2d.fillOval(240, 148, 20, 20);
        g2d.fillOval(295, 148, 20, 20);

        float strokeWidth = 5.0f;
        g2d.setStroke(new BasicStroke(strokeWidth));
        g2d.drawArc(230, 170, 100, 50, 200, 140);

        // d หมวก
        String hexColor = "#65B741"; //Apple
        Color customColor = Color.decode(hexColor);

        g2d.setColor(customColor);
        g2d.fillRect(202, 90, 150, 20);

        String hexColor1 = "#BF3131"; //International Orange (Golden Gate Bridge)
        Color customColor1 = Color.decode(hexColor1);

        g2d.setColor(customColor1);
        int[] hatTopX = { 229, 279, 329 };
        int[] hatTopY = { 90, 10, 90};
        g2d.fillPolygon(hatTopX, hatTopY, 3);

        g2d.setColor(Color.BLACK);
        // d แขน 1
        g2d.drawLine(125, 320, 200, 440);

        // d แขน 2
        g2d.drawLine(425, 320, 350, 440);
    }

    // drawGift ยังไม่เสร็จ
    private void drawGift(Graphics g) {
        String hexColor = "#BF3131"; //International Orange (Golden Gate Bridge)
        Color customColor = Color.decode(hexColor);

        g.setColor(customColor);
        g.fillRect(200, 400, 150, 100);

       
    }

    

}
