import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MenuFrame
{
	public static void main(String[]args)
	{
		final JFrame styleFrame = new JFrame();
		
		final JTextField text = new JTextField();
		text.setText("  What Style Would You Like? (Click on a button below)  ");
		JButton style1Button = new JButton("Style 1");
		JButton style2Button = new JButton("Style 2");
		
		final JButton onePieceButton = new JButton("1");
		final JButton twoPieceButton = new JButton("2");
		final JButton threePieceButton = new JButton("3");
		final JButton fourPieceButton = new JButton("4");
		
		final JPanel panel = new JPanel();
		panel.add(style1Button);
		panel.add(style2Button);
		
		style1Button.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				//choose style 1 here
				
				JPanel tempPanel = new JPanel();
				tempPanel.add(onePieceButton);
				tempPanel.add(twoPieceButton);
				tempPanel.add(threePieceButton);
				tempPanel.add(fourPieceButton);
				styleFrame.remove(panel);
				styleFrame.remove(text);
				JTextField text2 = new JTextField();
				text2.setText("  How Many Pieces Would You Like in Each Pit?  ");
				styleFrame.add(text2, BorderLayout.NORTH);
				styleFrame.add(tempPanel, BorderLayout.CENTER);
				styleFrame.repaint();
				styleFrame.pack();
			}
			
		});
		
		style2Button.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				//choose style 2
				
				JPanel tempPanel = new JPanel();
				tempPanel.add(onePieceButton);
				tempPanel.add(twoPieceButton);
				tempPanel.add(threePieceButton);
				tempPanel.add(fourPieceButton);
				styleFrame.remove(panel);
				styleFrame.remove(text);
				JTextField text2 = new JTextField();
				text2.setText("  How Many Pieces Would You Like in Each Pit?  ");
				styleFrame.add(text2, BorderLayout.NORTH);
				styleFrame.add(tempPanel, BorderLayout.CENTER);
				styleFrame.repaint();
				styleFrame.pack();
			}
			
		});
		
		onePieceButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				//one piece per pit
				styleFrame.setVisible(false);
			}
		});
		
		twoPieceButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//two pieces per pit
				styleFrame.setVisible(false);
			}
		});
		
		threePieceButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//three pieces per pit
				styleFrame.setVisible(false);
			}
		});
		
		fourPieceButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//four pieces per pit
				styleFrame.setVisible(false);
			}
		});
		
		styleFrame.add(text, BorderLayout.NORTH);
		styleFrame.add(panel, BorderLayout.CENTER);
		
		styleFrame.pack();
		styleFrame.setLayout(new BorderLayout());
		styleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		styleFrame.setVisible(true);
		
		
	}
	
}
