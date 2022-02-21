package poker.model;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

import poker.Client;
import poker.Server;


public class Model {

	public boolean isStarted() {
		return isStarted;
	}
	
	public boolean isOver() {
		return isOver;
	}
	
	public void checkIfWon() {
		
	}
	
	public void main(String[] args) {
		setUpSession(); //New Session : New amount of players
		boolean cont = true;
		while(cont) { //Another Round?: Current players stay, current points stay
			setUpRound();
			if(startingRound()) {
				if(secondRound()) {
					if(thirdRound()) {
						if(fourthRound()) {
							declareWinner();
						}
					}
				}
			}
			//dealer++, if dealer = ArrayList.length, dealer = 0;
			showPlayerStatus();
			System.out.println("\nAnother Round?: \n[1]Continue\n[Any Other #]End Game Session");
			if(input.nextInt()!=1) cont = false;
		}
		endSession();
	}
	public void setUpSession() {
		dealer = 0;
		list = new ArrayList<Player>();
		//input = new Scanner(System.in);
		//System.out.println("How many players? (2 - 8 players possible)");
		//int i = input.nextInt();
		//boolean playerCheck = true;
		//while(playerCheck) {
		//	if(i>8 || i<0) {
			//	System.out.println("Input not allowed. Re-enter the amount of players.");
				//i = input.nextInt();
			//}
			//else playerCheck = false;
		//}
		int i = 3; //Three players for now
		while(i>0) {
			list.add(new Player(2000));
			i--;
		}
		//System.out.println("Ready to Begin.\n");
		
		
	}
	public void setUpRound() {
		//System.out.println("New Round| Current Player standings:");
		Deck.getInstance().shuffle();
		for(int i=0; i<list.size();i++) {
			Player p = list.get(i);
			if(p.getPoints()==0)p.setFlop(true);
			p.setFlop(false);
			p.setBet(50);
			p.clearHand();
			p.setHand();
			pot = 0;
			//System.out.println("Player " + (i+1) +" is currently at " +p.getPoints()+" points.");
		}

		for(int i=0; i< getMiddleCards().length;i++) {
			getMiddleCards()[i] = Deck.getInstance().dealCard();
		}
	}
	public boolean startingRound() {
		System.out.println("\nFirst Round: The Pre-Flop");
		System.out.println("Opening Bet: 50 points automatically bet");
		boolean cont = true; //player loop
		currentBet = 50; //initial amount
		int i = 0; //start with first player
		int h = 0; //minimum player turns
		while(cont) {
			if(!list.get(i).isFlop() && !list.get(i).getAllIn() && !everyoneAllIn())
				betting(i);//player must still be in game
			//betting(list.get(dealer));
			i = ++i%list.size(); //next player is in list
			if(onePlayerLeft()) { //stop if only one player left in game
				return false;
			}
			else if(h++>=(list.size()-1)&& allBetsOver()) {
				System.out.println("Final Bet Amount: " + getCurrentBet() +"\n");
				break;
			}
		}
		return true;
	}
	public boolean secondRound() {
		System.out.println("Second Round: The Flop");
		boolean cont = true;
		int i = 0;
		int h = 0;
		while(cont) {
			if(!list.get(i).isFlop() && !list.get(i).getAllIn() && !everyoneAllIn()) {
				for(int j=0; j<3;j++) {
					System.out.println("Middle Card "+(j+1)+": "+ getMiddleCards()[j].toString() );
				}
				betting(i);
			}
			i = ++i%list.size(); //next player is in list
			if(onePlayerLeft()) { //stop if only one player left in game
				return false;
			}
			else if(h++>=(list.size()-1)&& allBetsOver()) {
				System.out.println("Final Bet Amount: " + getCurrentBet() +"\n");
				break;
			}
		}
		return true;
	}
	public void raise() {
		
	}
	
	public void check() {
		
	}
	
	public void fold() {
		
	}
	public void betting(int currentPlayer) {
		boolean raise = canRaise(currentPlayer); 
		//System.out.println();
		//System.out.println("Player " + (currentPlayer+1) +"'s turn\nHand: "+ list.get(currentPlayer).getHand1().toString()+", "+list.get(currentPlayer).getHand2().toString()+"\nOptions:"); //player action
		if(list.get(currentPlayer).getBet() == getCurrentBet()) System.out.println("[1] Check"); // or Call
		else System.out.println("[1] Call");
		//System.out.println("[2] Flop");
		if(raise) System.out.println("[3] Raise");
		int option = input.nextInt();
		while(((option>3 || option<1) && raise) || (!raise && (option>2 || option<1))) {
		//	System.out.println("Please choose an available option.");
			option = input.nextInt();
		}
		if(option==1) {
			if(list.get(currentPlayer).getBet()==getCurrentBet()) {
				//System.out.println("Player " + (currentPlayer+1)+ " checked. Bet remains unchanged.");
			}
			else {
				if(getCurrentBet()>list.get(currentPlayer).getPoints()) list.get(currentPlayer).setBet(list.get(currentPlayer).getPoints());
				list.get(currentPlayer).setBet(getCurrentBet());
			//	System.out.println("Player "+ (currentPlayer+1) +" called to match the current bet.");
			}
		}
		else if(option == 3) {
			int lowerBetLimit = 0;
			if(getCurrentBet()>=list.get(currentPlayer).getPoints()) lowerBetLimit = list.get(currentPlayer).getPoints();
			else {
				int addTenMax = list.get(currentPlayer).getPoints() - getCurrentBet();
				if(addTenMax<=10) lowerBetLimit = getCurrentBet()+addTenMax;
				else { 
					addTenMax = 10;
					lowerBetLimit = getCurrentBet() + addTenMax;
				}
			}
			int higherBetLimit=0;
			for(int i=0;i<list.size();i++) {
				Player p = list.get(i);
				if(!p.isFlop() && i!=currentPlayer && p.getPoints()>higherBetLimit){
					higherBetLimit = p.getPoints();
				}
			}
			if(higherBetLimit>list.get(currentPlayer).getPoints()) higherBetLimit = list.get(currentPlayer).getPoints();
			System.out.println("What is your new bet? (Must be at least "+ (lowerBetLimit) +" \nand up to " + higherBetLimit);
			int newAmount = input.nextInt();
			while(newAmount<(lowerBetLimit) || newAmount> higherBetLimit) {
				System.out.print("Please enter a permissible amount.");
				newAmount = input.nextInt();
			}
			currentBet = newAmount;
			list.get(currentPlayer).setBet(newAmount);
			System.out.println("Player has raised to " + getCurrentBet());
		}
		else if(option ==2) {
			list.get(currentPlayer).setFlop(true);
			list.get(currentPlayer).subPoints(list.get(currentPlayer).getBet());
			pot = getPot() + list.get(currentPlayer).getBet();
			System.out.println("Player "+(currentPlayer+1)+" flopped.");
		}
	}
	public boolean canRaise(int currentPlayer) {
		if(list.get(currentPlayer).getAllIn()) return false;
		for(int i=0;i<list.size();i++) {
			if(i != currentPlayer && !(list.get(i).getBet()>=list.get(currentPlayer).getPoints()) && !list.get(i).isFlop()) { //if all other player are betting more than you have, return false
				return true;
			}
		}
		return false;
	}
	public boolean onePlayerLeft() { //checks if there is only one player left in a round
		int count = 0;
		int winner = 0;
		for(int i = 0; i<list.size();i++) {
			if(list.get(i).isFlop() == false) {  //true means flop, false means still in
				winner = i;
				count++;}
		}
		if(count == 1) { 
			System.out.println("Chickened out! Remaining player " + (winner+1)+" won!");
			list.get(winner).addPoints(getPot());
			return true; //only one player left
		}
		return false; //more than one player left
	}
	
	public boolean allBetsOver() {
		boolean cont;
		// end third round early upon check
		for(int i= 0; i<list.size();i++) {
			if(!list.get(i).isFlop()) {
				if(list.get(i).getBet()!=getCurrentBet() && !list.get(i).getAllIn()) return false; //checks if a bet is not equal to the current bet and not all in
			}
		}
		return true; //all bets are at the current Bet or if unable to match, all in
	}
	public boolean thirdRound() {

		System.out.println("Third Round: The Turn");
		boolean cont = true;
		int i = 0;
		int h = 0;
		while(cont) {
			if(!list.get(i).isFlop() && !list.get(i).getAllIn() && !everyoneAllIn()) {
				for(int j=0; j<4;j++) {
					System.out.println("Middle Card "+(j+1)+": "+ getMiddleCards()[j].toString() );
				}
				betting(i);
			}
			i = ++i%list.size(); //next player is in list
			if(onePlayerLeft()) { //stop if only one player left in game
				return false;
			}
			else if(h++>=(list.size()-1)&& allBetsOver()) {
				System.out.println("Final Bet Amount: " + getCurrentBet() + "\n");
				break;
			}
		}
		return true;
	}
	public boolean fourthRound() {
		System.out.println("Fourth Round: The River");
		boolean cont = true;
		int i = 0;
		int h = 0;
		while(cont) {
			if(!list.get(i).isFlop() && !list.get(i).getAllIn() && !everyoneAllIn()) {
				for(int j=0; j<5;j++) {
					System.out.println("Middle Card "+(j+1)+": "+ getMiddleCards()[j].toString() );
				}
				betting(i);
			}
			i = ++i%list.size(); //next player is in list
			if(onePlayerLeft()) { //stop if only one player left in game
				return false;
			}
			else if(h++>=(list.size()-1)&& allBetsOver()) {
				System.out.println("Final Bet Amount: " + getCurrentBet() +"\n");
				break;
			}
		}
		return true;
	}
	
	public boolean validCurrentPlayer(int i) {
		if(!list.get(i).isFlop() && !list.get(i).getAllIn() && !everyoneAllIn()) return true;
		return false;
	}
	public void showPlayerStatus() { //for testing
		System.out.println("\nRound Over! Current Standings:");
		for(int i=0;i<list.size();i++) {
			System.out.println("Player "+ (i+1)+"\n"+list.get(i).toString());
		}
	}
	public void declareWinner() {
		//Begin hand comparison
		int numPlayers = list.size();
		System.out.println("Showdown!!!");
		int[] bestHand = new int[list.size()];
		for(int i=0;i<5;i++) {
			System.out.println("Middle Card "+(i+1)+": "+ getMiddleCards()[i].toString() );
		}
		
		for (int i = 0; i < numPlayers; i++)
		{
			if(!list.get(i).isFlop()) {
			pot = getPot() + list.get(i).getBet();
			list.get(i).subPoints(list.get(i).getBet());
			System.out.println("\nPlayer " + (i+1) + " hand:\n\n"+list.get(i).getHand1().toString()+"\n"+list.get(i).getHand2().toString());
			HandEval handToEval = new HandEval();
			Card hand1 = list.get(i).getHand1();
			Card hand2 = list.get(i).getHand2();
			handToEval.addCard(hand1,0);
			handToEval.addCard(hand2,1);
			for (int j = 0; j < 5; j++)
			{
				handToEval.addCard(getMiddleCards()[j], j+2);
			}
			System.out.println("Player " + (i+1) + " " + handToEval.evaluateHand());
			bestHand[i] = handToEval.ranking(handToEval.evaluateHand());
			}
		}

		int hightestRank = 10;
		for(int n = 0; n < bestHand.length; n++) //highest combo is lowest rank
		{
			if(  !list.get(n).isFlop() && bestHand[n] < hightestRank)
			{
				hightestRank = bestHand[n];
			}
		}
		int splitBy = 0;
		for(int m = 0; m < bestHand.length; m++) {
			if(!list.get(m).isFlop() && hightestRank == bestHand[m]) splitBy++;
		}
		int split = getPot()/splitBy;
		if(splitBy>1) System.out.println("TIE! Pot split up between the winners: "+ split);
		for(int k=0;k<list.size();k++) {
			if(!list.get(k).isFlop() && bestHand[k]== hightestRank) {
			System.out.println("Player "+ (k+1)+" won the Showdown!");
			list.get(k).addPoints(split);
			}
		}
	}
	
	public void endSession() {
		int maxScore = 0;
		for(int i=0; i<list.size();i++) {
			if(list.get(i).getPoints()>maxScore) {
				maxScore = list.get(i).getPoints();
			}	
		}
		System.out.println("Final Scores: ");
		for(int i=0; i<list.size();i++) {
			if(list.get(i).getPoints() == maxScore) {
				System.out.println("Player "+ (i+1) +" wins!"+"\tScore: "+ list.get(i).getPoints());
			}
			else System.out.println("Good luck next time player "+ (i+1)+"!"+"\tScore: "+ list.get(i).getPoints());
		}
		System.out.println("Thanks for Playing!");
	}
	
	public boolean everyoneAllIn() {
		int notAllIn =0;
		for(Player p:list) {
			if(!p.getAllIn()) notAllIn++;
		}
		if(notAllIn>1) return false;
		return true;
	}
	
	public Card[] getMiddleCards() {
		return middleCards;
	}

	public int getDealer() {
		return dealer;
	}


	public int getCurrentBet() {
		return currentBet;
	}


	public int getPot() {
		return pot;
	}

	public void searchGame() throws IOException {
		Client client = new Client();
		join = client.joinServer();
	}
	
	public int getCurrentPlayer() {
		return currentPlayer;
	}
	
	public Model() {
		setUpSession();
	}
	
	private ArrayList<Player> list = new ArrayList<>();
	private int currentPlayer;
	//private ArrayList<Client> clientList = new ArrayList<>();
	private boolean join;
	private Server host;
	//private Object currentPlayer = list.iterator();
	private int dealer; //ignore this for now
	private Scanner input;
	//private static MiddleCard tableCards;
	private Card[] middleCards;
	private int pot;
	private int currentBet;
	
	private boolean isStarted;
	private boolean isOver;
}
