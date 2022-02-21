package poker.model;

import java.util.Comparator;

/**
 * 
 * A class for creating cards from a deck.
 *
 */
public final class Card {
	/**
	 * Constructs a Card reference.
	 * @param newRank the rank of the card. Ranks -  
	 * 2...10: same value as card, J:11, Q:12, K:13, A: 14.
	 * @param newType the type of card: 'a' is Hearts, 'b' is Spades,
	 * 'c' is Clubs, 'd' is Diamonds.
	 * @precondition newRank is an integer between 2-14, newType is either 'a','b','c','d', and newIsAce is not null.
	 * @postcondition rank and type have the values of newRank and newType respectively.
	 */
	public Card(int newRank, char newType) {
		rank = newRank;
		type = newType;
	}
	/**
	 * Gets the type of card represented by a char.
	 * @return A char which represents the type of card.
	 * @precondition type is either 'a','b','c','d'.
	 */
	public char getType() {
		return type;
	}
	/**
	 * Gets the rank of card represented by an integer.
	 * @return An integer which is the rank of the card.
	 * @precondition rank is between 2-14.
	 */
	public int getRank() {
		return rank;
	}
	/**
	 * Gets if the card is an Ace or not represented by a boolean.
	 * @return A boolean which is true if the card is an Ace.
	 * @precondition rank is not null.
	 * @postcondition Only false if card is not an Ace.
	 */
	public boolean isAce() {
		if(rank == 14) {
			return true;
		}
		return false;
	}
	/**
	 * Sets the type with a new value.
	 * @param newType the new type of the card.
	 * @precondition newType is either 'a','b','c','d'.
	 * @postcondition type has the value of newType.
	 */
	/*public void setType(char newType) {
		type = newType;
	}
	*/
	/**
	 * Set the rank with a new value.
	 * @param newRank the new rank of the card.
	 * @precondition newRank is between 2-14.
	 * @postcondition rank has the value of newRank.
	 */
	/*
	public void setRank(int newRank) {
		rank = newRank;
	}
	*/
	
	public String toString() {
		String name = "";
		String suit = "";
		if(rank == 2) name = "Two";
		else if(rank == 3) name = "Three";
		else if(rank == 4) name = "Four";
		else if(rank == 5) name = "Five";
		else if(rank == 6) name = "Six";
		else if(rank == 7) name = "Seven";
		else if(rank == 8) name = "Eight";
		else if(rank == 9) name = "Nine";
		else if(rank == 10) name = "Ten";
		else if(rank == 11) name = "Jack";
		else if(rank == 12) name = "Queen";
		else if(rank == 13) name = "King";
		else if(rank == 14) name = "Ace";
		if(type == 'a') suit = "Hearts";
		else if(type == 'b') suit = "Spades";
		else if(type == 'c') suit = "Clubs";
		else if(type == 'd') suit = "Diamonds";
		return name + " of " + suit;
		
	}
	private final int rank;
	private final char type;
	
	public class rankComparator implements Comparator<Object>
	{
		@Override
		public int compare(Object card1, Object card2) 
		{
			int rank1 = ((Card) card1).getRank();
			int rank2 = ((Card) card1).getRank();
			return rank1 - rank2;
		}
		
	}
	
	public class suitComparator implements Comparator<Object>
	{
		@Override
		public int compare(Object card1, Object card2) 
		{
			int suit1 = ((Card) card1).getType();
			int suit2 = ((Card) card1).getType();
			return suit1 - suit2;
		}
		
	}
	
	public static String rankAsString(int rank)
	{
		return ranks[rank];
	}
	public static String suitAsString(int suit)
	{
		return suits[suit];
	}
	
	private final static String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    private final static String[] suits = {"Diamonds", "Clubs", "Hearts", "Spades"};
}
