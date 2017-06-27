package it.polimi.ingsw.ps11.model.gameLogics.newTry;

public interface Affecter<T extends Action> {
	public T decore(T action);
}
