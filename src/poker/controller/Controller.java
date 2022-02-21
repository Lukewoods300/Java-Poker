package poker.controller;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;

import poker.model.*;
import poker.view.GameMode;
import poker.view.View;

public class Controller {

	public Controller(View view, Model model, BlockingQueue<Message> queue) {
		this.view = view;
		this.model = model;
		this.messageQueue = queue;
		addValves();
	}
	
	public void mainLoop() throws InterruptedException{
		ValveResponse response = ValveResponse.EXECUTED;
		Message message = null;
		while(response!= ValveResponse.FINISH) {
			try {
				message = (Message)messageQueue.take();
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			for(Valve valve: valves) {
				response = valve.execute(message);
				if(response != ValveResponse.MISS)
					break;
			}
		}
	}
	
	public GameInfo updateGameInfo() {
		return new GameInfo(model);
	}
	
	private void addValves()
    {
   	 	 valves.add(new DoJoinGameValve());
    	 valves.add(new DoNewGameValve());
    	 valves.add(new DoRaiseValve());
    	 valves.add(new DoCheckValve());
    	 valves.add(new DoHostGameValve());
    	 valves.add(new DoSearchGameValve());

    }
	
	private void doCheck() {
		if(model.firstOver) {
			view.change(updateGameInfo());
		}
		else if(model.secondOver) {
			view.change(updateGameInfo());
		}
		else if(model.thirdOver) {
			view.change(updateGameInfo());
		}
		else if(model.fourthOver) {
			view.change(updateGameInfo());
		}
	}
	
	private static BlockingQueue<Message> messageQueue;
	private View view;
	private Model model;
	private GameInfo gameInfo;
	private List<Valve> valves = new LinkedList<Valve>();
	
	private interface Valve{
		public ValveResponse execute(Message message);
	}
	
	private class DoNewGameValve implements Valve{

		@Override
		public ValveResponse execute(Message message) {
			if(message.getClass() != NewGameMessage.class) {
				return ValveResponse.MISS;
			}
			model.setUpRound();
			view.change(updateGameInfo());
			return ValveResponse.EXECUTED;
				
		}
		
	}
	
	private class DoRaiseValve implements Valve{

		@Override
		public ValveResponse execute(Message message) {
			if(message.getClass() != RaiseMessage.class) {
				return ValveResponse.MISS;
			}
			model.betting(model.getCurrentPlayer());
			view.change(updateGameInfo());
			return ValveResponse.EXECUTED;
				
		}
		
	}
	
	private class DoJoinGameValve implements Valve{

		@Override
		public ValveResponse execute(Message message) {
			if(message.getClass() != JoinMessage.class) {
				return ValveResponse.MISS;
			}
			view.change(updateGameInfo());
			return ValveResponse.EXECUTED;
				
		}
		
	}
	
	private class DoHostGameValve implements Valve{

		@Override
		public ValveResponse execute(Message message) {
			if(message.getClass() != HostMessage.class) {
				return ValveResponse.MISS;
			}
			view.change(updateGameInfo());
			return ValveResponse.EXECUTED;
				
		}
		
	}
	
	private class DoSearchGameValve implements Valve{

		@Override
		public ValveResponse execute(Message message) {
			if(message.getClass() != SearchMessage.class) {
				return ValveResponse.MISS;
			}
			try {
				model.searchGame();
			} catch (IOException e) {
				e.printStackTrace();
			}
			view.change(updateGameInfo());
			return ValveResponse.EXECUTED;
				
		}
		
	}
	
	private class DoCheckValve implements Valve{

		@Override
		public ValveResponse execute(Message message) {
			if(message.getClass() != CheckMessage.class) {
				return ValveResponse.MISS;
			}
			view.change(updateGameInfo());
			return ValveResponse.EXECUTED;
				
		}
		
	}
	

	private class DoFirstRoundValve implements Valve{

		@Override
		public ValveResponse execute(Message message) {
			if(message.getClass() != FirstMessage.class) {
				return ValveResponse.MISS;
			}
			if(model.startingRound()) {
				
			}
			view.change(updateGameInfo());
			return ValveResponse.EXECUTED;
				
		}
	}

	private class DoSecondRoundValve implements Valve{

		@Override
		public ValveResponse execute(Message message) {
			if(message.getClass() != SecondMessage.class) {
				return ValveResponse.MISS;
			}
			if(model.secondRound()) {
				
			}
			view.change(updateGameInfo());
			return ValveResponse.EXECUTED;
				
		}
	}

	private class DoThirdRoundValve implements Valve{

		@Override
		public ValveResponse execute(Message message) {
			if(message.getClass() != ThirdMessage.class) {
				return ValveResponse.MISS;
			}
			if(model.thirdRound()) {
				
			}
			view.change(updateGameInfo());
			return ValveResponse.EXECUTED;
				
		}
	}

	private class DoFourthRoundValve implements Valve{

		@Override
		public ValveResponse execute(Message message) {
			if(message.getClass() != FourthMessage.class) {
				return ValveResponse.MISS;
			}
			if(model.fourthRound()) {
				
			}
			view.change(updateGameInfo());
			return ValveResponse.EXECUTED;
				
		}
	}
}
