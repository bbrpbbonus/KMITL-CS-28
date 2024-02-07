import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

class main extends JPanel {

    private BufferedImage backgroundImage;

    public main() {
        try {
            // Load the background image from a file
            backgroundImage = ImageIO.read(new File("Jii.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame();
            
            f.add(new ClearCode());
            f.setTitle("New Year theme");
            f.setSize(600, 600);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background image
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }

        Graphics2D g2d = (Graphics2D) g;

        int centerX1 = getWidth() - 500;
        int centerY1 = getHeight() - 480;
        int centerX2 = getWidth() - 80;
        int centerY2 = getHeight() - 480;

        drawLotus(g2d, centerX1, centerY1);
        drawLotus(g2d, centerX2, centerY2);

        drawMessage(g);

        drawBox(g);

        drawRectangle(g);

        drawRectangle2(g);

        drawRectangle3(g);

        drawRectangle4(g);

        drawRectangle5(g);

        drawRedBar(g);

        // drawCircle(g);
    }

    private void drawLotus(Graphics2D g2d, int centerX, int centerY) {
        int petalCount = 10;
        int petalLength = 50;
        int petalWidth = 20;

        g2d.setColor(Color.PINK);

        for (int i = 0; i < petalCount; i++) {
            drawPetal(g2d, centerX, centerY, i * (360 / petalCount), petalLength, petalWidth);
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

    private void drawMessage(Graphics g) {
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 50);
        g.setFont(font);
        g.setColor(Color.BLACK);

        String message = "Happy New Year!";
        int messageWidth = g.getFontMetrics().stringWidth(message);
        int x = (getWidth() - messageWidth) / 2;
        int y = getHeight() / 6;
        g.drawString(message, x, y);
    }

    private void drawBox(Graphics g) {
        Color Axolotl = Color.decode("#618264");
        g.setColor(Axolotl);
        g.fillRect(125, 200, 350, 50);
        g.fillRect(150, 250, 300, 250);
        g.setColor(new Color(48, 77, 48, 128));
        g.fillRect(150, 250, 300, 25);
    }

    private void drawRectangle(Graphics g) {
        int[] xPoints = { 150, 150, 200, 250 };
        int[] yPoints = { 350, 300, 250, 250 };
        Color KombuGreen = Color.decode("#304D30");
        g.setColor(KombuGreen);
        g.drawPolygon(xPoints, yPoints, 4);
        g.fillPolygon(xPoints, yPoints, 4);
    }

    private void drawRectangle2(Graphics g) {
        int[] xPoints = { 150, 150, 300, 350 };
        int[] yPoints = { 450, 400, 250, 250 };
        Color KombuGreen = Color.decode("#304D30");
        g.setColor(KombuGreen);
        g.drawPolygon(xPoints, yPoints, 4);
        g.fillPolygon(xPoints, yPoints, 4);
    }

    private void drawRectangle3(Graphics g) {
        int[] xPoints = { 200, 151, 400, 449 };
        int[] yPoints = { 499, 499, 250, 250 };
        Color KombuGreen = Color.decode("#304D30");
        g.setColor(KombuGreen);
        g.drawPolygon(xPoints, yPoints, 4);
        g.fillPolygon(xPoints, yPoints, 4);
    }

    private void drawRectangle4(Graphics g) {
        int[] xPoints = { 300, 250, 449, 449 };
        int[] yPoints = { 499, 499, 300, 350 };
        Color KombuGreen = Color.decode("#304D30");
        g.setColor(KombuGreen);
        g.drawPolygon(xPoints, yPoints, 4);
        g.fillPolygon(xPoints, yPoints, 4);
    }

    private void drawRectangle5(Graphics g) {
        int[] xPoints = { 400, 350, 449, 449 };
        int[] yPoints = { 499, 499, 400, 450 };
        Color KombuGreen = Color.decode("#304D30");
        g.setColor(KombuGreen);
        g.drawPolygon(xPoints, yPoints, 4);
        g.fillPolygon(xPoints, yPoints, 4);
    }

    private void drawRedBar(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(280, 200, 50, 300);
    }

    private void drawCircle(Graphics g) {
        int xDiameter = 250;
        int yDiameter = 350;
        int diameter = 50;

        g.setColor(Color.RED);
        g.fillOval(xDiameter - diameter / 2, yDiameter - diameter / 2, diameter - 20, diameter + 75);
    }
}

