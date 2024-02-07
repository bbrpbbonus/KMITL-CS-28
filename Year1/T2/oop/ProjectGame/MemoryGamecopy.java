import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
// import javax.swing.Icon;
// import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemoryGamecopy {

    private JFrame Frame;
    private JButton btnNew,btnStart,btnEnd,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    // private JButton btnStart;
    // private JButton btnEnd;
    // private JButton btn1;
    // private JButton btn2;
    // private JButton btn3;
    // private JButton btn4;
    // private JButton btn5;
    // private JButton btn6;
    // private JButton btn7;
    // private JButton btn8;
    // private JButton btn9;
    private JLabel lbBlank,lbBlank2,lbBlank3,lbBlank4;
    // private JLabel lbBlank2;
    // private JLabel lbBlank3;
    // private JLabel lbBlank4;
    private Icon img1,img2,img3;
    // private Icon img2;
    // private Icon img3;
    private boolean isClicked;
    private int ans;

    public MemoryGamecopy(){
        Frame = new JFrame("MEMORY-GAME");
        Frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Frame.getContentPane().setBackground(Color.BLACK);
        Frame.setIconImage(Toolkit.getDefaultToolkit().getImage("zbrain2.jpg"));
        Frame.setSize(600,650);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        detailComponents();
        Frame.setVisible(true);
        Frame.setResizable(true);
        
    }

    private void detailComponents() {
        try {
            img1 = new ImageIcon("zorange600x600.jpg");
            // img1 = new ImageIcon("zwhite.png");
            img2 = new ImageIcon("zorange600x6000.jpg");
            img3 = new ImageIcon("z_black_image.jpg");
            // img4 = new ImageIcon("test/orange600x600.jpg");
    
        } catch (Exception e) {
            System.out.println(e);
        }
        
        btnNew = new JButton("New Game");
        btnStart = new JButton("Start");
        btnEnd = new JButton("End Game");
        btn1 = new JButton(img1); 
        btn2 = new JButton(img1);
        btn3 = new JButton(img1);
        btn4 = new JButton(img1);
        btn5 = new JButton(img1);
        btn6 = new JButton(img1);
        btn7 = new JButton(img1);
        btn8 = new JButton(img1);
        btn9 = new JButton(img1);
        lbBlank = new JLabel("      ");
        lbBlank2 = new JLabel("      ");
        lbBlank3 = new JLabel("      ");
        lbBlank4 = new JLabel("      ");

        btnNew.setPreferredSize(new Dimension(100, 30));  
        btnStart.setPreferredSize(new Dimension(100, 30));
        btnEnd.setPreferredSize(new Dimension(100, 30));       
        btn1.setPreferredSize(new Dimension(150, 150));
        btn2.setPreferredSize(new Dimension(150, 150));
        btn3.setPreferredSize(new Dimension(150, 150));
        btn4.setPreferredSize(new Dimension(150, 150));
        btn5.setPreferredSize(new Dimension(150, 150));
        btn6.setPreferredSize(new Dimension(150, 150));
        btn7.setPreferredSize(new Dimension(150, 150));
        btn8.setPreferredSize(new Dimension(150, 150));
        btn9.setPreferredSize(new Dimension(150, 150));
        lbBlank.setPreferredSize(new Dimension(50, 50));
        lbBlank2.setPreferredSize(new Dimension(600, 20));
        lbBlank3.setPreferredSize(new Dimension(600, 20));
        lbBlank4.setPreferredSize(new Dimension(50, 50));

        Frame.setLayout(new FlowLayout());
        Frame.add(lbBlank2);
        Frame.add(btnStart);
        Frame.add(lbBlank4);
        Frame.add(btnNew);
        Frame.add(lbBlank);
        Frame.add(btnEnd);
        Frame.add(lbBlank3);
        Frame.add(btn1);
        Frame.add(btn2);
        Frame.add(btn3);
        Frame.add(btn4);
        Frame.add(btn5);
        Frame.add(btn6);
        Frame.add(btn7);
        Frame.add(btn8);
        Frame.add(btn9);
        
        AllButtonListener bl = new AllButtonListener();
        btnNew.addActionListener(bl);
        btnStart.addActionListener(bl);
        btnEnd.addActionListener(bl);
        btn1.addActionListener(bl);
        btn2.addActionListener(bl);
        btn3.addActionListener(bl);
        btn4.addActionListener(bl);
        btn5.addActionListener(bl);
        btn6.addActionListener(bl);
        btn7.addActionListener(bl);
        btn8.addActionListener(bl);
        btn9.addActionListener(bl);
    }

    private class AllButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ev) {
            JButton source = (JButton)ev.getSource();

            if (source == btnStart) {
                startGame();
            }else if (source == btnNew ){
                newGame();
            }else if (source == btnEnd){
                endGame();
            }
        }
    }
    private void startGame(){
        btn1.setIcon(img3);
        btn2.setIcon(img3);
        btn3.setIcon(img3);
        btn4.setIcon(img3);
        btn5.setIcon(img3);
        btn6.setIcon(img3);
        btn7.setIcon(img3);
        btn8.setIcon(img3);
        btn9.setIcon(img3);

    }

    private void newGame(){
        btn1.setIcon(img1);
        btn2.setIcon(img1);
        btn3.setIcon(img1);
        btn4.setIcon(img1);
        btn5.setIcon(img1);
        btn6.setIcon(img1);
        btn7.setIcon(img1);
        btn8.setIcon(img1);
        btn9.setIcon(img1);
    }

    private void endGame(){
        new EndGame();

        btn1.setIcon(img2);
        btn2.setIcon(img2);
        btn3.setIcon(img2);
        btn4.setIcon(img2);
        btn5.setIcon(img2);
        btn6.setIcon(img2);
        btn7.setIcon(img2);
        btn8.setIcon(img2);
        btn9.setIcon(img2);
    }

/*============================================= */
    public static void main(String[] args) {
        new MemoryGamecopy();
    }
/*============================================= */
}

 