package poker.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Bet {

	  public static void main(String[] args)
	     {
	        JFrame frame = new JFrame();
	        JPanel button = new JPanel();
	        JPanel text = new JPanel();
	        button.setBorder(BorderFactory.createEtchedBorder(Color.pink,Color.pink));
	        button.setBackground(new Color(41,166,131));
	        
	        frame.setLayout(new BorderLayout());

	        JButton start = new JButton("Bet Amount");      
	        button.setLayout(new FlowLayout());
	        button.add(start);
	        
	        JLabel newPlayers = new JLabel("Enter new Bet:");
	        JTextField numPlayers = new JTextField("Enter Bet Amount here!");
	        text.setLayout(new FlowLayout());
	        text.add(newPlayers);
	        text.add(numPlayers);
	        
	        frame.add(text, BorderLayout.NORTH);
	        frame.add(button,BorderLayout.CENTER);

	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.pack();
	        frame.setSize(500,120);
	        frame.setVisible(true);
	     }
}
