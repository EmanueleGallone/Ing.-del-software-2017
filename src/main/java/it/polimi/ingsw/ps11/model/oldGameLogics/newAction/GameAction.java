package it.polimi.ingsw.ps11.model.oldGameLogics.newAction;

import it.polimi.ingsw.ps11.model.oldGameLogics.playerAction.PlayerStatus;

public abstract class GameAction {

	public abstract boolean isLegal();
	public abstract void perform(PlayerStatus status);
}
