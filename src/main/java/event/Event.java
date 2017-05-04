package event;

import java.util.ArrayList;

public class Event<PARAMETER_TYPE> {
	
	private ArrayList<Observer<PARAMETER_TYPE>> observersList = new ArrayList<>();

	public void attach(Observer<PARAMETER_TYPE> observer) {
		observersList.add(observer);
	}

	public void detach(Observer<PARAMETER_TYPE> observer) {
		observersList.remove(observer);
	}

	public void invoke(PARAMETER_TYPE parameter) {
		for(Observer<PARAMETER_TYPE> observer:observersList){
			observer.handle(parameter);
		}
	}
}
