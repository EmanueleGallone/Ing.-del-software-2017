package it.polimi.ingsw.ps11.model.modelEvents;

import it.polimi.ingsw.ps11.model.player.Player;

public class Event {

	private Player player;
	
	public Event() {
	
	}
	
	public Event(Player player) {
		setSource(player);
	}
	
	public void setSource(Player player) {
		this.player = player;
	}

	public Player getSource() {
		return player;
	}
}
