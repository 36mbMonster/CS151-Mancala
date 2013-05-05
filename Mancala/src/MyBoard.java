import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.geom.Ellipse2D.Double;


public class MyBoard extends JComponent
{
	MancalaModel model;
	Ellipse2D[] boardParts;
	PitComponent1[] pitComp;
	int[] numPieces;
	int width;
	int height;
	
	public MyBoard(MancalaModel model)
	{
		this.model = model;
		boardParts = new Ellipse2D[14];
		pitComp = new PitComponent1[14];
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
		Rectangle2D rect = new Rectangle2D.Double(x, y, width*9/10, height*9/10);
		
		int lowerX = x + width/8;
		int lowerY = y + height/2;
		int upperY = y + height/9;
		int pitSize = width/10;
		
		Ellipse2D test;
		
		for(int i = 0; i < 6; i++)
		{
			test = new Ellipse2D.Double(lowerX, lowerY, pitSize, pitSize);
			boardParts[i] = test;
			numPieces[i] = i;
			PitComponent1 temp = new PitComponent1(test, numPieces[i]);
			pitComp[i] = temp;
			lowerX += pitSize + pitSize/10;
		}
		
		lowerX -= pitSize + pitSize/10;
		for(int i = 7; i < 13; i++)
		{
			test = new Ellipse2D.Double(lowerX, upperY, pitSize, pitSize);
			boardParts[i] = test;
			numPieces[i] = i;
			PitComponent1 temp = new PitComponent1(test, numPieces[i]);
			pitComp[i] = temp;
			lowerX -= pitSize + pitSize/10;
		}
		int tempX = x + width/50;
		int bigX = x + width*4/5 - width/50;
		
		Ellipse2D bigPit1 = new Ellipse2D.Double(bigX, upperY, pitSize, height*2/3);
		Ellipse2D bigPit2 = new Ellipse2D.Double(tempX, upperY, pitSize, height*2/3);
		
		PitComponent1 big1 = new PitComponent1(bigPit1, 20);
		PitComponent1 big2 = new PitComponent1(bigPit2, 20);
		
		pitComp[6] = big1;
		boardParts[6] = bigPit1;
		pitComp[13] = big2;
		boardParts[13] = bigPit2;
		
		
		g2.setColor(Color.BLUE);
		g2.fill(rect);
		
		for (int i = 0; i < boardParts.length; i++)
		{
			Shape s = boardParts[i];
			if (i < 7)
			{
				g2.setColor(Color.CYAN);
				g2.fill(s);
			}
			else
			{
				g2.setColor(Color.YELLOW);
				g2.fill(s);
			}
			this.add(pitComp[i]);
		}
		
//		for (Shape s : boardParts)
//		{
//			g2.setColor(Color.YELLOW);
//			g2.draw(s);
//			g2.fill(s);
//		}
		
		this.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent event)
			{
				Point point = event.getPoint();
				int index; //index that got clicked on
				
				for (int i = 0; i < boardParts.length; i++)
				{
					Shape s = boardParts[i];
					
					if (s.contains(point))
					{
						index = i;
						model.move(i, model.getPlayerTurn());
						model.update();
						System.out.println("The chosen one: " + i);
					}
				}
			}
		});
	}
}
