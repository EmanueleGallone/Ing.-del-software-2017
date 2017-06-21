package it.polimi.ingsw.ps11.model.oldGameLogics.actions.list.game;

import it.polimi.ingsw.ps11.model.game.GameLoader;
import it.polimi.ingsw.ps11.model.oldGameLogics.actions.ActionObservable;
import it.polimi.ingsw.ps11.model.oldGameLogics.actions.ActionObserver;
import it.polimi.ingsw.ps11.model.oldGameLogics.actions.list.SourcedAction;

public abstract class GameAction<T> extends SourcedAction<GameLoader> {

	private ActionObservable<T> observers = new ActionObservable<>();
	
	
	public GameAction(GameLoader game) {
		super(game);
	}
	
	public void attach(ActionObserver<T> observer){
		this.observers.addObserver(observer);
	}
	
}