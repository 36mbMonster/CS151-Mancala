import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Rectangle2D;
import java.util.*;

import javax.swing.*;


public class MyIcon implements Icon
{
	int width;
	ArrayList<Shape> shapes;
	
	public MyIcon(int aWidth)
	{
		width = aWidth;
		shapes = new ArrayList<Shape>();
	}
	
	@Override
	public int getIconHeight()
	{
		return width;
	}

	@Override
	public int getIconWidth()
	{
		return width;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		shapes = new ArrayList<Shape>();
		Graphics2D g2 = (Graphics2D)g;
		Ellipse2D circle = new Ellipse2D.Double(x, y, width, width);
		Rectangle2D rect = new Rectangle2D.Double(x+width/6, 
				y+width/6, width*2/3, width*2/3);
		double rectX = rect.getX();
		double rectY = rect.getY();
		double rectWidth = rect.getWidth();
		int pieceWidth = width/10;
		double currX = rectX;
		double currY = rectY;
		double numPiece = rectWidth / pieceWidth;
		int rowCount = 0;
		
		for(int i = 1; i < 30; i++)
		{
			Ellipse2D piece = new Ellipse2D.Double(currX, currY, pieceWidth, pieceWidth);
			shapes.add(piece);
			currX += pieceWidth;
			rowCount++;
			if (rowCount + 1 > numPiece)
			{
				currX = rectX;
				currY += pieceWidth;
				rowCount = 0;
			}
		}
		
		g2.draw(circle);
		g2.draw(rect);
		
		for (Shape s : shapes)
		{
			g2.fill(s);
		}
	}

}
