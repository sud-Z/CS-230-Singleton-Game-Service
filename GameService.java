package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 * Holds the next player identifier
	 * Holds the next team identifier
	 */
	private static long nextGameId = 1;
	private static long nextPlayerId = 1;
	private static long nextTeamId = 1;
	
	/**
	 * Added a static instance of the Game Service. Because it is static,
	 * it belongs to the class itself.
	 * 
	 */
	private static GameService service = new GameService();
	
	/**
	 * Added a private default constructor so this class can not be instantiated.
	 * The only instance of this class is owned by the class itself. 
	 */
	private GameService() {}
	
	
	/**
	 * Added an accessor/getter class method to return the only object available. 
	 * 
	 */
	public static GameService getInstance() {
		return service;
	}
	

	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		
		// if found, simply return the existing instance
		game = getGame(name);
		
		/**
		 * Here, I've simply made a call to the getGame method name method instead
		 * of creating another loop here to avoid redundant code. It will work in
		 * in the same way and makes things easier to modify.
		 * 
		 * Explanation of Iterator pattern can be found starting on line 123 in the 
		 * getGame int method.
		 * 
		 */

		// if not found, make a new game instance and add to list of games
		if (game == null) {
			//System.out.println(nextGameId);
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;
		Game gameTemp = null;
		
		//instantiate iterator. 
		Iterator<Game> gamesIterator = games.iterator();
		//Eclipse gave a warning to parameterize the iterator, this was not in the textbook, but it seems to work fine.
		
		while(gamesIterator.hasNext()) {
			
			gameTemp = gamesIterator.next();
			
			if(gameTemp.id == id) {
				// if found, simply assign that instance to the local variable
				game = gameTemp;
			}
			
		}
		
		/**
		 * Here, we use Java.util's Iterator interface to iterate through the 
		 * games data structure. Even if the method for storing games is changed, so long
		 * as the structure is supported by the Iterator, this
		 * iterator will still serve its intended purpose. Also, it allows for better
		 * Encapsulation of the data structure.
		 * 
		 */

		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;
		Game gameTemp = null;
		
		

		//instantiate iterator. 
		Iterator<Game> gamesIterator = games.iterator();
		//Eclipse gave a warning to parameterize the iterator, this was not in the textbook, but it seems to work fine.
				
		while(gamesIterator.hasNext()) {
			
			gameTemp = gamesIterator.next();
			
			if(gameTemp.name.equals(name)) {
				// if found, simply assign that instance to the local variable
				game = gameTemp;
			}
			
		}
		
		return game;
	}

	/**
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
	
	/**
	 * 
	 * @return and increment the next player ID.
	 */
	public static long getNextPlayerId() {
		return nextPlayerId++;
	}
	
	/**
	 * 
	 * @return and increment the next team ID.
	 */
	public static long getNextTeamId() {
		return nextTeamId++;
	}
}
