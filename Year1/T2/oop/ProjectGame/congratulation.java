import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class congratulation{
	private JFrame Frame;
    private JButton Button;
    private Icon img;
	
	public congratulation() {
        Frame = new JFrame("  CONGRATULATIONS !!");
        Frame.getContentPane().setBackground(Color.WHITE);
        Frame.setIconImage(Toolkit.getDefaultToolkit().getImage("zface.jpg"));
        Frame.setSize(610,260);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        detailComponents();
        Frame.setVisible(true);
        Frame.setResizable(false); 
    }
    private void detailComponents() {
        try {
            img = new ImageIcon("zcongrat.jpg");
    
        } catch (Exception e) {
            System.out.println(e);
        }

        Button = new JButton(" ");
        Button.setPreferredSize(new Dimension(600, 220));
        Button.setIcon(img);
        Frame.setLayout(new FlowLayout());
        Frame.add(Button);

        AllButtonListener bl = new AllButtonListener();
        Button.addActionListener(bl);
    }

    private class AllButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ev) {
            JButton source = (JButton)ev.getSource();
            if (source == Button) {
                Frame.dispose();
            }
        }
    }
}