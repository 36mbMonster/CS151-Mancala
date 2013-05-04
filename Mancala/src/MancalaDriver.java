import java.awt.Graphics2D;
import javax.swing.*;

public class MancalaDriver
{
   public static void main(String[] args)
   {
      // choose shit
      JFrame wtf = new JFrame();
      style1 style = new style1(300);
      wtf.add(style);

      // frame.add(style);
      wtf.setSize(775, 350);
      wtf.setTitle("Mancala");
      wtf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      wtf.setVisible(true);
   }
}
