package poker.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NumberOfPlayers {

	  public static void main(String[] args)
	     {
	        JFrame frame = new JFrame();
	        JPanel button = new JPanel();
	        JPanel text = new JPanel();
	        button.setBorder(BorderFactory.createEtchedBorder(Color.pink,Color.pink));
	        button.setBackground(new Color(41,166,131));
	        
	        frame.setLayout(new BorderLayout());

	        JButton start = new JButton("Start Session");      
	        button.setLayout(new FlowLayout());
	        button.add(start);
	        
	        
	        JLabel newPlayers = new JLabel("How many Players:");
	        JTextField numPlayers = new JTextField("Enter # of Players here!");
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
