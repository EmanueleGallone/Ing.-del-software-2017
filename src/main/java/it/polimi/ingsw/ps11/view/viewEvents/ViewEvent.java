package it.polimi.ingsw.ps11.view.viewEvents;

import it.polimi.ingsw.ps11.model.player.Player;

public abstract class ViewEvent implements ViewEventInterface{

	private Player player;
	
	public ViewEvent() {
	
	}
	
	public ViewEvent(Player player) {
		setSource(player);
	}
	
	@Override
	public void setSource(Player player) {
		this.player = player;
	}

	@Override
	public Player getSource() {
		return player;
	}

}
