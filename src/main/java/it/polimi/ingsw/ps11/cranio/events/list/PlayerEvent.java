package it.polimi.ingsw.ps11.cranio.events.list;

import it.polimi.ingsw.ps11.cranio.events.Event;
import it.polimi.ingsw.ps11.cranio.player.Player;

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
