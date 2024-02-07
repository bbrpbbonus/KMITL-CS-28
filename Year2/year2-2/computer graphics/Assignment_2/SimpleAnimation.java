import javax.swing.*;
import java.awt.*;

public class SimpleAnimation extends JPanel implements Runnable {
    private int x, y;
    private int radius = 50;

    public SimpleAnimation() {
        x = 0;
        y = getHeight() / 2;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillOval(x, y, radius * 2, radius * 2);
    }

    public void run() {
        while (true) {
            // ความเร็วของ animation
            int speed = 5;

            // เคลื่อนที่ตามแนวแกน x
            x += speed;
            y += speed-4;

            // เช็คเงื่อนไขว่าถ้าวงกลมอยู่นอกขอบจอ
            if (x > getWidth()) {
                x = 0 - radius * 2;
            }

            // เรียกใช้งานเมธอด repaint() เพื่อวาดภาพใหม่
            repaint();

            try {
                // หน่วงเวลาเพื่อสร้าง animation ให้มีความเรียบร้อย
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        SimpleAnimation animation = new SimpleAnimation();
        frame.add(animation);

        // สร้าง Thread สำหรับการเรียกใช้งาน run() เพื่อสร้าง animation
        Thread thread = new Thread(animation);
        thread.start();

        frame.setVisible(true);
    }
}
