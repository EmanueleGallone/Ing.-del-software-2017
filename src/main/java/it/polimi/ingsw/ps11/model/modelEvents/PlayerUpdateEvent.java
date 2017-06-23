package it.polimi.ingsw.ps11.model.modelEvents;

import it.polimi.ingsw.ps11.model.player.Player;

public class PlayerUpdateEvent extends ModelEvent{

	public PlayerUpdateEvent(Player player) {
		super(player);
	}
	
	public PlayerUpdateEvent(Player player, String message) {
		super(player);
		setMessage(message);
	}
	
	@Override
	public void accept(ModelListener listener) {
		listener.handle(this);
	}

}
