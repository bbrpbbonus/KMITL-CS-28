package material;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Thankyou {
	private JFrame Frame;
    private JButton Button;
    private Icon img;
	
	public Thankyou() {
        Frame = new JFrame("THANK YOU FOR PLAY GAME             => if you want to play again click the picture <=");
        Frame.getContentPane().setBackground(Color.WHITE);
        Frame.setIconImage(Toolkit.getDefaultToolkit().getImage("zface.jpg"));
        Frame.setSize(950,420);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        detailComponents();
        Frame.setVisible(true);
        Frame.setResizable(false); 
    }
    private void detailComponents() {
        try {
            img = new ImageIcon("zthankyou.png");
    
        } catch (Exception e) {
            System.out.println(e);
        }

        Button = new JButton("  ");
        Button.setPreferredSize(new Dimension(950, 420));
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
                // new App();
                new Homepage();
            }
        }
    }
}