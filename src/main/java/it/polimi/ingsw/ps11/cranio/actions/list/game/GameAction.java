package it.polimi.ingsw.ps11.cranio.actions.list.game;

import it.polimi.ingsw.ps11.cranio.actions.ActionObservable;
import it.polimi.ingsw.ps11.cranio.actions.ActionObserver;
import it.polimi.ingsw.ps11.cranio.actions.list.SourcedAction;
import it.polimi.ingsw.ps11.cranio.game.Game;

public abstract class GameAction<T> extends SourcedAction<Game> {

	private ActionObservable<T> observers = new ActionObservable<>();
	
	
	public GameAction(Game game) {
		super(game);
	}
	
	public void attach(ActionObserver<T> observer){
		this.observers.addObserver(observer);
	}
	
}