package test;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class App {
    
    private JFrame f;
    private JLabel lbLogo;
    private JButton btnNew;
    private JButton btnNext;
    private JButton tileLeft;
    private JButton tileRight;
    private JLabel lbYourScore;
    private JLabel lbScore;
    private JLabel lbBlank;
    private JLabel lbBlankLower;
    private Icon img1;
    private Icon img2;
    private Icon img3;
    private Icon img4;
    private boolean isClicked;
    private int ans;
    private int score;


    public App() {
        f = new JFrame("Fifty-Fifty");
        f.setSize(500,400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        detailComponents();
        f.setVisible(true);
    }
    private void detailComponents(){
        try {
            img1 = new ImageIcon("test/S__333127688.jpg");
            img2 = new ImageIcon("test/CS.png");
            img3 = new ImageIcon("test/blue600x600.png");
            img4 = new ImageIcon("test/orange600x600.jpg");
        } catch (Exception e) {
            System.out.println(e);
        }
        lbLogo = new JLabel("My logo -> 65050492 <-"); 
        btnNew = new JButton("new");
        btnNext = new JButton("next");
        tileLeft = new JButton(img3); //("L");
        tileRight = new JButton(img4); //("R");
        lbYourScore = new JLabel("You Score");
        lbScore = new JLabel("0");
        lbBlank = new JLabel("      ");
        // lbBlank = new JLabel("______");
        lbBlankLower = new JLabel("  ");

        lbLogo.setPreferredSize(new Dimension(200, 50));
        btnNew.setPreferredSize(new Dimension(90, 30));
        btnNext.setPreferredSize(new Dimension(90, 30));
        tileLeft.setPreferredSize(new Dimension(200, 200));
        tileRight.setPreferredSize(new Dimension(200, 200));
        lbYourScore.setPreferredSize(new Dimension(90, 100));
        lbScore.setPreferredSize(new Dimension(50, 50));
        lbBlank.setPreferredSize(new Dimension(72, 50));
        lbBlankLower.setPreferredSize(new Dimension(25, 50));

        f.setLayout(new FlowLayout());
        f.add(lbBlank);
        f.add(lbLogo);
        f.add(tileLeft);
        f.add(tileRight); 
        f.add(lbYourScore);  
        f.add(lbScore);
        f.add(btnNew);
        f.add(lbBlankLower);
        f.add(btnNext);
        AllButtonListener bl = new AllButtonListener();
        tileLeft.addActionListener(bl);
        tileRight.addActionListener(bl);
        btnNew.addActionListener(bl);
        btnNext.addActionListener(bl);
        newGame();
    }
    private class AllButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ev) {
            JButton source = (JButton)ev.getSource();
            if ((source == tileLeft) && (!isClicked)){
                if (ans == 0){
                    tileLeft.setIcon(img2);
                    score++;
                    lbScore.setText("" + score);
                } else 
                    tileLeft.setIcon(img1);

                isClicked = true;
            
            } else if ((source == tileRight) && (!isClicked)){
                if (ans == 1){    
                    tileRight.setIcon(img2);
                    score++;
                    lbScore.setText("" + score);
                } else
                    tileRight.setIcon(img1);

                isClicked = true;

            } else if (source == btnNext){  
                tileLeft.setIcon(img3);
                tileRight.setIcon(img4);
                play();
            } else if (source == btnNew) {
                tileLeft.setIcon(img3);
                tileRight.setIcon(img4);
                newGame();
            }
        }
    }
    private void newGame(){
        score = 0;
        lbScore.setText(""+ score);
        play();
    }
    private void play(){
        isClicked = false;
        ans = Math.random() > 0.5 ? 0 : 1;
    }
}