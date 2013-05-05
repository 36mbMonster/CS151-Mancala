import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MyFrame extends JFrame
{
	final MancalaModel model;
	public MyFrame(final MancalaModel model)
	{
		final MyBoard gBoard = new MyBoard(model);
		this.setLayout(new BorderLayout());
		this.add(gBoard, BorderLayout.CENTER);
		this.setSize(500, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.model = model;
		JButton newGame = new JButton("New Game");
		JButton undo = new JButton("Undo");
		JButton endTurn = new JButton("End Turn");
		JPanel panel = new JPanel(new GridLayout(1, 2));
		JPanel panel2 = new JPanel(new GridLayout(1, 1));
		
		newGame.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				//create a new game
				int startPieces = model.getStartingNumPieces();
				model.endTurn();
				model.resetBoard(startPieces);
				model.update();
				gBoard.repaint();
			}
		});
		
		undo.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//undo the move
				model.undo();
				model.update();
				gBoard.repaint();
			}
		});
		
		endTurn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//end turn here
			
				model.endTurn();
				model.update();
				if(model.gameOver())
				{
					
				}
				else
					JOptionPane.showMessageDialog(null, "Player "+(model.getPlayerTurn()+1)+"'s turn!");
			}
		});
		
		panel.add(newGame);
		panel.add(undo);
		panel2.add(endTurn);
		
		this.add(panel, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.SOUTH);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
