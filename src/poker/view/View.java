package poker.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import javax.swing.*;

import poker.controller.GameInfo;
import poker.controller.Message;
import poker.controller.NewGameMessage;

public class View {

	public static View init(BlockingQueue<Message> queue2) throws IOException { //what is this for?
		if(view == null)
		{    
			queue = queue2;
			view = new View();
		} 
		return view;
	}
	
	public void change(final GameInfo modelInfo) {
		 SwingUtilities.invokeLater(new Runnable()
	        {
	            public void run()
	            {
	            	try {
						((MainFrame)mainFrame).change(modelInfo);
					} catch (IOException e) {
						e.printStackTrace();
					}
	            }
	        });
	}
	
	public void searchGameDialog() {
		((MainFrame)mainFrame).searchGameDialog();
	}
	
	public void dispose() {
		((MainFrame)mainFrame).close();
	}
	private View() throws IOException {
		this.mainFrame = MainFrame.init(queue);
	}

	private static BlockingQueue<Message> queue;
	private JFrame mainFrame;
	private static View view = null;
	private class NewGameListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			try {
				queue.put(new NewGameMessage());
			}
			catch(InterruptedException exception) {
				exception.printStackTrace();
			}
		}
	}
}
