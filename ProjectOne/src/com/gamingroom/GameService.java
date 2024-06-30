package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
	 */
	private static long nextGameId = 1;
	private static long nextTeamId = 1;
	private static long nextPlayerId = 1;

	// Turned this class into a singleton by creating a local instance 
	private static GameService instance = new GameService();
	
	/**
	 *  The purpose of the singleton pattern used in the above code is to make sure that only
	 *  one instance of GameService exist at any given time.
	 */
	
	// Created a private constructor to prevent instantiation of additional instances
	private void GameService() {
		// Prevents instantiation
	}
	
	// Public accessor to get instance
	public static GameService getInstance() {
		return instance;
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

		// Use iterator to look for existing game with same name
		// if found, simply return the existing instance
		Iterator<Game> iterator = games.iterator();
		while (iterator.hasNext()) {
			Game existingGame = iterator.next();
			if (existingGame.getName().equals(name)) {
				return existingGame;
			}
		}

		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance
		return game;
	}
	
	/**
	 *  The purpose of the iterator pattern used in the above code is to check the list of games
	 * by name or id. It allows us to encapsulate our code and access items within the list without
	 * getting into the internal structure of the list.
	 */

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

		// Use iterator to look for existing game with same id
		// if found, simply assign that instance to the local variable
		Iterator<Game> iterator = games.iterator();
		while(iterator.hasNext()) {
			Game existingGame = iterator.next();
			if (existingGame.getId() == id) {
				return existingGame;
			}
		}

		return game;
	}

	/**
	 *  The purpose of the iterator pattern used in the above code is to check the list of games
	 * by name or id. It allows us to encapsulate our code and access items within the list without
	 * getting into the internal structure of the list.
	 */
	
	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		// Use iterator to look for existing game with same name
		// if found, simply assign that instance to the local variable
		Iterator<Game> iterator = games.iterator();
		while(iterator.hasNext()) {
			Game existingGame = iterator.next();
			if (existingGame.getName().equals(name)) {
				return existingGame;
			}
		}	
		
		return game;
	}
	
	/**
	 *  The purpose of the iterator pattern used in the above code is to check the list of games
	 * by name or id. It allows us to encapsulate our code and access items within the list without
	 * getting into the internal structure of the list.
	 */

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
	
    /**
     * Returns the next team identifier
     * 
     * @return next team id
     */
    public static long getNextTeamId() {
        return nextTeamId++;
    }

    /**
     * Returns the next player identifier
     * 
     * @return next player id
     */
    public static long getNextPlayerId() {
        return nextPlayerId++;
    }
}
