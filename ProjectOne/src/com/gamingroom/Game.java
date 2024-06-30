package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
    private List<Team> teams;

	// Initializes game id and name by calling the Entity super class
    public Game(long id, String name) {
        super(id, name);
        teams = new ArrayList<>();  // Initializes the teams property to an empty array
    }

    public Team addTeam(String name) {
        // Use iterator to look for existing team with same name
        Iterator<Team> iterator = teams.iterator();
        while (iterator.hasNext()) {
            Team existingTeam = iterator.next();
            if (existingTeam.getName().equals(name)) {
                return existingTeam;
            }
        }

        // If not found, make a new team instance and add to list of teams
        Team team = new Team(GameService.getNextTeamId(), name);
        teams.add(team);

        // Return the new team instance
        return team;
    }

	@Override
	public String toString() {
		return "Game [id=" + getId() + ", name=" + getName() + "]";
	}

}
