package it.polimi.ingsw.ps11.cranio.game.actionsEma;

import it.polimi.ingsw.ps11.cranio.player.Player;

public abstract class PlayerAction extends Action {

	protected Player player;
	
	public PlayerAction(Player player) {
		this.player = player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	public Player getPlayer() {
		return player;
	}

}
