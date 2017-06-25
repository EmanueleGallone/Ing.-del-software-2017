package it.polimi.ingsw.ps11.model.gameLogics.actions.old;

public interface ActionObserver<T extends Action> {
	
	public void affectPerform(T action);
	
	public  default boolean affectCondiction(T action){
		return true;
	}
	
}
