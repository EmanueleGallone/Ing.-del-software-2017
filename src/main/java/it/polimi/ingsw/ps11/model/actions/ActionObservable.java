package it.polimi.ingsw.ps11.model.actions;

import java.util.ArrayList;

public class ActionObservable<T> {
	
	private	ArrayList<ActionObserver<T>> observers = new ArrayList<>();
	
	public void addObserver(ActionObserver<T> listener){
		this.observers.add(listener);
	}
	
	public void performEvent(T action){
		for(ActionObserver<T> observer : observers){
			observer.affectPerform(action);
		}
	}
	
	public boolean validationEvent(T action){
		for(ActionObserver<T> observer : observers){
			if (!observer.affectCondiction(action))
				return false;
		}
		return true;
	}
}
