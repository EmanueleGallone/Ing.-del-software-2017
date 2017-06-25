package it.polimi.ingsw.ps11.model.gameLogics.actions;

import java.util.HashMap;
import java.util.Optional;

public class ActionManager{
	
	private HashMap<String, ActionDecorator<? extends Action>> actions = new HashMap<>();
	
	public <T extends ActionDecorator<K>, K extends Action> Optional<T> get(Class<K> action) {
		Optional<T> optional = Optional.empty();
		return Optional.of((T)actions.get(action.toString()));
		//return (T) actions.get(action.toString());
	}
	
	public void add(ActionDecorator<? extends Action> action){
		actions.put(action.getTarget(), action);
	}
	
	
}
