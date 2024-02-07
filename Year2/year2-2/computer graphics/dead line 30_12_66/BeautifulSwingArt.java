import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class BeautifulSwingArt extends JFrame {

    public BeautifulSwingArt() {
        setTitle("Beautiful Swing Art");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        add(new BeautifulArtPanel());
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new BeautifulSwingArt().setVisible(true);
        });
    }
}

class BeautifulArtPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBeautifulArt((Graphics2D) g);
    }

    private void drawBeautifulArt(Graphics2D g2d) {
        // สีพื้นหลัง
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // วาดรูปวงกลม
        g2d.setColor(Color.BLUE);
        Ellipse2D circle = new Ellipse2D.Double(50, 50, 300, 300);
        g2d.fill(circle);

        // วาดรูปสี่เหลี่ยม
        g2d.setColor(Color.RED);
        Rectangle2D rectangle = new Rectangle2D.Double(100, 100, 200, 200);
        g2d.fill(rectangle);

        // วาดเส้น
        g2d.setColor(Color.GREEN);
        g2d.drawLine(50, 50, 350, 350);
        g2d.drawLine(50, 350, 350, 50);
    }
}

