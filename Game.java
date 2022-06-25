package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity {
	
	// List to hold teams.
	private List<Team> teams = new ArrayList<Team>();
	
	/**
	 * Constructor with an identifier and name, calls constructor of superclass Entity.
	 */
	public Game(long id, String name) {
		super(id, name);
	}

	/**
	 * Construct a new team instance
	 * 
	 * @param name the unique name of the team
	 * @return the team instance (new or existing)
	 */
	public Team addteam(String name) {

		// a local team instance
		Team team = null;
		Team teamTemp = null;
		
		//instantiate iterator. 
		Iterator<Team> teamsIterator = teams.iterator();
		//Eclipse gave a warning to parameterize the iterator, this was not in the textbook, but it seems to work fine.
						
		// Iterate through the teams list to find potential duplicate team
		while(teamsIterator.hasNext()) {
					
			teamTemp = teamsIterator.next();
					
			if(teamTemp.name.equals(name)) {
				// if found, simply assign that instance to the local variable
				team = teamTemp;
			}
					
		}
		

		// if not found, make a new team instance and add to list of teams
		if (team == null) {
			//System.out.println(nextGameId);
			team = new Team(GameService.getNextTeamId(), name);
			teams.add(team);
		}

		// return the new/existing team instance to the caller
		return team;
	}
	
	@Override
	public String toString() {
		
		return "Game [id=" + id + ", name=" + name + "]";
		
	}

}
