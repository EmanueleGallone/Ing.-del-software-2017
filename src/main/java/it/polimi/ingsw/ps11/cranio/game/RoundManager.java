package it.polimi.ingsw.ps11.cranio.game;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.player.Player;

public class RoundManager {

	private ArrayList<Player> players = new ArrayList<>();
	private int actualPlayer = 0; 
	
	public RoundManager(ArrayList<Player> players) {
		this.players = players;
	}
	
	public Player nextPlayer() {
		actualPlayer += 1;
		return players.get(actualPlayer);
	}
	
	public Player getActualPlayer() {
		return players.get(actualPlayer);
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
}
