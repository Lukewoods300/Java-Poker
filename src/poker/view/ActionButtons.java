package poker.view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ActionButtons
{
   private static final String String = null;

public static void main(String[] args) throws IOException
   {
      JFrame frame = new JFrame();
      frame.setTitle("Texas Hold'em Poker");
      frame.setResizable(false);
      JPanel buttonPanel = new JPanel();
      JPanel middleCard = new JPanel();
      middleCard.setBorder(BorderFactory.createEtchedBorder(Color.pink,Color.pink));
      middleCard.setBackground(new Color(41,166,131));
      JPanel score = new JPanel();
      
      frame.setLayout(new BorderLayout());
      
      BufferedImage myPicture5 = ImageIO.read(new File("resources/8C.png"));
      Image myPic5 = myPicture5.getScaledInstance(150, 200, 0);
      JLabel picLabel5 = new JLabel(new ImageIcon(myPic5));
      
      BufferedImage myPicture6 = ImageIO.read(new File("resources/5D.png"));
      Image myPic6 = myPicture6.getScaledInstance(150, 200, 0);
      JLabel picLabel6 = new JLabel(new ImageIcon(myPic6));
      
      JButton check = new JButton("Check");
      JButton flop = new JButton("Flop");
      JButton raise = new JButton("Raise");
      JLabel  hand1 = picLabel5;
      JLabel  hand2 = picLabel6;
      
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
      
      frame.add(buttonPanel, BorderLayout.SOUTH);
      frame.add(middleCard, BorderLayout.CENTER);
      frame.add(score, BorderLayout.NORTH);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setSize(1000,690);
      frame.setVisible(true);
   }
}
