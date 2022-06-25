package com.gamingroom;

/**
 * Application start-up program
 * 
 * @author coce@snhu.edu
 */
public class ProgramDriver {
	
	/**
	 * The one-and-only main() method
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		
		// DONE: obtain reference to the singleton instance
		/**
		 * Using the getGameService method of the GameService class, we get the
		 * only instance of the GameService Class.
		 */
		GameService service = GameService.getInstance();
		
		System.out.println("\nAbout to test initializing game data...");
		
		// initialize with some game data
		Game game1 = service.addGame("Game #1");
		System.out.println(game1);
		Game game2 = service.addGame("Game #2");
		System.out.println(game2);
		
		// use another class to prove there is only one instance
		SingletonTester tester = new SingletonTester();
		tester.testSingleton();
		
		// Temporary game for testing.
		Game gameTemp = null;
		Team teamTemp = null;
		Player playerTemp = null;
		// Testing all getGame Methods.
		System.out.println("\nAbout to test getting games...");
		System.out.println("By index...");
		gameTemp = service.getGame(0);
		System.out.println(gameTemp);
		gameTemp = service.getGame(1);
		System.out.println(gameTemp);
		System.out.println("By id...");
		gameTemp = service.getGame(new Long(1));
		System.out.println(gameTemp);
		gameTemp = service.getGame(new Long(2));
		System.out.println(gameTemp);
		System.out.println("By name...");
		gameTemp = service.getGame("Game #1");
		System.out.println(gameTemp);
		gameTemp = service.getGame("Game #2");
		System.out.println(gameTemp);
		
		//Testing addGame by adding a duplicate.
		System.out.println("\nAbout to test adding duplicate");
		gameTemp = service.addGame("Game #2");
		System.out.println(gameTemp);
		
		System.out.println("\nAbout to test adding teams/duplicate teams");
		teamTemp = gameTemp.addteam("winners");
		System.out.println(teamTemp);
		teamTemp = gameTemp.addteam("winners2");
		System.out.println(teamTemp);
		teamTemp = gameTemp.addteam("winners");
		System.out.println(teamTemp);
		
		System.out.println("\nAbout to test adding playesrs/duplicate playesrs");
		playerTemp = teamTemp.addPlayer("Jerry");
		System.out.println(playerTemp);
		playerTemp = teamTemp.addPlayer("Jerry2");
		System.out.println(playerTemp);
		playerTemp = teamTemp.addPlayer("Jerry");
		System.out.println(playerTemp);
		
	}
}
