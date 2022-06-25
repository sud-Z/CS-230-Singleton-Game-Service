package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity {
	
	// List to hold players
	private List<Player> players = new ArrayList<Player>();
	
	/*
	 * Constructor with an identifier and name, calls constructor of superclass Entity.
	 */
	public Team(long id, String name) {
		super(id, name);
	}
	
	/**
	 * Construct a new player instance
	 * 
	 * @param name the unique name of the player
	 * @return the player instance (new or existing)
	 */
	public Player addPlayer(String name) {

		// a local player instance
		Player player = null;
		Player playerTemp = null;
		
		//instantiate iterator. 
		Iterator<Player> playersIterator = players.iterator();
		//Eclipse gave a warning to parameterize the iterator, this was not in the textbook, but it seems to work fine.
						
		// Iterate through the players list to find potential duplicate player
		while(playersIterator.hasNext()) {
					
			playerTemp = playersIterator.next();
					
			if(playerTemp.name.equals(name)) {
				// if found, simply assign that instance to the local variable
				player = playerTemp;
			}
					
		}
		

		// if not found, make a new player instance and add to list of players
		if (player == null) {
			//System.out.println(nextGameId);
			player = new Player(GameService.getNextPlayerId(), name);
			players.add(player);
		}

		// return the new/existing player instance to the caller
		return player;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + "]";
	}
}
