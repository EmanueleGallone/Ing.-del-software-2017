package it.polimi.ingsw.ps11.model.gameLogics;

import it.polimi.ingsw.ps11.model.modelEvents.TextualEvent;
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
	
	public void notifyToClient() {
		System.out.println("Notifico lo stato " + this.getClass().getSimpleName());
		stateHandler().invoke(new TextualEvent("Sei nello stato: " + this.getClass().getSimpleName()));
	}
}
