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
 * A class to handle five middle cards.
 */
public class MiddleCard
{
	private Card middleCard1;
	private Card middleCard2;
	private Card middleCard3;
	private Card middleCard4;
	private Card middleCard5;

/*
 * Construct five middle card reference.
 * @precondition Rank range from 2 to 14, and 14 is Ace. 
 * @precondition Type chooses from 'a','b','c','d'.
 */
	public MiddleCard ()
	{
		middleCard1 = Deck.getInstance().dealCard();
		middleCard2 = Deck.getInstance().dealCard();
		middleCard3 = Deck.getInstance().dealCard();
		middleCard4 = Deck.getInstance().dealCard();
		middleCard5 = Deck.getInstance().dealCard();
	}

/*
 * A method to return middleCard1.
 */
	public Card getMiddleCard1()
	{
		return middleCard1 ;
	}
	
/*
 * A method to return middleCard2.
 */
	public Card getMiddleCard2()
	{
		return middleCard2 ;
	}

/*
 * A method to return middleCard3.
 */
	public Card getMiddleCard3()
	{
		return middleCard3 ;
	}
	
/*
 * A method to return middleCard4.
 */
	public Card getMiddleCard4()
	{
		return middleCard4 ;
	}
	
/*
 * A method to return middleCard5.
 */
	public Card getMiddleCard5()
	{
		return middleCard5 ;
	}
		
}
