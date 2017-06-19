package it.polimi.ingsw.ps11.model.gameLogics.actions.list;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;

public abstract class SourcedAction<T> extends Action {
	
	private T source;

	public SourcedAction(T source) {
		this.source = source;
	}
	
	public T getSource() {
		return source;
	}
	
}