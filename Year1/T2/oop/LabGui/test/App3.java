package test;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class App3 {
    
    private JFrame f;
    private JFrame f2;
    private JLabel lbLogo;
    private JButton btnNew;
    private JButton btnNext;
    private JButton btnEnd;
    private JButton tileLeft;
    private JButton tileRight;
    private JLabel lbYourScore;
    private JLabel lbScore;
    private JLabel lbBlank;
    private JLabel lbBlankLower;
    private JLabel lbYourclicks;
    private JLabel lbclicks;
    private Icon img1;
    private Icon img2;
    private Icon img3;
    private Icon img4;
    private boolean isClicked;
    private int ans;
    private int score;
    private boolean isEnd = false;
    private int countclicks = 10;


    // public App2() {
    //     f = new JFrame("Fifty-Fifty");
    //     f.setSize(500,450);
    //     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     detailComponents();
    //     f.setVisible(true);

    //     f2 = new JFrame("Fifty-Fifty");
    //     f2.setSize(500,450);
    //     f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     detailComponents();
    //     f2.setVisible(true);
    // }

    public App3(){
        f = new JFrame("Finish");
        f.setSize(500,450);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        detailComponents();
        f.setVisible(true);
    }
    private void detailComponents(){
        try {
            Image changeImg1 = new ImageIcon("test/S__333127688.jpg").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
            img1 = (Icon) new ImageIcon(changeImg1);
             
            img2 = new ImageIcon("test/CS.png");
            img3 = new ImageIcon("test/blue600x600.png");
            img4 = new ImageIcon("test/orange600x600.jpg");
        } catch (Exception e) {
            System.out.println(e);
        }
        lbLogo = new JLabel("My Logo -> 65050492 <-");
        btnNew = new JButton("New Game");
        btnNext = new JButton("Next Round");
        btnEnd = new JButton("End");
        tileLeft = new JButton(img3); //("L");
        tileRight = new JButton(img4); //("R");
        lbYourScore = new JLabel("You Score");
        lbScore = new JLabel("0");
        lbBlank = new JLabel("      ");
        // lbBlank = new JLabel("______");
        lbBlankLower = new JLabel("  ");
        lbYourclicks = new JLabel("Your Turn");
        lbclicks = new JLabel("10");

        


        lbLogo.setPreferredSize(new Dimension(200, 70));
        btnNew.setPreferredSize(new Dimension(150, 30));
        btnNext.setPreferredSize(new Dimension(150, 30));
        btnEnd.setPreferredSize(new Dimension(90, 30));
        tileLeft.setPreferredSize(new Dimension(200, 200));
        tileRight.setPreferredSize(new Dimension(200, 200));
        lbYourScore.setPreferredSize(new Dimension(150, 60));
        lbScore.setPreferredSize(new Dimension(50, 50));
        lbYourclicks.setPreferredSize(new Dimension(150, 60));
        lbclicks.setPreferredSize(new Dimension(50, 50));
        lbBlank.setPreferredSize(new Dimension(72, 50));
        lbBlankLower.setPreferredSize(new Dimension(25, 10));

        f.setLayout(new FlowLayout());
        f.add(lbBlank);
        f.add(lbLogo);
        f.add(btnEnd);
        f.add(tileLeft);
        f.add(tileRight); 
        f.add(lbYourScore);  
        f.add(lbScore);
        f.add(lbYourclicks);  
        f.add(lbclicks);
        f.add(btnNew);
        f.add(lbBlankLower);
        f.add(btnNext);

        AllButtonListener bl = new AllButtonListener();
        tileLeft.addActionListener(bl);
        tileRight.addActionListener(bl);
        btnNew.addActionListener(bl);
        btnNext.addActionListener(bl);
        btnEnd.addActionListener(bl);
        newGame();
    }
    private class AllButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ev) {
            JButton source = (JButton)ev.getSource();
            // System.out.println(isEnd);
            if (source == btnNew) {
                tileLeft.setIcon(img3);
                tileRight.setIcon(img4);
                isEnd = false;
                countclicks = 10;
                newGame();
            } else if (isEnd == true){

            } else if (source == btnEnd){

                isEnd = true;
                countclicks = 0;
                lbclicks.setText(""+ countclicks);

            } else if (countclicks == 0){
                isEnd = true;
            }else if ((source == tileLeft) && (!isClicked)){
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
                countclicks--;
                lbclicks.setText("" + countclicks);
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
        countclicks = 10;
        lbclicks.setText(""+ countclicks);
        play();
    }
    private void play(){
        isClicked = false;
        ans = Math.random() > 0.5 ? 0 : 1;
    }
}