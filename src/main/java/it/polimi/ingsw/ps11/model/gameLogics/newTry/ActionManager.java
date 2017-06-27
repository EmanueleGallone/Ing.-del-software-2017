package it.polimi.ingsw.ps11.model.gameLogics.newTry;

import java.util.HashMap;

import it.polimi.ingsw.ps11.model.gameLogics.newTry.actions.IncrementAction;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class ActionManager {
	
	Player player;
	private HashMap<String, Action> actions = new HashMap<>();
	
	
	public ActionManager(Player player) {
		this.player = player;
	}
	
	public <T extends Action> T get(Class<T> action){
		return (T) actions.get(action.toString());
	}

	public void add (Action action){
		actions.put(action.target().toString(), action);
	}
	
	public Player getSubject(){
		return player;
	}
	
	public IncrementAction newIncrementResource(ResourceList resource){
		IncrementAction a = get(IncrementAction.class);
		IncrementAction action = new IncrementAction(this,resource);
		if (a!=null)
			return a.decore(action);
		return action;
	}
	
	
}
