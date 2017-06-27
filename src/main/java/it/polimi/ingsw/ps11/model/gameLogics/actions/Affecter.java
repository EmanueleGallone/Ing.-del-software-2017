package it.polimi.ingsw.ps11.model.gameLogics.actions;

public interface Affecter<T extends Action> {
	public T decore(T action);
}
