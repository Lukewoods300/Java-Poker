package poker.controller;

import java.util.ArrayList;
import java.util.Scanner;

import poker.model.Card;
import poker.model.Model;
import poker.model.Player;

public class GameInfo {

	public GameInfo(Model modelInfo) {
		this.middleCards = modelInfo.getMiddleCards();
		this.currentPlayer = modelInfo.getCurrentPlayer();
		this.dealer = modelInfo.getDealer();
		this.currentBet = modelInfo.getCurrentBet();
		this.pot = modelInfo.getPot();
		this.isOver = modelInfo.isOver();
		this.isStarted = modelInfo.isStarted();
	}
	public ArrayList<Player> getList() {
		return list;
	}
	public Object getCurrentPlayer() {
		return currentPlayer;
	}
	public int getDealer() {
		return dealer;
	}
	public Card[] getMiddleCards() {
		return middleCards;
	}
	public int getPot() {
		return pot;
	}
	public int getCurrentBet() {
		return currentBet;
	}
	public boolean isStarted() {
		return isStarted;
	}
	public boolean isOver() {
		return isOver;
	}
	public boolean isJoin() {
		return join;
	}
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

}
