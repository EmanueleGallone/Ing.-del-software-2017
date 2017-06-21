package it.polimi.ingsw.ps11.model.gameLogics.event;

import it.polimi.ingsw.ps11.model.gameLogics.State;

public interface ViewEvent {

	public abstract void accept(State state);
}
