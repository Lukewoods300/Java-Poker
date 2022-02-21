package poker.view;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.Dimension;

/*
 * A class to create a smile face when player wins the game.
 */
public class SmilyFaceForWinner extends JPanel
{
	boolean on = true;
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		// Draw a circle and filled with yellow color.
		super.paintComponent(g);
		g2.setColor(Color.YELLOW);
		g2.fillOval(10, 10, 200, 200);
		
		//draw eyes.
		g2.setColor(Color.BLACK);
		g2.fillOval(55, 65, 30, 30);
		g2.fillOval(135, 65, 30, 30);
		
		//draw mouth.
		g2.fillOval(50, 110, 120, 60);
		
		//adding smile.
		g2.setColor(Color.YELLOW);
		g2.fillRect(50, 110, 120, 30);
		g2.fillOval(50, 120, 120, 40);
	}
	public Dimension getPreferredSize() {
		return new Dimension(220,220);
	}
	private static final long serialVersionUID = 1L;
	
}