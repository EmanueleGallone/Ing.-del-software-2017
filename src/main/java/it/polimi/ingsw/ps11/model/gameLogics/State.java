package it.polimi.ingsw.ps11.model.gameLogics;

import it.polimi.ingsw.ps11.view.viewEvents.ViewListener;
/**
 * <h3> State </h3>
 * <p> Classe che rappresenta uno stato di gioco durante una partita.</p>
 * @see 
 */
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
	
	public abstract void notifyToClient();
}
