package poker.model;

/*
 * IMPORTANT: CLASS NOT CURRENTLY USED IN MODEL: PLEASE IGNORE!!!!!!!!!
 * Class was left to show progress for past assignments
 * Do not consider as part of Model MVC implementation!
 * 
 * IMPORTANT: CLASS NOT CURRENTLY USED IN MODEL: PLEASE IGNORE!!!!!!!!!
 * Class was left to show progress for past assignments
 * Do not consider as part of Model MVC implementation!
 * 
 * IMPORTANT: CLASS NOT CURRENTLY USED IN MODEL: PLEASE IGNORE!!!!!!!!!
 * Class was left to show progress for past assignments
 * Do not consider as part of Model MVC implementation!
 * 
 * IMPORTANT: CLASS NOT CURRENTLY USED IN MODEL: PLEASE IGNORE!!!!!!!!!
 * Class was left to show progress for past assignments
 * Do not consider as part of Model MVC implementation!
 */
/**
 * A class to manage two hands for each player.
 */

public class Hand 
{
	private Card hand1;
	private Card hand2;
	
/*
 * Construct two references for hand. Rank and type.
 * @precondition Rank range from 2 to 14, and 14 is Ace. 
 * @precondition Type chooses from 'a','b','c','d'.
 * @postcondition rank1!=rank2.
 */
	public Hand ()
	{
		hand1 = Deck.getInstance().dealCard();
		hand2 = Deck.getInstance().dealCard();
	}
	
/*
 * A method to return hand1.
 */
	public Card getHand1()
	{
		return hand1 ;
	}

/*
 * A method to return hand2.
 */
	public Card getHand2()
	{
		return hand2;
	}

	public static void main(String []args) {
		Deck.getInstance().shuffle();
		Hand a = new Hand();
		Card one = a.getHand1();
		Card two = a.getHand2();
		System.out.println("Card: Rank: "+ one.getRank()+" Type: "+ one.getType());
		System.out.println("Card: Rank: "+ two.getRank()+" Type: "+ two.getType());
	}
}
