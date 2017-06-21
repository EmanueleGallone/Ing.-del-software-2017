package it.polimi.ingsw.ps11.model.oldGameLogics.actions.manager;

import java.util.HashMap;

import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.oldGameLogics.actions.Action;

public class ActionManager {
	
	private HashMap<String, EventHandler<? extends Action>> actions = new HashMap<>();
	
	public <T extends Action> void attach(Class<T> event, EventListener<T> listener){
		EventHandler<T> e = this.get(event);
		e.attach(listener);
	}
	
	public <K extends EventHandler<T>, T extends Action> K get(Class<T> action){
		
		EventHandler<T> e = (EventHandler<T>) actions.get(action.getName());
		if (e == null){
			e = new EventHandler<>();
			actions.put(action.getName(), e);
		}
		return (K) e;
	}
}
