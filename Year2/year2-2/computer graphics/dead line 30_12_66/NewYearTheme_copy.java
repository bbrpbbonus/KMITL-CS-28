import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class NewYearTheme_copy extends JFrame {

    public NewYearTheme_copy() {
        setTitle("New Year Theme");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new NewYearPanel());
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new NewYearTheme().setVisible(true);
        });
    }
}

class NewYearPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawNewYearTheme(g);
    }

    private void drawNewYearTheme(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // พื้นหลัง
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // แสดงข้อความ "Happy New Year!"
        Font font = new Font("Arial", Font.BOLD, 36);
        g2d.setFont(font);
        g2d.setColor(Color.WHITE);
        String message = "Happy New Year!";
        int messageWidth = g2d.getFontMetrics().stringWidth(message);
        int x = (getWidth() - messageWidth) / 2;
        int y = getHeight() / 2;
        g2d.drawString(message, x, y);

        // วาดดอกไม้ที่เป็นสัญลักษณ์ของปีใหม่
        drawFlower(g2d, getWidth() / 4, getHeight() / 4, 50);
        drawFlower(g2d, getWidth() / 2, getHeight() / 4, 50);
        drawFlower(g2d, 3 * getWidth() / 4, getHeight() / 4, 50);
    }

    private void drawFlower(Graphics2D g2d, int x, int y, int size) {
        // สีดอกไม้
        g2d.setColor(Color.RED);
        g2d.fillOval(x - size / 2, y - size / 2, size, size);

        // สีกลีบดอกไม้
        g2d.setColor(Color.YELLOW);
        int petalSize = (int) (size * 1.5);
        for (int i = 0; i < 6; i++) {
            double angle = Math.toRadians(60 * i);
            int petalX = x + (int) (petalSize * Math.cos(angle));
            int petalY = y + (int) (petalSize * Math.sin(angle));
            g2d.fillOval(petalX - size / 2, petalY - size / 2, size, size);
        }
    }
}
