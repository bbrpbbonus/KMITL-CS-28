import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

public class LotusFlower extends JFrame {

    public LotusFlower() {
        setTitle("Lotus Flower");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        add(new LotusPanel());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LotusFlower lotusFlower = new LotusFlower();
            lotusFlower.setVisible(true);
        });
    }
}

class LotusPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        drawLotus(g2d);
    }

    private void drawLotus(Graphics2D g2d) {
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        int petalCount = 8;
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
}
