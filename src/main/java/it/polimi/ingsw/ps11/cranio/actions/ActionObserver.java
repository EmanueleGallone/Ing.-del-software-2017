package it.polimi.ingsw.ps11.cranio.actions;

public interface ActionObserver<ACTION_TYPE> {
	
	public void affectPerform(ACTION_TYPE action);
	
	public  default boolean affectCondiction(ACTION_TYPE action){
		return true;
	}
	
}
