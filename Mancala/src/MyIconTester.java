import javax.swing.*;
import java.awt.*;




public class MyIconTester
{
	public static void main(String[]args)
	{
		JFrame frame = new JFrame();
		MyIcon icon = new MyIcon(50);
		JLabel label = new JLabel(icon);
		
		
		frame.add(label);
		
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
