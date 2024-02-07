package cat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Petr
 */
public class KillDaCat extends JFrame{
    Field fieldPanel;
    JPanel buttonPanel;
    boolean catIsDead=false;
    Timer timer;
    final int FIELD_LENGHT=400;
    final int FIELD_WIDTH=400;

    public KillDaCat() throws HeadlessException {
        this.setTitle("Kill Da Cat");
        this.setLayout(new BorderLayout());
        buttonPanel = new JPanel();
        JButton startButton = new JButton("START");
        startButton.addActionListener(new startButtonListener());
        buttonPanel.add(startButton);
        this.add(buttonPanel, BorderLayout.NORTH);
        fieldPanel = new Field();
        this.setSize(500,500);
        this.setResizable(false);
        this.add(fieldPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    class TimerListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            fieldPanel.setPosition();
            repaint();
        }
    }
    

    class startButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            fieldPanel.catXPosition=200;
            fieldPanel.catYPosition=200;
            if(timer!=null){
                timer.stop();
            }
            timer = new Timer(50, new TimerListener());
            fieldPanel.setTimer(timer);
            timer.start();
        }
    }

    public static void main(String[] args) {
        KillDaCat KDC = new KillDaCat();
        KDC.setVisible(true);
    }
}

class Field extends JPanel implements MouseMotionListener{
    int catXPosition=200;
    int catYPosition=200;
    private int Increment=20;
    final private int catWidth = 50;
    final private int catHeight = 50;
    Ellipse2D cat;
    Color catColor;
    Color eyesColor;
    Timer timer;

    public Field() {
        this.setBackground(Color.GREEN);
        cat = new Ellipse2D.Float(catXPosition, catYPosition, catWidth, catHeight);
        this.addMouseMotionListener(this);
        catColor = Color.BLACK;
        eyesColor = Color.RED;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2= (Graphics2D)g;
        super.paint(g2);
        g.setColor(catColor);
        g2.fillOval(catXPosition, catYPosition,50,50);
        g2.setColor(eyesColor);
        g2.fillOval(catXPosition+10, catYPosition+15,10,10);
        g2.fillOval(catXPosition+30, catYPosition+15,10,10);
    }

    void setPosition(){
        double i = Math.random();
            double i2 = Math.random();

            if(i<0.5){
                Increment=-Increment;
            }
            if(i2<0.25 || i2>0.75){
                catXPosition += Increment;
            }
            else{
                catXPosition -= Increment;
            }
            if(i2<0.5){
                catYPosition += Increment;
            }
            else{
                catYPosition -= Increment;
            }
            cat.setFrame(catXPosition, catYPosition, catWidth, catHeight);
    }

    void setTimer(Timer timer){
        this.timer = timer;
    }

    public void mouseMoved(MouseEvent e) {
        if(cat.contains(e.getPoint())){
            if(timer!=null){
                catColor = Color.RED;
                eyesColor = Color.BLACK;
                repaint();
                timer.stop();
            }
        }
        if(timer != null && timer.isRunning()== false && !cat.contains(e.getPoint())){
            timer.start();
            catColor = Color.BLACK;
            eyesColor = Color.RED;
        }
    }

    public void mouseDragged(MouseEvent e) {
    }
}