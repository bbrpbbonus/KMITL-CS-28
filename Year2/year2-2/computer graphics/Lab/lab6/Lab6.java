import javax.swing.JPanel;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.geom.AffineTransform;

public class Lab6 extends JPanel {
    private final int WIDTH = 200;
    private final int HEIGHT = 200;
    private int X = 100;
    private int Y = 100;

    public static void main(String[] args) {
        Lab6 lab6 = new Lab6();
        JFrame f = new JFrame("Lab6 65050492");
        f.add(lab6);
        f.setSize(new Dimension(600, 600));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setTransform(new AffineTransform(1, 0, 0, 1, 100, 100));
        g2d.setColor(Color.RED);
        g2d.drawRect(X, Y, WIDTH, HEIGHT);

        int centerX = WIDTH / 2;
        int centerY = HEIGHT / 2;

        double angle = Math.toRadians(-30);

        double x = centerX + (Math.cos(angle) * (0 - centerX) - Math.sin(angle) * (0 - centerY));
        double y = centerY + (Math.sin(angle) * (0 - centerX) + Math.cos(angle) * (0 - centerY));

        g2d.setTransform(new AffineTransform(Math.cos(angle), Math.sin(angle), -Math.sin(angle), Math.cos(angle), x, y));
        g2d.setColor(Color.GREEN);
        g2d.drawRect(X, Y, WIDTH, HEIGHT);

        g2d.setTransform(new AffineTransform(2, 0, 0, 2, -50, 50));
        g2d.setColor(Color.BLUE);
        g2d.drawRect(X, Y, WIDTH, HEIGHT);
    }
}
