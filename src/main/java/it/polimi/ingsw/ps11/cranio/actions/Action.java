package it.polimi.ingsw.ps11.cranio.actions;

import java.util.ArrayList;

public abstract class Action<T> implements ActionInterface {
	
	ArrayList<ActionObserver<T>> observers = new ArrayList<>();
	
	
	public void addObserver(ActionObserver<T> listener){
		this.observers.add(listener);
	}
	
	protected void performEvent(T action){
		for(ActionObserver<T> observer : observers){
			observer.affectPerform(action);
		}
	}
	
	protected boolean validationEvent(T action){
		for(ActionObserver<T> observer : observers){
			if (!observer.affectCondiction(action))
				return false;
		}
		return true;
	}
}
