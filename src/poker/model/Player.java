package poker.model;

/**
   	A class to manage points and hand for each player.
   @author minlihe
 */
public class Player 
{
	private int points;
	private Card hand1;
	private Card hand2;
	private boolean flop;
	private int bet;
	//private Card hand2;

/*
  	Construct player reference.
  	@param int p, accept the points win or loss by this player.
  	@param Card h, randomly gets two cards at the beginning of the game. 
 */
	public Player(int p)
	{
		points = p;
		//hand2 = h2;
	}
	
/*
 * 	Adding points from total points.
 *  @param int p points added to total.
 *  @precondition p > 0.
 *  @postcondition points > 0.
 */
	public void addPoints(int p)
	{
		points = points + p;
	}
	
/*
 * 	Subtract points from total points.
 * 	@param int p points subtracted from total.
 * 	@precondition p > 0.
 * 	@postcondition points > 0.
 */
	public void subPoints(int p)
	{
		points = points - p;
	}
/*
 * 	Show total points player has.
 *  @postcondition points >= 0;
 */
	public int getPoints()
	{
		return points;
	}
	
	public String toString() { //for testing
		return "Total score: " + points;
	}
	
/*
 * 	display first hand to player.
 *  @return hand1 one of hand player is holding.
 */
	public Card getHand1()
	{
		return hand1;
	}
	
	public void setHand() {
		hand1 = Deck.getInstance().dealCard();
		hand2 = Deck.getInstance().dealCard();
	}

/*
 * 	display second hand to player.
 * 	@return hand2 another card player is holding.
 */
	public Card getHand2()
	{
		return hand2;
	}
	
	public void clearHand() {
		hand1 = null;
		hand2 = null;
	}
	public void setFlop(boolean newFlop) {
		flop = newFlop;
	}
	public boolean isFlop() {
		return flop;
	}
	public int getBet() {
		return bet;
	}
	public void setBet(int newBet) {
		bet = newBet;
	}
	public boolean getAllIn() {
		if(points == bet) return true;
		return false;
	}
}
