import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.geom.Ellipse2D.Double;
import java.util.*;

public class PitComponent1 extends JComponent
{
	int numPieces;
	Shape piece;
	Ellipse2D bound;
	ArrayList<Shape> pieces;
	
	public PitComponent1(Ellipse2D e, int pieceNum)
	{
		numPieces = pieceNum;
		bound = e;
		pieces = new ArrayList<Shape>();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		pieces = new ArrayList<Shape>();
		
		double bigWidth = bound.getWidth();
		double bigHeight = bound.getHeight();
		double bigX = bound.getX() + bigWidth/6;
		double bigY = bound.getY() + bigHeight/6;
		bigWidth = bigWidth * 2/3;
		bigHeight = bigHeight * 2/3;
		
		Rectangle r = new Rectangle((int)bigX, (int)bigY, 
				(int)bigWidth, (int)bigHeight);
		
		this.setBounds(r);
		
		int rectX = (int)bigX;
		int currX = rectX;
		int currY = (int)bigY;
		int pieceWidth = (int)bigWidth/10;
		int piecePerRow = (int)bigWidth / pieceWidth;
		int rowCount = 1;
		
		for (int i = 0; i < numPieces; i++)
		{
			Ellipse2D tempPiece = new Ellipse2D.Double(currX, currY, pieceWidth,
					pieceWidth);
			pieces.add(tempPiece);
			currX += pieceWidth;
			rowCount++;
			if (rowCount + 1 > piecePerRow)
			{
				rowCount = 1;
				currX = rectX;
				currY += pieceWidth;
			}
			
		}
		
		for (Shape s : pieces)
		{
			g2.fill(s);
		}
		this.setVisible(true);
	}
	
	public void setNumPiece(int aNum)
	{
		numPieces = aNum;
		repaint();
	}
}
