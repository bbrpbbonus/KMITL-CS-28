package cat;

import javax.swing.JFrame;

/**
 *
 * @author Volan Nnanpalle
 */
public class MyFrame {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Rectangles");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Cat());
        frame.setVisible(true);

    }

}