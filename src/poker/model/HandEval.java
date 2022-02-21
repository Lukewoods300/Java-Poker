package poker.model;

import java.util.Arrays;
import java.util.Comparator;

public class HandEval
{
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
	protected void addCard(Card card, int i)
	{
		eval[i] = card;	
	}
	protected Card getCard(int i)
	{
		return eval[i];
	}
	protected int numCards()
	{
		return eval.length;
	}
	protected void sortByRank()
	{
		Arrays.sort(eval, new rankComparator());
	}
	protected void sortBySuit()
	{
		Arrays.sort(eval, new suitComparator());
	}
	protected void sortBySuitThenRank()
	{
		Arrays.sort(eval, new suitComparator());
		Arrays.sort(eval, new rankComparator());
	}
	protected void sortByRankThenSuit()
	{
		Arrays.sort(eval, new rankComparator());
		Arrays.sort(eval, new suitComparator());
	}
	protected String evaluateHand()
	{			
		for (int i = 0; i < rankCounter.length; i++)
		{
			rankCounter[i] = 0;
		}
		for (int i = 0; i < suitCounter.length; i++)
		{
			suitCounter[i] = 0;
		}
		// Loop through sorted cards and total ranks.
		for (int i = 0; i < eval.length; i++)
		{					
			short evalType[] = new short[4];
			if ( eval[i].getType() == 'a')
			{
				evalType[0] = 0;
				suitCounter[evalType[0]]++;
			}
			else if ( eval[i].getType() == 'b')
			{
				evalType[1] = 1;
				suitCounter[evalType[1]]++;
			}
			else if ( eval[i].getType() == 'c')
			{
				evalType[2] = 2;
				suitCounter[evalType[2]]++;
			}
			else if ( eval[i].getType() == 'd')
			{
				evalType[3] = 3;
				suitCounter[evalType[3]]++;
			}
			rankCounter[eval[i].getRank()-2]++;
		}
		// sort cards for evaluation.
		this.sortByRankThenSuit();
		
		handResult = evaluateRoyal(rankCounter, suitCounter);
		
		// check for straight flush.
		if(handResult  == null || handResult.length() == 0)
		{
			handResult = evaluateStraightFlush(rankCounter, suitCounter);
		}
		// check for four of a kind.
		if(handResult == null || handResult.length() == 0)
		{
			handResult = evaluateFourOfAKind(rankCounter);
		}
		//check for full house
		if(handResult == null || handResult.length() == 0)
		{
			handResult = evaluateFullHouse(rankCounter);
		}
		//check for a flush
		if(handResult == null || handResult.length() == 0)
		{
			handResult = evaluateFlush(rankCounter, suitCounter);
		}
		//check for straight
		if(handResult == null || handResult.length() == 0)
		{
			this.sortByRank();
			handResult = evaluateStraight(rankCounter);
		}
		//check for three of a kind
		if(handResult == null || handResult.length() == 0)
		{
			handResult = evaluateThreeOfAKind(rankCounter);
		}
		//check for two pair.
		if(handResult == null || handResult.length() == 0)
		{
			handResult = evaluateTwoPair(rankCounter);
		}
		//check for one pair.
		if(handResult == null || handResult.length() == 0)
		{
			handResult = evaluateOnePair(rankCounter);
		}
		//check for highCard.
		if(handResult == null || handResult.length() == 0)
		{
			handResult = evaluateHighCard(rankCounter);
		}
		
		return handResult;
	}
	
	private String evaluateRoyal(short[] rankCounter, short[] suitCounter)
	{
		String result = "";
		
		if ((rankCounter[9] >= 1 && rankCounter[10] >= 1 && rankCounter[11] >= 1 &&
			 rankCounter[12] >= 1 && rankCounter[113] >= 1 && rankCounter[14] >= 1) &&
			 (suitCounter[0] > 4 || suitCounter[1] > 4 || 
			  suitCounter[2] > 4 || suitCounter[3] > 4))
		{
			royalSearch:
				for (int i = 0; i < 3; i++)
				{
					if (eval[i].getRank() == 0)
					{
						for(int j = 1; j < 4-i; j++)
						{
							if ((eval[i+j].getRank() == 9 && eval[i+j+1].getRank() == 10 &&
								 eval[i+j+2].getRank() == 11 && eval[i+j+3].getRank() == 12)
								 && (eval[i].getType() == eval[i+j].getType() &&
									 eval[i].getType() == eval[i+j+1].getType() &&
									 eval[i].getType() == eval[i+j+2].getType() &&
									 eval[i].getType() == eval[i+j+3].getType()))
								 {
									result = "Royal Flush!! Suit";
									break royalSearch;
								 }
						}
					}
					
				}
		}
		return result;		
	}
	
	private String evaluateStraightFlush(short[] rankCounter, short[] suitCounter)
	{
		String result = "";
		if(suitCounter[0] > 4 || suitCounter[1] > 4 ||
		   suitCounter[2] > 4 || suitCounter[3] > 4)
		{
			for (int i = eval.length-1; i > 3; i--)
			{
				if ((eval[i].getRank()-ONE == eval[i-ONE].getRank() &&
				     eval[i].getRank()-TWO == eval[i-TWO].getRank() &&
				     eval[i].getRank()-THREE == eval[i-THREE].getRank() &&
				     eval[i].getRank()-FOUR == eval[i-FOUR].getRank()) &&
				   (eval[i].getType() == eval[i-ONE].getType() &&
				   	eval[i].getType() == eval[i-TWO].getType() &&
				   	eval[i].getType() == eval[i-THREE].getType() &&
				   	eval[i].getType() == eval[i-FOUR].getType()))
				{
					result = "Straight Flush!";
					break;
							
				}
			}
		}
		return result;
	}
	
	private String evaluateFourOfAKind(short[] rankCount)
	{
		String result = "";
		for (int i = 0; i < rankCounter.length; i++)
		{
			if (rankCounter[i] == FOUR)
			{
				result = "Four of a Kind";
				break;
			}
		}
		return result;
	}
	
	private String evaluateFullHouse(short[] rankCounter)
	{
		String result = "";
		short threeOfKindRank = -1;
		short twoOfKindRank = -1;
		
		for (int i = rankCounter.length; i > 0; i--)
		{
			if ((threeOfKindRank < (short)0) || (twoOfKindRank < (short)0 ))
			{
				if ((rankCounter[i-ONE]) > 2)
				{
					threeOfKindRank = (short) (i-ONE);
				}
				else if ((rankCounter[i-ONE]) > 1)
				{
					twoOfKindRank = (short)(i-ONE);
				}
			}
			else break;
		}
		if ((threeOfKindRank >= (short)0) && (twoOfKindRank >= (short)0))
		{
			result = "Full House";
		}
		return result;
	}
	
	private String evaluateFlush(short[] rankCounter, short[] suitCounter)
	{
		String result = "";
		if (suitCounter[0] > 4 || suitCounter[1] > 4 ||
			suitCounter[2] > 4 || suitCounter[3] > 4)
		{
			for (int i = eval.length - 1; i > 3; i--)
			{
				if (eval[i].getType() == eval[i-ONE].getType() &&
					eval[i].getType() == eval[i-TWO].getType() &&
					eval[i].getType() == eval[i-THREE].getType() &&
					eval[i].getType() == eval[i-FOUR].getType())
				{
					result = "Flush";
					break;
				}
			}
		}
		return result;
	}
	
	private String evaluateStraight(short[] rankCounter)
	{
		String result = "";
		for(int i = rankCounter.length; i > 4; i--)
		{
			if((rankCounter[i-1] > 0) &&
			   (rankCounter[i-2] > 0) &&
			   (rankCounter[i-3] > 0) &&
			   (rankCounter[i-4] > 0) &&
			   (rankCounter[i-5] > 0))
			{
				result = "Straight";
				break;
			}
				
		}
		return result;
	}
	
	private String evaluateThreeOfAKind(short[] rankCounter)
	{
		String result = "";
		for (int i = rankCounter.length; i > 0; i--)
		{
			if (rankCounter[i-1] > 2)
			{
				result = "Three of a kind";
				break;
			}
		}
		return result;
	}
	
	private String evaluateTwoPair(short[] rankCounter)
	{
		String result = "";
		short firstPairRank = -1;
		short secondPairRank = -1;
		
		for (int i = rankCounter.length; i > 0; i--)
		{
			if((firstPairRank < (short)0) || (secondPairRank < (short)0))
			{
				if(((rankCounter[i-ONE]) > 1) && (firstPairRank < (short)0))
				{
					firstPairRank = (short) (i-ONE);
				}
				else if((rankCounter[i-ONE]) > 1)
				{
					secondPairRank = (short)(i-ONE);
				}
			}
			else break;
		}
		if ((firstPairRank >= (short)0) && (secondPairRank >= (short)0))
		{
			if(secondPairRank == (short)0)
			{
				result = "Two Pair";
			}
			else
			{
				result = "Two Pair";
			}
		}
		return result;
	}
	
	private String evaluateOnePair(short[] rankCounter)
	{
		String result = "";
		for (int i = rankCounter.length; i > 0; i--)
		{
			if((rankCounter[i-ONE]) > 1)
			{
				result = "One Pair";
				break;
			}
		}
		return result;
	}
	
	private String evaluateHighCard(short[] rankCounter)
	{
		String result = "";
		for (int i = rankCounter.length; i > 0; i--)
		{
			if ((rankCounter[i-ONE]) > 0)
			{
				result = "High Card";
				break;
			}
		}
		return result;
	}
	
	public int ranking (String result)
	{
		int rank = 0;
		if(result.contentEquals("Royal Flush!! Suit"))
		{
			rank = 1;
		}
		else if(result.contentEquals("Straight Flush!"))
		{
			rank = 2;
		}
		else if(result.contentEquals("Four of a Kind"))
		{
			rank = 3;
		}
		else if(result.contentEquals("Full House"))
		{
			rank = 4;
		}
		else if(result.contentEquals("Flush"))
		{
			rank = 5;
		}
		else if(result.contentEquals("Straight"))
		{
			rank = 6;
		}
		else if(result.contentEquals("Three of a kind"))
		{
			rank = 7;
		}
		else if(result.contentEquals("Two Pair"))
		{
			rank = 8;
		}
		else if(result.contentEquals("One Pair"))
		{
			rank = 9;
		}
		else if(result.contentEquals("High Card"))
		{
			rank = 10;
		}
		
		return rank;
	}


static String handResult = new String();
short[] rankCounter = new short[13];
short[] suitCounter = new short[4];
private Card[] eval = new Card[7];
private final static short ONE = 1;
private final static short TWO = 2;
private final static short THREE = 3;
private final static short FOUR = 4;
}