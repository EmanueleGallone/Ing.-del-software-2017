package it.polimi.ingsw.ps11.model.gameLogics.actions.decorator;

import it.polimi.ingsw.ps11.model.player.Player;

public abstract class PlayerAction implements Action {

	private Player player;
	
	public PlayerAction(Player player) {
		this.player = player;
	}
	
	@Override
	public Player getSource() {
		return player;
	}
	
	public abstract void enable(ActionManager aManager);

}
