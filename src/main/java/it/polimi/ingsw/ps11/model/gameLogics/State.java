package it.polimi.ingsw.ps11.model.gameLogics;

import it.polimi.ingsw.ps11.model.gameLogics.states.StateHandler;
import it.polimi.ingsw.ps11.view.viewEvents.ViewListener;

public abstract class State implements ViewListener {
	
	private StateHandler handler;
	
	public State() {
	
	}
	
	public State(StateHandler handler) {
		this.handler = handler;
	}
	
	public void setStateHandler(StateHandler handler){
		this.handler = handler; 
	}

	public StateHandler stateHandler() {
		return handler;
	}
}
