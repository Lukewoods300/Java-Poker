package poker.model;

import java.util.Random;

/**
 * 
 * @author Luke
 * A class used to create a deck of cards. Card rank range from 2 to 14 with 11 being "Jack", 12 being "Queen",
 * 13 being "King", and 14 being "Ace". Types include "a" represents "Hearts", "b" represents "Spades", 
 * "c" represents "Clubs", and "d" represent "Diamonds".
 */

public class Deck{
	
	private Card[] cards = new Card[52];
	
	private static final Random random = new Random();
	int dealCounter = 0;

	/**
	 * Deck Constructor. Construct Deck reference with suit and rank. 
	 * @Postcondition: 13 cards with suit "a" which is "Hears"; 13 cards with suit "b" which is "Spades";
	 * 				   13 cards with suit "c" which is "Clubs"; 13 cards with suit "d" which is "Diamonds".
	 */
	private Deck(){
		int i = 0;
		for (int j=0; j<4; j++){
			for (int k=2; k<15;k++){
				if(j==0) {
					cards[i++] = new Card(k, 'a');	
				}
				if(j==1) {
					cards[i++] = new Card(k, 'b');	
				}
				if(j==2) {
					cards[i++] = new Card(k, 'c');	
				}
				if(j==3) {
					cards[i++] = new Card(k, 'd');	
				}
			}
		}
	}
	
	/**
	 * Prints entire deck 52 cards.
	 * 
	 */
	private static Deck instance = new Deck();
	
	public void printDeck(){
		for(int i=0; i<cards.length;i++){
			System.out.println(cards[i].toString());
		
		//System.out.println("\n");
		}
	}
	
	
	/**
	 * Returns specific card
	 * @param cardNum
	 * @return card with suit and rank.
	 */
	public Card getCard(int cardNum){
		return cards[cardNum];
	}
	
	/**
	 * Returns next card to be dealt
	 * @return cards[i] next card to be dealt
	 */
	public Card dealCard(){
		if(dealCounter< cards.length) return cards[dealCounter++];
		return null;
	}
	
	
	/**
	 * Shuffles deck of cards in random order.
	 */
	public void shuffle() {
		dealCounter = 0;
		int length = cards.length;
		
		for (int i=0;i<length;i++){
			int change = i + random.nextInt(length-i);
			swapCards(i, change);
		}
		
	}
	
	/**
	 * Swaps cards, used by shuffle().
	 * @param int i.
	 * @param int change.
	 */
	public void swapCards(int i, int change){		
		Card temp = cards[i];
		cards[i] = cards[change];
		cards[change] = temp;
	}
	
	/** 
	 * A static method that returns the instance of the class itself.
	 * @return an instance of deck.
	 */
	public static Deck getInstance() {
		return instance;
	}
	
}
