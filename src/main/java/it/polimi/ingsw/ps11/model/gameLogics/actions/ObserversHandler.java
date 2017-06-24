package it.polimi.ingsw.ps11.model.gameLogics.actions;

import java.util.ArrayList;

public class ObserversHandler<T extends Action> {
	
	private	ArrayList<ActionObserver<T>> observers = new ArrayList<>();
	
	public void attach(ActionObserver<T> observer){
		this.observers.add(observer);
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
