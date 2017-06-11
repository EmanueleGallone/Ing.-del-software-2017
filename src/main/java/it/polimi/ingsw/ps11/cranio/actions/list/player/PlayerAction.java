package it.polimi.ingsw.ps11.cranio.actions.list.player;

import it.polimi.ingsw.ps11.cranio.actions.ActionObservable;
import it.polimi.ingsw.ps11.cranio.actions.ActionObserver;
import it.polimi.ingsw.ps11.cranio.actions.list.SourcedAction;
import it.polimi.ingsw.ps11.cranio.player.Player;

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
