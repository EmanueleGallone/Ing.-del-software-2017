package it.polimi.ingsw.ps11.model.gameLogics.newTry;

import java.util.HashMap;
import java.util.Optional;

public class ActionManager {
	
	private HashMap<String, Action> actions = new HashMap<>();
//	
//	public <T extends ActionDecorator<K>, K extends Action> Optional<T> get(Class<K> action) {
//		Optional<T> optional = Optional.empty();
//		return Optional.of((T)actions.get(action.toString()));
//		//return (T) actions.get(action.toString());
//	}
//	
//	public void add(ActionDecorator<? extends Action> action){
//		actions.put(action.getTarget(), action);
//	}
	
//	public <T extends Action> Optional<T> get(Class<T> action){
//		Optional<T> optional = Optional.empty();
//		return Optional.of((T)actions.get(action.toString()));
//	}
	
	public <T extends Action> T get(Class<T> action){
		return (T)actions.get(action.toString());
	}
	
}
