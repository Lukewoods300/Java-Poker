package poker.view;


import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JComponent;
import javax.swing.*;

public class WelcomeMain 
{
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setBackground(new Color(41,166,131));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		JButton start = new JButton("START");
		
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
				ActionButtons newActionButton = new ActionButtons();
			}
		});
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		frame.setLayout(new BorderLayout());
		JPanel pic = new WelcomeCard();
		JLabel text = new Blink2();
		JLabel text2 = new Blink3();
		panel1.add(pic);
		panel1.add(start);
		frame.add(text,BorderLayout.NORTH);
		frame.add(panel1,BorderLayout.EAST);
		frame.add(text2,BorderLayout.SOUTH);
		
		frame.pack();
		frame.setSize(400,400);
		frame.repaint();
	}
}
