package it.polimi.ingsw.ps11.model.gameLogics.actions;

import java.util.ArrayList;
import java.util.HashMap;

import it.polimi.ingsw.ps11.model.gameLogics.StateHandler;
import it.polimi.ingsw.ps11.model.gameLogics.states.DefaultState;
/**
 * <h3> ActionManager </h3>
 * <p> Classe Manager per le <code>Action</code>. Associa ad ogni tipo di dato azione l'affecter corrispondente. Gestisce
 * i vari stati di gioco</p>
 * @see Action
 * @see DefaultState
 */
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
	
	private <T extends Action> ArrayList<Affecter<?>> get(String aClass){
		ArrayList<Affecter<?>> aList = actions.get(aClass);
		if(aList == null){
			aList = new ArrayList<>();
			actions.put(aClass, aList);
		}
		return aList;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Action> T affect(T action){
		ArrayList<Affecter<?>> aList = this.get(action.name());
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
