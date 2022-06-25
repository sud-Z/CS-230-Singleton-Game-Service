package com.gamingroom;

/**
 * A class to test a singleton's behavior
 * 
 * @author coce@snhu.edu
 */
public class SingletonTester {

	public void testSingleton() {
		
		System.out.println("\nAbout to test the singleton...");
		
		// DONE: obtain local reference to the singleton instance
		/**
		 * Using the getGameService method of the GameService class, we get the
		 * only instance of the GameService Class.
		 */
		GameService service = GameService.getInstance();
		
		// a simple for loop to print the games
		for (int i = 0; i < service.getGameCount(); i++) {
			System.out.println(service.getGame(i));
		}
		
		
		/**
		 * When the games are printed from here, we get the same results as we did 
		 * when we printed from the driver class. This proves that both classes have
		 * accessed the same instance. 
		 * 
		 * When we attempt to create a new game service.
		 * 
		 * service = new GameService(); like this
		 *  
		 * We get a warning from eclipse saying that the constructor is not visible.
		 * We have overridden the default constructor and made it private. 
		 * This stops any class other than the GameService class itself from
		 * creating an instance of itself, making it a Singleton class. 
		 * 
		 */
		
		
	}
	
}
