package it.polimi.ingsw.ps11.model.gameLogics;

import it.polimi.ingsw.ps11.view.viewEvents.ViewListener;

public abstract class State implements ViewListener{

	protected PlayerHandler playerHandler;
	
	public State(PlayerHandler playerHandler) {
		this.playerHandler = playerHandler;
	}

}
