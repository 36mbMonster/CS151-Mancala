import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.geom.Ellipse2D.Double;

public class MyBoard2 extends JComponent
{
	Ellipse2D[] boardParts;
	int[] numPieces;
	int width;
	int height;

	public MyBoard2()
	{
		boardParts = new Ellipse2D[14];
		numPieces = new int[14];
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		width = this.getWidth();
		height = this.getHeight();
		int x = 10;
		int y = 10;
		Rectangle2D rect = new Rectangle2D.Double(x, y, width * 9 / 10,
				height * 9 / 10);

		int lowerX = x + width / 8;
		int lowerY = y + height / 2;
		int upperY = y + height / 9;
		int pitSize = width / 10;

		Ellipse2D test;

		for (int i = 0; i < 6; i++)
		{
			test = new Ellipse2D.Double(lowerX, lowerY, pitSize, pitSize);
			Rectangle2D tempR = new Rectangle2D.Double(lowerX, lowerY, 
					pitSize,pitSize);
			g2.setColor(Color.DARK_GRAY);
			g2.fill(tempR);
			boardParts[i] = test;
			numPieces[i] = i;
			lowerX += pitSize + pitSize / 10;
		}

		lowerX -= pitSize + pitSize / 10;
		for (int i = 7; i < 13; i++)
		{
			test = new Ellipse2D.Double(lowerX, upperY, pitSize, pitSize);
			boardParts[i] = test;
			numPieces[i] = i;
			lowerX -= pitSize + pitSize / 10;
		}
		int tempX = x + width / 50;
		int bigX = x + width * 4 / 5 - width / 50;

		Ellipse2D bigPit1 = new Ellipse2D.Double(bigX, upperY, pitSize,
				height * 2 / 3);
		Ellipse2D bigPit2 = new Ellipse2D.Double(tempX, upperY, pitSize,
				height * 2 / 3);

		RoundRectangle2D bigPitRect1 = new RoundRectangle2D.Double(bigX,
				upperY, pitSize, height * 2 / 3, 20, 20);
		RoundRectangle2D bigPitRect2 = new RoundRectangle2D.Double(tempX,
				upperY, pitSize, height * 2 / 3, 20, 20);

		boardParts[6] = bigPit1;
		numPieces[6] = 20;
		numPieces[13] = 30;
		boardParts[13] = bigPit2;

		g2.setColor(Color.GRAY);
		g2.fill(rect);

		for (int i = 0; i < boardParts.length; i++)
		{
			Shape s = boardParts[i];
			Rectangle2D myR = s.getBounds2D();
			if(i == 6 || i == 13){}
			else if (i < 7)
			{
				g2.setColor(Color.DARK_GRAY);
				g2.fill(myR);
			} else
			{
				g2.setColor(Color.LIGHT_GRAY);
				g2.fill(myR);
			}
		}
		
		// for (Shape s : boardParts)
		// {
		// g2.setColor(Color.YELLOW);
		// g2.draw(s);
		// g2.fill(s);
		// }
		
		g2.fill(bigPitRect2);
		g2.setColor(Color.DARK_GRAY);
		g2.fill(bigPitRect1);
		g2.setColor(Color.BLACK);
		pieceDrawer(g2);

		this.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent event)
			{
				Point point = event.getPoint();

				for (int i = 0; i < boardParts.length; i++)
				{
					Shape s = boardParts[i];

					if (s.contains(point))
					{
						//do something here
					}
				}
			}
		});
	}

	public void pieceDrawer(Graphics2D g2)
	{

		for (int i = 0; i < boardParts.length; i++)
		{
			int rowCount = 1;
			Ellipse2D e = boardParts[i];
			double x = e.getX();
			double y = e.getY();
			double eWidth = e.getWidth();
			double eHeight = e.getHeight();

			double rectX = x + eWidth / 6;
			double rectY = y + eHeight / 6;
			double rectWidth = eWidth * 2 / 3;
			double rectHeight = eHeight * 2 / 3;
			Rectangle2D rect = new Rectangle2D.Double(rectX, rectY, rectWidth,
					rectHeight);
			
			
			double pieceWidth = rectWidth / 4;
			int pWidth = (int) pieceWidth;
			Icon car = new CarIcon(pWidth);
			
			
			int currX = (int)rectX;
			int currY = (int)rectY;
			int numPiece = (int)(rectWidth / pieceWidth);

			for (int j = 0; j < numPieces[i]; j++)
			{
				car.paintIcon(this, (Graphics)g2, currX, currY);
				currX += pieceWidth;
				rowCount++;
				if (rowCount > numPiece)
				{
					currX = (int)rectX;
					currY += pieceWidth;
					rowCount = 1;
				}
				
			}
		}
	}
}
