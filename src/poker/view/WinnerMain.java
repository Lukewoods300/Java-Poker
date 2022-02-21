package poker.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JComponent;
import javax.swing.*;

public class WinnerMain 
{
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 1000);
		frame.setVisible(true);
		JPanel panel1 = new JPanel();
		
		frame.setLayout(new BorderLayout());
		JPanel pic = new SmilyFaceForWinner();
		JLabel text = new Blink();
		panel1.add(pic);
		
		frame.add(panel1,BorderLayout.NORTH);
		frame.add(text,BorderLayout.CENTER);
		frame.pack();
		frame.repaint();
	}	
	
}