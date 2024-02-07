import javax.swing.*;
import java.awt.*;

public class Circle extends JFrame {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;

    public Circle() {
        setTitle("Midpoint Circle Drawing Algorithm");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawCircle(g, WIDTH / 2, HEIGHT / 2, 100); // Change the radius as needed
            }
        };

        add(panel);
    }

    private void drawCircle(Graphics g, int centerX, int centerY, int r) {
        int x = 0;
        int y = r;
        int Dx = 2 * x;
        int Dy = 2 * y;
        int D = 1 - r;

        while (x <= y) {
            // Plot the points in the eight octants
            plotPoints(g, centerX, centerY, x, y);

            x = x + 1;
            Dx = Dx + 2;
            D = D + Dx + 1;

            if (D >= 0) {
                y = y - 1;
                Dy = Dy - 2;
                D = D - Dy;
            }
        }
    }

    private void plotPoints(Graphics g, int centerX, int centerY, int x, int y) {
        // Plot points in eight octants
        drawPixel(g, centerX + x, centerY + y);
        drawPixel(g, centerX - x, centerY + y);
        drawPixel(g, centerX + x, centerY - y);
        drawPixel(g, centerX - x, centerY - y);
        drawPixel(g, centerX + y, centerY + x);
        drawPixel(g, centerX - y, centerY + x);
        drawPixel(g, centerX + y, centerY - x);
        drawPixel(g, centerX - y, centerY - x);
    }

    private void drawPixel(Graphics g, int x, int y) {
        g.setColor(Color.BLACK);
        g.fillRect(x, y, 1, 1);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Circle app = new Circle();
            app.setVisible(true);
        });
    }
}
