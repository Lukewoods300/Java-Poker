package poker.model;

import java.util.ArrayList;

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
	A class for managing players.
 */

public class Players 
{
	private int numberOfPlayers = 0;
	private String name;
	
	/**
	  	Constructs a Player object that gets name from the player, and keep tract of 
	  	number of players in the game.
	  	@param name name of the player who enter the game.
	  	@param num number of players who are in the game.
	 */
	public Players (int number)
	{
		numberOfPlayers = number;
	}

	/**
	  	@param name set or change name according to the user input.
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	/**
  		@return a name that is set by the player.
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 	numberOfPlayer will be added 1 when this function is called.
	  	@param num number of players who join the game.
	 */
	public void addPlayers()
	{
		if (numberOfPlayers <= 8)
		{
			numberOfPlayers += 1;
		}
		else
			System.out.println("The game is full, please wait for the next game.");		
	}
	/**
	 	@return total number of players that are in the game.
	 */
	public int checkNumberOfPlayers()
	{
		return numberOfPlayers;
	}
}
