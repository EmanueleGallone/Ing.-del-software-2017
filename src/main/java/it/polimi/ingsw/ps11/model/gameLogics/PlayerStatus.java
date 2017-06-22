package it.polimi.ingsw.ps11.model.gameLogics;

public class PlayerStatus {
	
	private State currentState;
	
	public State getCurrentState() {
		return currentState;
	}
	public void setState(State nextState) {
		this.currentState = nextState;
	}
}
