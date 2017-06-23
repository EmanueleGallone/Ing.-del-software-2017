package it.polimi.ingsw.ps11.model.modelEvents;

import it.polimi.ingsw.ps11.model.player.Player;

public abstract class ModelEvent implements ModelEventInterface {

	private Player player;
	
	public ModelEvent() {

	}
	
	public ModelEvent(Player player){
		setReceiver(player);
	}
	
	@Override
	public void setReceiver(Player player) {
		this.player = player;
	}

	@Override
	public Player getReceiver() {
		return player;
	}
}
