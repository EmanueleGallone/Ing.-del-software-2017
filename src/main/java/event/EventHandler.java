package event;

import java.util.ArrayList;

public class EventHandler<EVENT_TYPE> {
	
	private ArrayList<Observers<EVENT_TYPE>> observersList = new ArrayList<>();

	public void attach(Observers<EVENT_TYPE> observer) {
		observersList.add(observer);
	}

	public void detach(Observers<EVENT_TYPE> observer) {
		observersList.remove(observer);
	}

	public void invoke(EVENT_TYPE parametro) {
		for(Observers<EVENT_TYPE> observer:observersList){
			observer.handle(parametro);
		}
	}
	
	
	
	
}
