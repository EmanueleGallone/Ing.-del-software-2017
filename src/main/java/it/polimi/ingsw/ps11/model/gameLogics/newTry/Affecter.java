package it.polimi.ingsw.ps11.model.gameLogics.newTry;

public interface Affecter<T extends Action> {
	
	public void perform(boolean block);
	public T decore(T action);
}
