package poker.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

import javax.imageio.ImageIO;
import javax.swing.*;

import poker.controller.Controller;
import poker.controller.FoldMessage;
import poker.controller.GameInfo;
import poker.controller.JoinMessage;
import poker.controller.Message;
import poker.controller.RaiseMessage;
import poker.controller.SearchMessage;
import poker.model.Card;
import poker.model.Player;

public class MainFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; //Fussy class without this
	
	public void close() {
		 this.setVisible(false);
		 this.dispose();
	}

	public static MainFrame init(BlockingQueue<Message> queue2) {
		if(mainFrame == null)
		{
			queue = queue2;
			mainFrame = new MainFrame();
		}
		return mainFrame;
	}

	public void change(GameInfo modelInfo) throws IOException {
		this.list = modelInfo.getList();
		this.currentPlayer = modelInfo.getCurrentPlayer();
		this.dealer = modelInfo.getDealer(); 
		this.middleCards = modelInfo.getMiddleCards();
		this.pot = modelInfo.getPot();
		this.currentBet = modelInfo.getCurrentBet();
		this.isStarted = modelInfo.isStarted();
		this.isOver = modelInfo.isOver();
		this.join = modelInfo.isJoin();
		
	}

	public void setFrame(GameMode mode) throws IOException {
		switch(mode) {
		case NEW_SESSION:
			JPanel buttonPanel = new JPanel();
		    JPanel middleCard = new JPanel();
		    middleCard.setBorder(BorderFactory.createEtchedBorder(Color.pink,Color.pink));
		    middleCard.setBackground(new Color(41,166,131));
		    JPanel score = new JPanel();
		    
		    
		    BufferedImage myPicture5 = ImageIO.read(new File("resources/8C.png"));
		    Image myPic5 = myPicture5.getScaledInstance(150, 200, 0);
		    JLabel picLabel5 = new JLabel(new ImageIcon(myPic5));
		    
		    BufferedImage myPicture6 = ImageIO.read(new File("resources/5D.png"));
		    Image myPic6 = myPicture6.getScaledInstance(150, 200, 0);
		    JLabel picLabel6 = new JLabel(new ImageIcon(myPic6));
		    
		    JButton check = new JButton("Check");
		    JButton flop = new JButton("Fold");
		    JButton raise = new JButton("Raise");
		    JLabel  hand1 = picLabel5;
		    JLabel  hand2 = picLabel6;
		    
		    check.addActionListener(new CheckListener());
		    flop.addActionListener(new FoldListener());
		    raise.addActionListener(new RaiseListener());
		    
		    buttonPanel.setLayout(new FlowLayout());

		    buttonPanel.add(hand1);
		    buttonPanel.add(hand2);
		    buttonPanel.add(check);
		    buttonPanel.add(flop);
		    buttonPanel.add(raise);
		    
		    BufferedImage myPicture = ImageIO.read(new File("resources/2D.png"));
		    Image myPic = myPicture.getScaledInstance(150, 200, 0);
		    JLabel picLabel = new JLabel(new ImageIcon(myPic));
		    
		    BufferedImage myPicture1 = ImageIO.read(new File("resources/2C.png"));
		    Image myPic1 = myPicture1.getScaledInstance(150, 200, 0);
		    JLabel picLabel1 = new JLabel(new ImageIcon(myPic1));
		    
		    BufferedImage myPicture2 = ImageIO.read(new File("resources/9C.png"));
		    Image myPic2 = myPicture2.getScaledInstance(150, 200, 0);
		    JLabel picLabel2 = new JLabel(new ImageIcon(myPic2));
		    
		    BufferedImage myPicture3 = ImageIO.read(new File("resources/9S.png"));
		    Image myPic3 = myPicture3.getScaledInstance(150, 200, 0);
		    JLabel picLabel3 = new JLabel(new ImageIcon(myPic3));
		    
		    BufferedImage myPicture4 = ImageIO.read(new File("resources/3H.png"));
		    Image myPic4 = myPicture4.getScaledInstance(150, 200, 0);
		    JLabel picLabel4 = new JLabel(new ImageIcon(myPic4));
		    
		    
		    
		    JLabel middle1 = picLabel;
		    JLabel middle2 = picLabel1;
		    JLabel middle3 = picLabel2;
		    JLabel middle4 = picLabel3;
		    JLabel middle5 = picLabel4;
		    
		    middleCard.setLayout(new FlowLayout());
		    middleCard.add(middle1);
		    middleCard.add(middle2);
		    middleCard.add(middle3);
		    middleCard.add(middle4);
		    middleCard.add(middle5);
		    
		    JLabel totalScore = new JLabel("TotalScore:");
		    JLabel scoreNum = new JLabel("2000		");
		    JLabel betAmount = new JLabel("Bet Amount:");
		    JLabel betNum = new JLabel("50		");
		    JLabel gameStatusLabel = new JLabel("Game Status:");
		    JLabel gameStatus = new JLabel("Player2 Raise.		");
		    score.setLayout(new FlowLayout());
		    score.add(totalScore);
		    score.add(scoreNum);
		    score.add(betAmount);
		    score.add(betNum);
		    score.add(gameStatusLabel);
		    score.add(gameStatus);
		    
		    add(buttonPanel, BorderLayout.SOUTH);
		    add(middleCard, BorderLayout.CENTER);
		    add(score, BorderLayout.NORTH);
			break;
		
		case RAISE:
			break;
			
		case CHECK:
			break;
			
		case FLOP:
			break;
			
		case JOIN:
			JLabel name;
		    JButton     sendMessage;
		    JTextField  messageBox;
		    JTextArea   chatBox;
	    	setLayout(new BorderLayout());
	    	JPanel mainPanel = new JPanel();
	        mainPanel.setLayout(new BorderLayout());

	        JPanel southPanel = new JPanel();
	        southPanel.setBackground(Color.BLUE);
	        southPanel.setLayout(new GridBagLayout());

	        messageBox = new JTextField(30);
	        messageBox.requestFocusInWindow();
	        

	        chatBox = new JTextArea();
	        chatBox.setEditable(false);
	        chatBox.setFont(new Font("Serif", Font.PLAIN, 15));
	        chatBox.setLineWrap(true);

	        sendMessage = new JButton("Send Message");
	        sendMessage.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{//add username
					 chatBox.append("<" + ">:  " + messageBox.getText()
	                 + "\n");
	         messageBox.setText("");
	         messageBox.requestFocusInWindow();
				}
	        });

	        GridBagConstraints left = new GridBagConstraints();
	        left.anchor = GridBagConstraints.LINE_START;
	        left.fill = GridBagConstraints.HORIZONTAL;
	        left.weightx = 512.0D;
	        left.weighty = 1.0D;

	        GridBagConstraints right = new GridBagConstraints();
	        right.insets = new Insets(0, 10, 0, 0);
	        right.anchor = GridBagConstraints.LINE_END;
	        right.fill = GridBagConstraints.NONE;
	        right.weightx = 1.0D;
	        right.weighty = 1.0D;
	        
	        mainPanel.add(new JScrollPane(chatBox), BorderLayout.CENTER);
	        southPanel.add(messageBox, left);
	        southPanel.add(sendMessage, right);

	        mainPanel.add(BorderLayout.SOUTH, southPanel);

	        add(mainPanel, BorderLayout.CENTER);

		    setSize(1000,680);
		    setVisible(true);
			break;
		}
	}
	private void setFrameOnDisplay() {
		setTitle("Texas Hold'em Poker");
	    setResizable(false);
	    setLayout(new BorderLayout());
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    Container startP = new Container();
		JButton start = new JButton("START");
		
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try 
			    {
			        queue.put(new SearchMessage());
			    }
			    catch(InterruptedException exception)
			    {
			    	exception.printStackTrace();
			    }
			}
		});
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		startP.setLayout(new BorderLayout());
		JPanel pic = new WelcomeCard();
		JLabel text = new Blink2();
		JLabel text2 = new Blink3();
		panel1.add(pic);
		panel1.add(start);
		startP.add(text,BorderLayout.NORTH);
		startP.add(panel1,BorderLayout.EAST);
		startP.add(text2,BorderLayout.SOUTH);
		add(startP,BorderLayout.CENTER);
	    setSize(1000,690);
	    setVisible(true);
	}
	
	private MainFrame() {
		setFrameOnDisplay();
		setVisible(true);
	}
	
	public void searchGameDialog() {
		JDialog d = new JDialog(this, "New Game"); 
        JLabel l = new JLabel("Could not find game to join."); 
        d.add(l); 
        d.setSize(100, 100);
        d.setVisible(true);
	}
	private static MainFrame mainFrame = null;
	private static BlockingQueue<Message> queue = null;

	private ArrayList<Player> list;
	private Object currentPlayer;
	private int dealer; //ignore this for now
	private Scanner input;
	//private static MiddleCard tableCards;
	private Card[] middleCards;
	private int pot;
	private int currentBet;
	
	private boolean isStarted;
	private boolean isOver;
	private boolean join;

	private class FoldListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			try 
		    {
		        queue.put(new FoldMessage());
		    }
		    catch(InterruptedException exception)
		    {
		    	exception.printStackTrace();
		    }
	}
	}
	private class RaiseListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			try 
		    {
		        queue.put(new RaiseMessage());
		    }
		    catch(InterruptedException exception)
		    {
		    	exception.printStackTrace();
		    }
	}
	}
	private class CheckListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			try 
		    {
		        queue.put(new CheckMessage());
		    }
		    catch(InterruptedException exception)
		    {
		    	exception.printStackTrace();
		    }
	}
	}
}
