import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class EndGame {
	private JFrame Frame;
    private Icon img1;
	
	public EndGame() {
        Frame = new JFrame("END-GAME");
        Frame.getContentPane().setBackground(Color.BLACK);
        // Frame.getContentPane().add(new JFrame("zcongrat.jpg"));
        Frame.setIconImage(Toolkit.getDefaultToolkit().getImage("zcongrat.jpg"));
        Frame.setSize(600,650);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // detailComponents();
        Frame.setVisible(true);
        Frame.setResizable(false); 
	}
}