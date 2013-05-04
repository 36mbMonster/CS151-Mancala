import java.awt.*;
import java.awt.event.MouseListener;
import javax.swing.*;

public interface StyleStrategy extends MouseListener
{
   public void drawBoard(Graphics2D g2);
   public void drawPieces(Graphics2D g2);
   //notify changelistener
}