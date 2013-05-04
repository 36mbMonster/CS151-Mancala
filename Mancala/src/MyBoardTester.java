import javax.swing.*;
import java.util.*;
import java.awt.*;


public class MyBoardTester
{
	public static void main(String[]args)
	{
		JFrame frame = new JFrame();
		frame.setSize(600,300);
		
		MyBoard board = new MyBoard();
		frame.add(board);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
