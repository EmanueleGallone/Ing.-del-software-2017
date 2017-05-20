package it.polimi.ingsw.ps11.cranio.game.loaders;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.player.Player;

public class RoundManager {
	
	private ArrayList<Player> players;
	private Player playerAttuale;
	
	public RoundManager(ArrayList<Player> players) {
		this.players = players;
	}
	
	public void choosePlayer(){
		playerAttuale = players.get(0);
	}
	
	public Player getPlayers(int i) {
		return players.get(i);
	}
	
	public Player getPlayerAttuale() {
		return playerAttuale;
	}
}
