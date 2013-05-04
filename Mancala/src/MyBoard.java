import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.geom.*;
import java.awt.geom.Ellipse2D.Double;


public class MyBoard extends JComponent
{
	Ellipse2D[] boardParts;
	int width;
	int height;
	
	public MyBoard()
	{
		boardParts = new Ellipse2D[14];
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		width = this.getWidth();
		height = this.getHeight();
		int x = 10;
		int y = 10;
		Rectangle2D rectTest = new Rectangle2D.Double(x, y, width*9/10, height*9/10);
		
		int lowerX = x + width/8;
		int upperX = lowerX;
		int lowerY = y + height/2;
		int upperY = y + height/9;
		int pitSize = width/10;
		
		Ellipse2D test;
		
		for(int i = 0; i < 6; i++)
		{
			test = new Ellipse2D.Double(lowerX, lowerY, pitSize, pitSize);
			boardParts[i] = test;
			lowerX += pitSize + pitSize/10;
		}
		
		for(int i = 7; i < 13; i++)
		{
			test = new Ellipse2D.Double(upperX, upperY, pitSize, pitSize);
			boardParts[i] = test;
			upperX += pitSize + pitSize/10;
		}
		int tempX = x + width/50;
		int bigX = x + width*4/5 - width/50;
		
		Ellipse2D bigPit1 = new Ellipse2D.Double(bigX, upperY, pitSize, height*2/3);
		Ellipse2D bigPit2 = new Ellipse2D.Double(tempX, upperY, pitSize, height*2/3);
		
		boardParts[6] = bigPit1;
		boardParts[13] = bigPit2;
		
		System.out.println("Width is: "+ width + " Height is: " + height);
		
		g2.draw(rectTest);
		
		for (Shape s: boardParts)
		{
			g2.draw(s);
		}
		
		
	}
}
