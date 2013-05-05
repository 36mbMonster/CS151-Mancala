import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MyFrame extends JFrame
{
	final MancalaModel model;
	public MyFrame(final MancalaModel model)
	{
		this.setLayout(new BorderLayout());
		this.add(new MyBoard(), BorderLayout.CENTER);
		this.setSize(500, 300);
		
		this.model = model;
		JButton newGame = new JButton("New Game");
		JButton undo = new JButton("Undo");
		JButton endTurn = new JButton("End Turn");
		JPanel panel = new JPanel(new GridLayout(1, 3));
		
		newGame.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				//create a new game
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
			}
		});
		
		panel.add(newGame);
		panel.add(undo);
		panel.add(endTurn);
		
		this.add(panel, BorderLayout.NORTH);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
