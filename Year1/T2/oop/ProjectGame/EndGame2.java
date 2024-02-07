import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
/*from  w w w  .j  a v a2s.c  o m*/
import javax.swing.JPanel;

public class EndGame2 extends javax.swing.JFrame {
  Image backgroundImage = Toolkit.getDefaultToolkit().getImage("zbrain.jpg");

  public EndGame2() throws IOException {
    this.setContentPane(new JPanel() {
      @Override
      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, null);
      }
    });

    pack();
    setVisible(true);
  }

//   public static void main(String[] args) throws Exception {
//     new Main();
//   }
}