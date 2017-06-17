package it.polimi.ingsw.ps11.controller.server.events;

import it.polimi.ingsw.ps11.model.player.Player;

public class UpdatePlayerEvent {
	
	Player player;
	
	public UpdatePlayerEvent(Player player) {
		this.player = player;
	}
	
	public Player getPlayer() {
		return player;
	}
}
