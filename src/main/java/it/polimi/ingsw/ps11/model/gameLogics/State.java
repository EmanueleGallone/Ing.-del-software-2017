package it.polimi.ingsw.ps11.model.gameLogics;

import it.polimi.ingsw.ps11.view.viewEvents.ViewListener;

public abstract class State implements ViewListener{

	protected PlayerStatus playerStatus;
	
	public State(PlayerStatus playerStatus) {
		this.playerStatus = playerStatus;
	}

}
