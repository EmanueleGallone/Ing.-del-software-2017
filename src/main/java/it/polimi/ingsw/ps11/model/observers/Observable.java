package it.polimi.ingsw.ps11.model.observers;

import java.util.ArrayList;

public class Observable {
	private ArrayList<Observer> observers = new ArrayList<>();
	
	public void attach(Observer observer) {
		observers.add(observer);		
	}
	
	public void detach(Observer observer) {
		observers.remove(observer);
	}
	
	public void notifyObservers() {
		for(Observer observer : observers)
			observer.update();
	}

}