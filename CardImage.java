package edu.sjsu.cs151.group6.poker.control;

import edu.sjsu.cs151.group6.poker.model.Card;
import javax.swing.*;
import java.util.*;
import java.net.URL;

public class CardImage 
{
	private Hashtable<Card, ImageIcon> cardIcons = new Hashtable<>(52);
	private ClassLoader classLoader;
	
	public CardImage()
	{
		classLoader = this.getClass().getClassLoader();
		cardIcons = makeTable(Card.newDeck());
	}
	
	private Hashtable<Card, ImageIcon> makeTable(List<Card> theDeck)
	{
		for(Card each: theDeck)
		{
			String mySuit = suitMap(each.getType());
			String myFace = faceMap(each.getRank());
			String imagePath = "games/images/" + myFace + mySuit + ".gif";
			URL imageURL = classLoader.getResource(imagePath);
			ImageIcon img = new ImageIcon(imageURL);
			cardIcons.put(each, img);		
		}
		return cardIcons;
	}
	
	private String suitMap(Card.Type cardType)
	{
		return cardType.toString().toLowerCase().subString(0,1);		
	}
	
	private String faceMap(Card.Rank cardRank)
	{
		String result = null;
		
		switch(cardRank)
		{
			case TWO:
				result = "2";
				break;
			case THREE:
				result = "3";
				break;
			case FOUR:
				result = "4";
				break;
			case FIVE:
				result = "5";
				break;
			case SIX:
				result = "6";
				break;
			case SEVEN:
				result = "7";
				break;
			case EIGHT:
				result = "8";
				break;
			case NINE:
				result = "9";
				break;
			case TEN:
				result = "10";
				break;
			case JACK:
				result = "11";
				break;
			case QUEEN:
				result = "12";
				break;
			case KING:
				result = "13";
				break;
			case ACE:
				result = "14";
				break;
			
		}
		return result;
	}
	
	public Hashtable <Card, ImageIcon> getTable()
	{
		return cardIcons;
	}
}
