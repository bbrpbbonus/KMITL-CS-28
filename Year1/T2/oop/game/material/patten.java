package material;

import java.awt.Dimension;

import javax.swing.*;

class patten {

    public JButton btn1;
    public JButton btn2;
    public JButton btn3;
    public JButton btn4;
    public JButton btn5;
    public JButton btn6;
    public JButton btn7;
    public JButton btn8;
    public JButton btn9;
    public JButton btn1change;
    public JButton btn2change;
    public JButton btn3change;
    public JButton btn4change;
    public JButton btn5change;
    public JButton btn6change;
    public JButton btn7change;
    public JButton btn8change;
    public JButton btn9change;
    public Icon img1;
    public Icon img2;
    public Icon img3;
    public Icon img4;

    public Icon img5;
    public Icon img6;
    public Icon img7;
    public Icon img8;
    public Icon img9;
    public Icon img10;
    public Icon img11;
    public Icon img12;
    public Icon img13;

    public patten() {
        initComponent();
    }

    public void initComponent() {
        try {
            img1 = new ImageIcon("zwhite.jpg");
            img2 = new ImageIcon("zorange600x600.jpg");
            img3 = new ImageIcon("zgreen.jpeg");
            img4 = new ImageIcon("zred.jpg");

            img5 = new ImageIcon("z3d394d.png");
            img6 = new ImageIcon("z6bb2cc.png");
            img7 = new ImageIcon("z7e544b.png");
            img8 = new ImageIcon("z17517e.png");
            img9 = new ImageIcon("zabb9c5.png");
            img10 = new ImageIcon("zcd3434.png");
            img11 = new ImageIcon("ze8ad96.png");
            img12 = new ImageIcon("z94b587.png");
            img13 = new ImageIcon("zb58794.png");

        } catch (Exception e) {
            System.out.println(e);
        }
        
        btn1 = new JButton();
        btn1.setPreferredSize(new Dimension(150, 150));
        

        btn2 = new JButton();
        btn2.setPreferredSize(new Dimension(150, 150));
       
        btn3 = new JButton();
        btn3.setPreferredSize(new Dimension(150, 150));
        

        btn4 = new JButton();
        btn4.setPreferredSize(new Dimension(150, 150));
        
        btn5 = new JButton();
        btn5.setPreferredSize(new Dimension(150, 150));
        

        btn6 = new JButton();
        btn6.setPreferredSize(new Dimension(150, 150));
        

        btn7 = new JButton();
        btn7.setPreferredSize(new Dimension(150, 150));
       

        btn8 = new JButton();
        btn8.setPreferredSize(new Dimension(150, 150));
        

        btn9 = new JButton();
        btn9.setPreferredSize(new Dimension(150, 150));
        

    }
}