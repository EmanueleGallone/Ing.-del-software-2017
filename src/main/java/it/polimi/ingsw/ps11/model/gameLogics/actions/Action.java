package it.polimi.ingsw.ps11.model.gameLogics.actions;

import it.polimi.ingsw.ps11.model.player.Player;

public interface Action {
	
	public void perform();
	public boolean isLegal();
	public Player getSource();
	public Action enable(ActionManager aManager);
}
