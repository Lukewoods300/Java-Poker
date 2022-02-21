package poker.view;

import javax.swing.JComponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;

public class Blink3 extends JLabel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel text;
	boolean on = true;
	boolean two = true;
	boolean four = true;
	
	public Blink3()
	{		
		text = new JLabel("Welcome!");
		text.setFont(new Font("Serif", Font.PLAIN, 30));
		setLayout(new GridBagLayout());

		Timer timer = new Timer(100, new ActionListener()
		{				
			public void actionPerformed(ActionEvent a)
			{
				if(on) {
					if(two){
						two = !two; //case 1
						if(four){
							four = !four;
							text.setForeground(Color.RED);
							on = !on;
							repaint();
						}
						else{ //case 2
							four = !four;
							text.setForeground(Color.BLUE);
							on = !on;
							repaint();
						
						}
					}
					else{
						two = !two;
						if(four){ //case 3
							text.setForeground(Color.GREEN);
							on = !on;
							repaint();
						}
						else{ //case 4
							text.setForeground(Color.BLACK);
							on = !on;
							repaint();
						}
					}
				}
				on = !on;
			}
		});
		add(text);
		
			
		timer.setRepeats(true);
		timer.setCoalesce(true);
		timer.restart();
	}
		
	public void paint(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g.create();
		if (!on)
		{
			g2d.setComposite(AlphaComposite.SrcOver.derive(0f));
		}
		else
		{
			g2d.setComposite(AlphaComposite.SrcOver.derive(1f));
		}
		super.paint(g2d);
		g2d.dispose();
		}
	public Dimension getPreferredSize() {
		return new Dimension(200,50);
	}
}
