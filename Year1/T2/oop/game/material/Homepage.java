package material;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Homepage {
    private JFrame Frame;
    private JButton Button;
    private JLabel lbtitle,lbstartGame,lbBlank1;
    private Icon img;

    public Homepage() {
        Frame = new JFrame("HOME");
        Frame.getContentPane().setBackground(Color.BLACK);
        Frame.setIconImage(Toolkit.getDefaultToolkit().getImage("zface.jpg"));
        Frame.setSize(600,680);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        detailComponents();
        Frame.setVisible(true);
        Frame.setResizable(false); 
    }
    private void detailComponents() {
        try {
            img = new ImageIcon("zbrain2.jpg");
    
        } catch (Exception e) {
            System.out.println(e);
        }

        Button = new JButton("  ");
        lbtitle = new JLabel("Home MemoryGame", SwingConstants.CENTER);
        lbstartGame = new JLabel("Start Game => clike the brain", SwingConstants.CENTER);
        lbBlank1 = new JLabel("      ");

        Button.setPreferredSize(new Dimension(500, 500));
        Button.setIcon(img);
        lbtitle.setForeground(Color.WHITE);
        lbtitle.setPreferredSize(new Dimension(500, 20));
        lbstartGame.setForeground(Color.WHITE);
        lbstartGame.setPreferredSize(new Dimension(500, 20));
        lbBlank1.setPreferredSize(new Dimension(600, 10));
        
        lbtitle.setFont(new Font("Serif", Font.PLAIN, 20));
        lbstartGame.setFont(new Font("Serif", Font.PLAIN, 20));
        
        Frame.setLayout(new FlowLayout());
        Frame.add(lbtitle);
        Frame.add(lbstartGame);
        Frame.add(lbBlank1);
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
                new App();
                
            }
        }
    }
}

