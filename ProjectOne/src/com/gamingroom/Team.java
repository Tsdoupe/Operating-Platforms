package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
	private List<Player> players;
		
	// Initializes team id and name by calling the Entity super class
	public Team(long id, String name) {
		super(id, name);
		players = new ArrayList<>();  // Initializes the players property to an empty array
	}

	/**
	 * @return the id
	 */
    public Player addPlayer(String name) {

        // Use iterator to look for existing player with same name
        Iterator<Player> iterator = players.iterator();
        while (iterator.hasNext()) {
            Player existingPlayer = iterator.next();
            if (existingPlayer.getName().equals(name)) {
                return existingPlayer;
            }
        }

        // If not found, make a new player instance and add to list of players
        Player player = new Player(GameService.getNextPlayerId(), name);
        players.add(player);

        // Return the new player instance
        return player;
    }

	@Override
	public String toString() {
		return "Team [id=" + getId() + ", name=" + getName() + "]";
	}
}
