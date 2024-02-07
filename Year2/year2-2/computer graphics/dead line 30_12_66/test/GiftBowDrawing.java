import javax.swing.*;
import java.awt.*;

public class GiftBowDrawing extends JFrame {

    public GiftBowDrawing() {
        setTitle("Gift Bow Drawing");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        GiftBowPanel giftBowPanel = new GiftBowPanel();
        add(giftBowPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GiftBowDrawing());
    }
}

class GiftBowPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGiftBow(g);
    }

    private void drawGiftBow(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Set color to red for the bow
        g2d.setColor(Color.RED);

        // Draw bow loops using curves
        int[] xPoints = {50, 100, 150, 100};
        int[] yPoints = {100, 50, 100, 150};
        int numPoints = 4;

        g2d.fillPolygon(xPoints, yPoints, numPoints);
        g2d.fillOval(100, 75, 25, 50);
    }
}
