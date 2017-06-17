package it.polimi.ingsw.ps11.model.events;

import java.util.ArrayList;

public class EventHandler<PARAMETER_TYPE> {
	
	private ArrayList<EventListener<PARAMETER_TYPE>> eventListeners = new ArrayList<>();

	public void attach(EventListener<PARAMETER_TYPE> eventListener) {
		eventListeners.add(eventListener);
	}

	public void detach(EventListener<PARAMETER_TYPE> eventListener) {
		eventListeners.remove(eventListener);
	}

	public void invoke(PARAMETER_TYPE parameter) {
		for(EventListener<PARAMETER_TYPE> listener:eventListeners){
			listener.handle(parameter);
		}
	}
}