package it.polimi.ingsw.ps11.model.gameLogics.actions;

import java.util.ArrayList;
import java.util.HashMap;

import it.polimi.ingsw.ps11.model.gameLogics.StateHandler;


public class ActionManager {

	private StateHandler stateHandler;
	private HashMap<String, ArrayList<Affecter<?>>> actions = new HashMap<>();

	public ActionManager(StateHandler stateHandler) {
		this.stateHandler = stateHandler;
	}
	
	public void add(Affecter<?> affecter){
		ArrayList<Affecter<?>> aList = this.get(affecter.target());
		aList.add(affecter);
	}
	
	private <T extends Action> ArrayList<Affecter<?>> get(Class<T> aClass){
		ArrayList<Affecter<?>> aList = actions.get(aClass.toString());
		if(aList == null){
			aList = new ArrayList<>();
			actions.put(aClass.toString(), aList);
		}
		return aList;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Action> T affect(T action){
		ArrayList<Affecter<?>> aList = this.get(action.getClass());
		for(Affecter<?> aff : aList){
			Affecter<T> affecter = (Affecter<T>)aff;
			action = affecter.affect(action);
		}
		return action;
	}
	
	public StateHandler state() {
		return stateHandler;
	}
	
}
