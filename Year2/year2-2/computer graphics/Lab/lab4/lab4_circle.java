import javax.swing.*;
import java.awt.*;

public class lab4_circle extends JFrame {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;

    public lab4_circle() {
        setTitle("DRAWING ONLY ONE OCTANT.");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                midpointCircle(g, 250, 250, 200); // Change the radius as needed
            }
        };

        // Set panel size to one-eighth of the JFrame
        panel.setPreferredSize(new Dimension(WIDTH / 2, HEIGHT / 2));

        add(panel);
    }

    private void midpointCircle(Graphics g, int centerX, int centerY, int r) {
        int x = 0;
        int y = r;
        int Dx = 2 * x;
        int Dy = 2 * y;
        int D = 1 - r;
    
        // Draw only the first octant
        while (x <= y) {
            drawPixel(g, centerX + x, centerY + y, 1);
    
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
    

    private void drawPixel(Graphics g, int x, int y, int section) {
        if (section == 1) {
            g.setColor(Color.BLACK);
            g.fillRect(x, y, 1, 1);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ex1 app = new ex1();
            app.setVisible(true);
        });
    }
}
