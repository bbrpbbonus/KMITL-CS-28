import javax.swing.*;
import java.awt.*;

public class CatDrawing extends JFrame {

    public CatDrawing() {
        setTitle("Cat Drawing");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw the body
        int[] bodyX = {100, 150, 250, 300};
        int[] bodyY = {300, 200, 200, 300};
        g2d.setColor(Color.gray);
        g2d.fillPolygon(bodyX, bodyY, 4);

        // Draw the head
        int headSize = 50;
        int headX = 225 - headSize / 2;
        int headY = 150;
        g2d.setColor(Color.gray);
        g2d.fillOval(headX, headY, headSize, headSize);

        // Draw the eyes
        int eyeSize = 5;
        int leftEyeX = 215;
        int rightEyeX = 235;
        int eyeY = 170;
        g2d.setColor(Color.black);
        g2d.fillOval(leftEyeX, eyeY, eyeSize, eyeSize);
        g2d.fillOval(rightEyeX, eyeY, eyeSize, eyeSize);

        // Draw the mouth
        int mouthWidth = 20;
        int mouthHeight = 10;
        int mouthX = 225 - mouthWidth / 2;
        int mouthY = 185;
        g2d.setColor(Color.black);
        g2d.fillArc(mouthX, mouthY, mouthWidth, mouthHeight, 0, -180);

        // Draw the ears
        int[] leftEarX = {150, 120, 150};
        int[] leftEarY = {200, 170, 150};
        int[] rightEarX = {250, 280, 250};
        int[] rightEarY = {200, 170, 150};
        g2d.setColor(Color.gray);
        g2d.fillPolygon(leftEarX, leftEarY, 3);
        g2d.fillPolygon(rightEarX, rightEarY, 3);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CatDrawing());
    }
}
