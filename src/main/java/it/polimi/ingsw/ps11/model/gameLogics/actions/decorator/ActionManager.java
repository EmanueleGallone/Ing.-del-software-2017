package it.polimi.ingsw.ps11.model.gameLogics.actions.decorator;

import java.util.HashMap;

public class ActionManager{
	
	private HashMap<String, ActionDecorator<? extends PlayerAction>> actions = new HashMap<>();
	
	public <T extends ActionDecorator<K>, K extends PlayerAction> T get(Class<K> action) {
		return (T) actions.get(action.toString());
	}
	
	public void add(ActionDecorator<? extends Action> action){
		actions.put(action.getTarget(), action);
	}
	
	
}
