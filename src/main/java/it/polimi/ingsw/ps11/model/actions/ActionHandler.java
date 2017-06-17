package it.polimi.ingsw.ps11.model.actions;

import java.util.HashMap;

public class ActionHandler {

	private HashMap<String, Action> actions = new HashMap<>();
	
	public ActionHandler() {
	
	}
	
	
	public <T extends Action> void add(T action){
		actions.put(action.getClass().toString(), action);
	}
	
	public <T extends Action> T get(Class<T> action){
		return (T) actions.get(action.toString());
	}
	
}
