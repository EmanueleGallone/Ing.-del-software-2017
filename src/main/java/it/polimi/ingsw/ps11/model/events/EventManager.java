package it.polimi.ingsw.ps11.model.events;

import java.util.HashMap;

public class EventManager {

	private HashMap<String, EventHandler<?>> events = new HashMap<>();
	

	public void addEvent(Class<?> event){
		events.put(event.getName(), new EventHandler<>());
	}
	
	public <T> void attach(Class<T> event, EventListener<T> listener){
		EventHandler<T> e = this.get(event);
		e.attach(listener);
	}
	
	public <T> void invoke(Class<T> event, T parameter){
		EventHandler<T> e = this.get(event);
		e.invoke(parameter);
	}
	
	private <K extends EventHandler<T>, T> K get(Class<T> event){
		
		EventHandler<T> e = (EventHandler<T>) events.get(event.getName());
		if (e == null){
			e = new EventHandler<>();
			events.put(event.getName(), e);
		}
		return (K) e;
	}

}
