import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.util.Random;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

class GraphicsSwing extends JPanel {
    public static void main(String[] args) {
        GraphicsSwing m = new GraphicsSwing();

        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("New Year theme");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int centerX1 = getWidth() - 500;
        int centerY1 = getHeight() - 480;
        int centerX2 = getWidth() - 80; // ปรับตำแหน่ง X ของ Lotus 2
        int centerY2 = getHeight() - 480; // ปรับตำแหน่ง Y ของ Lotus 2
        drawLotus(g2d, centerX1, centerY1, centerX2, centerY2);

        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 50);
        g.setFont(font);
        g.setColor(Color.BLACK);
        String message = "Happy New Year!";
        int messageWidth = g.getFontMetrics().stringWidth(message);
        int x = (getWidth() - messageWidth) / 2;
        int y = (getHeight() / 6);
        g.drawString(message, x, y);

        Color Axolotl = Color.decode("#618264");
        g.setColor(Axolotl);
        g.fillRect(125, 200, 350, 50);
        g.fillRect(150, 250, 300, 250);

        // int [] xPoints = {45, 55, 75, 55, 63, 43, 17, 31, 12, 35, 45};
        // int [] yPoints = {41, 65, 71, 83, 108, 88, 105, 78, 61, 63,41};
        int[] xPoints = { 150, 150, 200, 250 };
        int[] yPoints = { 350, 300, 250, 250 };
        Color KombuGreen = Color.decode("#304D30");
        g.setColor(KombuGreen);
        g.drawPolygon(xPoints, yPoints, 4);
        g.fillPolygon(xPoints, yPoints, 4);

        g.setColor(new Color(48, 77, 48, 128));
        g.fillRect(150, 250, 300, 25);

        g.setColor(Color.RED);
        g.fillRect(280, 200, 50, 300);

        int xDiameter = 250; // พิกัด x ของจุดกึ่งกลางของวงรี
        int yDiameter = 350; // พิกัด y ของจุดกึ่งกลางของวงรี
        int diameter = 50; // ขนาดของวงรี

        // เติมสีในวงรีด้วย fillOval
        // g.setColor(Color.RED); // เลือกสีที่ต้องการ
        // g.fillOval(xDiameter - diameter / 2, yDiameter - diameter / 2, diameter - 20,
        // diameter + 75);

        // String message = "Happy New Year!";
        // g.drawString("Happy New Year!", getWidth()/2, getHeight()/4);
        // g.setColor(Color.BLUE);

        // g.setColor(Color.GREEN);
        // g.fillRect(150, 250, 300, 250);
        // g.drawOval(30, 130, 50, 60);
        // g.setColor(Color.RED);
        // g.drawLine(0, 0, 200, 30);
        // g.fillOval(130, 130, 50, 60);
        // g.drawArc(30, 200, 40, 50, 90, 60);
        // g.fillArc(30, 130, 40, 50, 180, 40);
        // for (int i = 0; i < 10; i++) {
        // this.plot(g, 150 + (i * 20), 300 + (i * 20)) ;
        // }
    }
    // public void paintComponent(Graphics g) {
    // int [] x = {45, 55, 75, 55, 63, 43, 17, 31, 12, 35, 45};
    // int [] y = {41, 65, 71, 83, 108, 88, 105, 78, 61, 63,41};
    // g.drawPolygon(x, y, 10);
    // g.setColor(Color.BLUE);
    // g.fillPolygon(x, y, 10);
    // //Polygon p = new Polygon();
    // //g.fillPolygon(p);
    // }

    // private void drawLotus(Graphics2D g2d) {
    // int centerX = getWidth() - 500;
    // int centerY = getHeight() - 440;

    // int petalCount = 10;
    // int petalLength = 50;
    // int petalWidth = 20;

    // g2d.setColor(Color.PINK);

    // for (int i = 0; i < petalCount; i++) {
    // drawPetal(g2d, centerX, centerY, i * (360 / petalCount), petalLength,
    // petalWidth);
    // }
    // }

    private void drawLotus(Graphics2D g2d, int centerX1, int centerY1, int centerX2, int centerY2) {
        int petalCount = 10;
        int petalLength = 50;
        int petalWidth = 20;

        g2d.setColor(Color.PINK);

        // Draw Lotus 1
        for (int i = 0; i < petalCount; i++) {
            drawPetal(g2d, centerX1, centerY1, i * (360 / petalCount), petalLength, petalWidth);
        }
        // Draw Lotus 2
        for (int i = 0; i < petalCount; i++) {
            drawPetal(g2d, centerX2, centerY2, i * (360 / petalCount), petalLength, petalWidth);
        }
    }

    private void drawPetal(Graphics2D g2d, int x, int y, int angle, int length, int width) {
        g2d.rotate(Math.toRadians(angle), x, y);

        GeneralPath petal = new GeneralPath();
        petal.moveTo(x, y);
        petal.quadTo(x - width / 2, y + length / 2, x, y + length);
        petal.quadTo(x + width / 2, y + length / 2, x, y);

        g2d.fill(petal);

        g2d.rotate(Math.toRadians(-angle), x, y);
    }

}