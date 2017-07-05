package it.polimi.ingsw.ps11.model.gameLogics.actions;

public interface Affecter<T extends Action> {
	
	public Class<? extends Action> target();
	public T affect(T action);
	
}
