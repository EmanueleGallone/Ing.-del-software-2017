package it.polimi.ingsw.ps11.model.gameLogics;

public abstract class State implements EventRecognizer{

	protected PlayerHandler playerHandler;
	
	public State(PlayerHandler playerHandler) {
		this.playerHandler = playerHandler;
	}

}
