import javax.swing.*;
import java.awt.*;

public class CurvedText extends JFrame {

    public CurvedText() {
        setTitle("Curved Text Example");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CurvedTextPanel panel = new CurvedTextPanel();
        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CurvedText());
    }
}

class CurvedTextPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // กำหนดสีพื้นหลัง
        setBackground(Color.WHITE);

        // กำหนดสีของเส้น
        g.setColor(Color.BLACK);

        // กำหนดฟอนต์และขนาด
        Font font = new Font("Arial", Font.PLAIN, 12);
        g.setFont(font);

        // กำหนดข้อความที่ต้องการวาด
        String text = "Hello, Curved Text!";

        // กำหนดพิกัดและขนาดของโค้ง
        int x = 50;
        int y = 100;
        int width = 300;
        int height = 150;

        // วาดเส้นโค้ง
        g.drawArc(x, y, width, height, 0, 180);

        // คำนวณตำแหน่งของข้อความบนเส้นโค้ง
        FontMetrics fm = g.getFontMetrics();
        int textWidth = fm.stringWidth(text);
        int textHeight = fm.getHeight();
        int centerX = x + (width - textWidth) / 2;
        int baselineY = y + (height + textHeight) / 2;

        // วาดข้อความบนเส้นโค้ง
        g.drawString(text, centerX, baselineY);
    }
}
