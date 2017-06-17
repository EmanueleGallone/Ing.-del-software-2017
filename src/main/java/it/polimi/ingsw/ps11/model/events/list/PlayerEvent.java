package it.polimi.ingsw.ps11.model.events.list;

import it.polimi.ingsw.ps11.model.events.Event;
import it.polimi.ingsw.ps11.model.player.Player;

public class PlayerEvent extends Event {

	private Player source;
	
	public PlayerEvent(Player player) {
		this.source = player;
	}
	
	@Override
	public Player getSource() {
		return  source;
	}
}
