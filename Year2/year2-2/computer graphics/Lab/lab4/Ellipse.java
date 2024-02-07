import javax.swing.*;
import java.awt.*;

public class Ellipse extends JFrame {

    public Ellipse() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setTitle("Ellipse Drawing");

        // Add a JPanel for drawing
        JPanel drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawEllipse(g);
            }
        };

        add(drawingPanel);

        setVisible(true);
    }

    private void drawEllipse(Graphics g) {
        int a = 100;  // Semi-major axis
        int b = 50;   // Semi-minor axis

        // REGION 1
        int x = 0;
        int y = b;
        int a2 = a * a;
        int b2 = b * b;
        int twoA2 = 2 * a2;
        int twoB2 = 2 * b2;

        int Dx = 0, Dy = twoA2 * y;
        int D = Math.round(b2 - a2 * b + a2 / 4);

        while (Dx <= Dy) {
            plotEllipsePoints(g, x, y);
            x = x + 1;
            Dx = Dx + twoB2;
            D = D + Dx + b2;
            if (D >= 0) {
                y = y - 1;
                Dy = Dy - twoA2;
                D = D - Dy;
            }
        }

        // REGION 2
        x = a;
        y = 0;
        Dx = twoB2 * x;
        Dy = 0;
        D = Math.round(a2 - b2 * a + b2 / 4);

        while (Dx >= Dy) {
            plotEllipsePoints(g, x, y);
            
            y = y + 1;
            Dy = Dy + twoA2;
            D = D + Dy + a2;
            if (D >= 0) {
                x = x - 1;
                Dx = Dx - twoB2;
                D = D - Dx;
            }
        }
    }

    private void plotEllipsePoints(Graphics g, int x, int y) {
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        g.setColor(Color.BLACK);
        // Plot points in all four quadrants
        g.fillRect(centerX + x, centerY - y, 1, 1);
        g.fillRect(centerX - x, centerY - y, 1, 1);
        g.fillRect(centerX + x, centerY + y, 1, 1);
        g.fillRect(centerX - x, centerY + y, 1, 1);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ellipse());
    }
}
