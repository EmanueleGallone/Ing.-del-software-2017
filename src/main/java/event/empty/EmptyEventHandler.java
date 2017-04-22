package event.empty;

import java.util.ArrayList;

import event.Observers;

public class EmptyEventHandler {
	
	private ArrayList<Observer> observersList = new ArrayList<>();
	
	public void attach(Observer observer) {
		observersList.add(observer);
	}
	
	public void detach(Observer observer) {
		observersList.remove(observer);
	}
	
	public void invoke() {
		for(Observer observer:observersList){
			observer.handle();
		}
	}
}
