package it.polimi.ingsw.ps11.model.gameLogics.actions.list.game;

import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionObservable;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionObserver;
import it.polimi.ingsw.ps11.model.gameLogics.actions.list.SourcedAction;

public abstract class GameAction<T> extends SourcedAction<Game> {

	private ActionObservable<T> observers = new ActionObservable<>();
	
	
	public GameAction(Game game) {
		super(game);
	}
	
	public void attach(ActionObserver<T> observer){
		this.observers.addObserver(observer);
	}
	
}