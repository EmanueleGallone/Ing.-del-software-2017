package it.polimi.ingsw.ps11.beta.client.events;

import it.polimi.ingsw.ps11.cranio.player.Player;

public class UpdatePlayerEvent {
	
	Player player;
	
	public UpdatePlayerEvent(Player player) {
		this.player = player;
	}
	
	public Player getPlayer() {
		return player;
	}
}
