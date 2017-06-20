package it.polimi.ingsw.ps11.model.oldGameLogics.actions.list.player;

import it.polimi.ingsw.ps11.model.oldGameLogics.actions.ActionObservable;
import it.polimi.ingsw.ps11.model.oldGameLogics.actions.ActionObserver;
import it.polimi.ingsw.ps11.model.oldGameLogics.actions.list.SourcedAction;
import it.polimi.ingsw.ps11.model.player.Player;

public abstract class PlayerAction<T> extends SourcedAction<Player> {

	protected ActionObservable<T> observers = new ActionObservable<>();
	
	public PlayerAction(Player player) {
		super(player);
	}
	
	public void attach(ActionObserver<T> observer){
		this.observers.addObserver(observer);
	}
	
	public void setObservers(ActionObservable<T> observers) {
		this.observers = observers;
	}
	
}
