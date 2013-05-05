import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MenuFrame
{
	public static void main(String[]args)
	{
		final JFrame styleFrame = new JFrame();
		
		final JTextField text = new JTextField();
		text.setText("  How Many Pieces Would You Like in Each Pit?  ");
		final JButton style1Button = new JButton("Style 1");
		final JButton style2Button = new JButton("Style 2");
		
		final JButton onePieceButton = new JButton("1");
		final JButton twoPieceButton = new JButton("2");
		final JButton threePieceButton = new JButton("3");
		final JButton fourPieceButton = new JButton("4");
		
		final JPanel panel = new JPanel();
		panel.add(onePieceButton);
		panel.add(twoPieceButton);
		panel.add(threePieceButton);
		panel.add(fourPieceButton);
		
		style1Button.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				//choose style 1 here
				styleFrame.setVisible(false);
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
				text2.setText("    ");
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

				JPanel tempPanel = new JPanel();
				tempPanel.add(style1Button);
				tempPanel.add(style2Button);
				styleFrame.remove(panel);
				styleFrame.remove(text);
				JTextField text2 = new JTextField();
				text2.setText("  Which Style Would You Like?  ");
				styleFrame.add(text2, BorderLayout.NORTH);
				styleFrame.add(tempPanel, BorderLayout.CENTER);
				styleFrame.repaint();
				styleFrame.pack();
			}
		});
		
		twoPieceButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//two pieces per pit
				
				JPanel tempPanel = new JPanel();
				tempPanel.add(style1Button);
				tempPanel.add(style2Button);
				styleFrame.remove(panel);
				styleFrame.remove(text);
				JTextField text2 = new JTextField();
				text2.setText("  Which Style Would You Like?  ");
				styleFrame.add(text2, BorderLayout.NORTH);
				styleFrame.add(tempPanel, BorderLayout.CENTER);
				styleFrame.repaint();
				styleFrame.pack();
			}
		});
		
		threePieceButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//three pieces per pit
				
				JPanel tempPanel = new JPanel();
				tempPanel.add(style1Button);
				tempPanel.add(style2Button);
				styleFrame.remove(panel);
				styleFrame.remove(text);
				JTextField text2 = new JTextField();
				text2.setText("  Which Style Would You Like?  ");
				styleFrame.add(text2, BorderLayout.NORTH);
				styleFrame.add(tempPanel, BorderLayout.CENTER);
				styleFrame.repaint();
				styleFrame.pack();
			}
		});
		
		fourPieceButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//four pieces per pit
				
				JPanel tempPanel = new JPanel();
				tempPanel.add(style1Button);
				tempPanel.add(style2Button);
				styleFrame.remove(panel);
				styleFrame.remove(text);
				JTextField text2 = new JTextField();
				text2.setText("  Which Style Would You Like?  ");
				styleFrame.add(text2, BorderLayout.NORTH);
				styleFrame.add(tempPanel, BorderLayout.CENTER);
				styleFrame.repaint();
				styleFrame.pack();
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
