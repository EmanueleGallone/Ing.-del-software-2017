package it.polimi.ingsw.ps11.model.gameLogics;

import it.polimi.ingsw.ps11.model.player.Player;

public class PlayerStatus {
	
	private State state;
	private Player player;
	
	
	public PlayerStatus(Player player) {
		this.player = player;
	}
	public PlayerStatus(Player player, State state) {
		this(player);
		this.state = state;
	}
	
	public void setState(State state) {
		this.state = state;
	}
	public State getState() {
		return state;
	}

	public Player getPlayer() {
		return player;
	}
	
}
