package it.polimi.ingsw.ps11.model.gameLogics.actions;

import java.util.HashMap;

import it.polimi.ingsw.ps11.model.gameLogics.actions.base.DecrementAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.IncrementAction;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class ActionManager {
	
	Player player;
	private HashMap<String, Action> actions = new HashMap<>();
	
	
	public ActionManager(Player player) {
		this.player = player;
	}
	
	public <T extends Action> T get(Class<T> action){
		Action actionDecorator = actions.get(action.toString());
		if(actionDecorator != null){
			actionDecorator = actionDecorator.clone();
		}
		return (T) actionDecorator;
	}

	public void add (Action action){
		actions.put(action.target().toString(), action);
	}
	
	public Player getSubject(){
		return player;
	}
	
	public IncrementAction newIncrementAction(ResourceList resource){
		IncrementAction decorator = get(IncrementAction.class);
		IncrementAction action = new IncrementAction(this,resource);
		if (decorator!=null){
			 decorator.decore(action);
			 return decorator;
		}
		return action;
	}
	
	public DecrementAction newDecrementAction(ResourceList resource){
		DecrementAction a = get(DecrementAction.class);
		DecrementAction action = new DecrementAction(this,resource);
		if (a!=null)
			return a.decore(action);
		return action;
	}
	
	
}
