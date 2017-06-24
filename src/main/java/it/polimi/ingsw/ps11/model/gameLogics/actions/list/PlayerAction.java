package it.polimi.ingsw.ps11.model.gameLogics.actions.list;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.player.Player;

public abstract class PlayerAction implements Action {

	private Player player;
	private ActionManager actionManager;

	public PlayerAction(Player player) {
		this.player = player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	public Player getPlayer() {
		return player;
	}
	
	public boolean isAssigned() {
		if(player != null)
			return true;
		return false;
	}
	
	@Override
	public void setObservers(ActionManager actionManager) {
		this.actionManager = actionManager;
	}
	
	@Override
	public ActionManager getObservers() {
		return actionManager;
	}
}
