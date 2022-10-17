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
*/
private static long nextGameId = 1;

/*
* Holds the next team identifier
*/
private static long nextPlayerId = 1;

/*
* Holds the next player identifier
*/
private static long nextTeamId = 1;

private static GameService service;
private GameService() {
}

/**
* Check for existing instance of GameService
* @return
*/
public static GameService getInstance() {

if (service == null) {
service = new GameService();
System.out.println("New Game Service created.");
} else {
System.out.println("Game Service already instantiated.");
}

return service;
}

/**
* Construct a new game instance
*
* @param name the unique name of the game
* @return the game instance (new or existing)
*/
public Game addGame(String name) {

Game game = null;

Iterator<Game> gamesIterator = games.iterator();
while (gamesIterator.hasNext()) {

Game gameInstance = gamesIterator.next();

if (gameInstance.getName().equalsIgnoreCase(name)) {
return gameInstance;
}
}

if (game == null) {
game = new Game(nextGameId++, name);
games.add(game);
}

return game;
}

/**
* Returns the game instance with the specified id.
*
* @param id unique identifier of game to search for
* @return requested game instance
*/
public Game getGame(long id) {

Game game = null;

Iterator <Game> gamesIterator = games.iterator();

while (gamesIterator.hasNext()) {

Game gameInstance = gamesIterator.next();

if (gameInstance.getId() == id) {
return gameInstance;
}
}


return game;
}

/**
* Returns the game instance with the specified name.
*
* @param name unique name of game to search for
* @return requested game instance
*/
public Game getGame(String name) {

Game game = null;

Iterator<Game> gamesIterator = games.iterator();

while (gamesIterator.hasNext()) {

Game gameInstance = gamesIterator.next();

if (gameInstance.getName().equalsIgnoreCase(name)) {
game = gameInstance;
}
}

return game;
}

/**
* Returns the number of games currently active
*
* @return the number of games currently active
*/
public int getGameCount() {
return games.size();
}

/**
* Returns the player whose turn is next
*
* @return the player whose turn is next
*/
public long getNextPlayerId() {
return nextPlayerId;
}

/**
* Returns the team whose turn is next
*
* @return the team whose turn is next
*/
public long getNextTeamId() {
return nextTeamId;
}
}