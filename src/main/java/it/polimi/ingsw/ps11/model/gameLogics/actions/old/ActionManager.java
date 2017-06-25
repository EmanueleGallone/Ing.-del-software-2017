package it.polimi.ingsw.ps11.model.gameLogics.actions.old;

import java.util.HashMap;

public class ActionManager {

	private HashMap<String , ObserversHandler<? extends Action>> observers = new HashMap<>();
	
	
	public <T extends Action> ObserversHandler<T> get(Class<T> action){
		ObserversHandler<T> obHandler = (ObserversHandler<T>) observers.get(action.toString());
		if (obHandler == null){
			obHandler = new ObserversHandler<T>();
			observers.put(action.toString(), obHandler);
		}
		return obHandler;
	}
	
	public <T extends Action> boolean isLegal(T action){
		action.setActionManager(this);
		Class<T> aClass = (Class<T>) action.getClass();
		boolean result = get(aClass).validationEvent(action);
		return  result && action.isLegal();
	}
	
	public <T extends Action> void perform(T action){
		action.setActionManager(this);
		Class<T> aClass = (Class<T>) action.getClass();
		get(aClass).performEvent(action);
		action.perform();
	}
}
