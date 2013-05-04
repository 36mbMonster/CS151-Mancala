import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.geom.*;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class style1 extends JComponent implements StyleStrategy
{
   private double width, height;
   private Ellipse2D[] holes;

   public style1(int size)
   {
      width = size * 2.5;
      height = size;
      holes = new Ellipse2D.Double[MancalaModel.TOTAL_INDECIES];
   }

   // @Override
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      // mebe 4 loop bebe
      Ellipse2D hole1 = new Ellipse2D.Double(width * 2 / 9 - width / 36, height
            * 1 / 4 - width / 36, width / 18, width / 18);
      Ellipse2D hole2 = new Ellipse2D.Double(width * 3 / 9 - width / 36, height
            * 1 / 4 - width / 36, width / 18, width / 18);
      Ellipse2D hole3 = new Ellipse2D.Double(width * 4 / 9 - width / 36, height
            * 1 / 4 - width / 36, width / 18, width / 18);
      Ellipse2D hole4 = new Ellipse2D.Double(width * 5 / 9 - width / 36, height
            * 1 / 4 - width / 36, width / 18, width / 18);
      Ellipse2D hole5 = new Ellipse2D.Double(width * 6 / 9 - width / 36, height
            * 1 / 4 - width / 36, width / 18, width / 18);
      Ellipse2D hole6 = new Ellipse2D.Double(width * 7 / 9 - width / 36, height
            * 1 / 4 - width / 36, width / 18, width / 18);
      Ellipse2D hole7 = new Ellipse2D.Double(width * 7 / 9 - width / 36, height
            * 3 / 4 - width / 36, width / 18, width / 18);
      Ellipse2D hole8 = new Ellipse2D.Double(width * 6 / 9 - width / 36, height
            * 3 / 4 - width / 36, width / 18, width / 18);
      Ellipse2D hole9 = new Ellipse2D.Double(width * 5 / 9 - width / 36, height
            * 3 / 4 - width / 36, width / 18, width / 18);
      Ellipse2D hole10 = new Ellipse2D.Double(width * 4 / 9 - width / 36,
            height * 3 / 4 - width / 36, width / 18, width / 18);
      Ellipse2D hole11 = new Ellipse2D.Double(width * 3 / 9 - width / 36,
            height * 3 / 4 - width / 36, width / 18, width / 18);
      Ellipse2D hole12 = new Ellipse2D.Double(width * 2 / 9 - width / 36,
            height * 3 / 4 - width / 36, width / 18, width / 18);

      Ellipse2D giantHole1 = new Ellipse2D.Double(width * 1 / 9 - width / 36,
            height * 1 / 2 - width / 10, width / 18, width / 5);
      Ellipse2D giantHole2 = new Ellipse2D.Double(width * 8 / 9 - width / 36,
            height * 1 / 2 - width / 10, width / 18, width / 5);
      Rectangle2D entireBoard = new Rectangle2D.Double(0, 0, width, height);

      holes[0] = (hole1);
      holes[1] = (hole2);
      holes[2] = (hole3);
      holes[3] = (hole4);
      holes[4] = (hole5);
      holes[5] = (hole6);
      holes[6] = (giantHole1);
      holes[7] = (hole7);
      holes[8] = (hole8);
      holes[9] = (hole9);
      holes[10] = (hole10);
      holes[11] = (hole11);
      holes[12] = (hole12);
      holes[13] = (giantHole2);

      for (int i = 0; i < holes.length; i++)
      {
         g2.draw(holes[i]);
      }
      g2.draw(entireBoard);
   }

   public void drawPieces(Graphics2D g2)
   {
      // mancala piece
      // Ellipse2D piece = Ellipse2D.Double(?, ?, width/180, width/180).fill;
	  // Ellipse2D pit = ..... whatever the current pit is
	  // Rectangle2D inPit = new Rectangle2D.Double(pit.getX()+pit.getWidth()/6, 
		//	pit.getY()+pit.getWidth()/6,pit.getWidth()*2/3, pit.getWidth()*2/3);
		//int pieceWidth = width/10;
		//double rectX = inPit.getX();
		//double rectY = inPit.getY;
   }

   @Override
   public void drawBoard(Graphics2D g2)
   {
      // TODO Auto-generated method stub

   }

   @Override
   public void mouseClicked(MouseEvent arg0)
   {
      // TODO Auto-generated method stub

   }

   @Override
   public void mouseEntered(MouseEvent arg0)
   {
      // TODO Auto-generated method stub

   }

   @Override
   public void mouseExited(MouseEvent arg0)
   {
      // TODO Auto-generated method stub

   }

   @Override
   public void mousePressed(MouseEvent arg0)
   {
      // TODO Auto-generated method stub

   }

   @Override
   public void mouseReleased(MouseEvent arg0)
   {
      // TODO Auto-generated method stub

   }

}
