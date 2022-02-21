package poker;
import java.io.IOException;
import java.util.concurrent.*;

import poker.controller.Controller;
import poker.controller.Message;
import poker.model.Model;
import poker.view.View;

public class Poker {

	public static void main(String[] args) throws InterruptedException, IOException{
		client = new Client();
		if(!client.joinServer()) {
			server = new Server();
			client.joinServer();
		}
		/*
		view = View.init(queue); //creates game frame
		model = new Model(); //creates game model to be shared
		Controller game = new Controller(view, model, queue);
		game.mainLoop();
		view.dispose();
		queue.clear();*/
	}
	
	private static BlockingQueue<Message> queue = new LinkedBlockingQueue<Message>();
	private static Model model;
	private static View view;
	private static Client client;
	private static Server server;
}