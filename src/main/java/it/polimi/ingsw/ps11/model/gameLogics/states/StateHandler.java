package it.polimi.ingsw.ps11.model.gameLogics.states;

import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.gameLogics.State;
import it.polimi.ingsw.ps11.model.modelEvents.GameStartedEvent;
import it.polimi.ingsw.ps11.model.modelEvents.ModelEventInterface;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEventInterface;

public class StateHandler {

	private State currState;
	private State mainState;
	private Player player;
	private Game game;
	
	EventHandler<ModelEventInterface> modelEvent = new EventHandler<>();
	
	public StateHandler(State startState) {
		this.nextState(startState);
		this.mainState = startState;
	}
	
	public void start(){
		invoke(new GameStartedEvent(game));
	}
	
	
// Events handling 
	
	public synchronized void handle(ViewEventInterface viewEvent){
		viewEvent.accept(currState);
	}
	
	public void invoke(ModelEventInterface event){
		event.setReceiver(player);
	}
	
	public void attach(EventListener<ModelEventInterface> listener){
		this.modelEvent.attach(listener);
	}
	
// State handling 
	
	public void nextState(State state){
		state.setStateHandler(this);
		this.currState = state;
	}
	
	public void resetState(){
		this.nextState(mainState);
	}
	
	public State currentState() {
		return currState;
	}
	
// _________________________________________
	
	public void setMainState(State mainState) {
		this.mainState = mainState;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}

	
	
	public Game getGame() {
		return game;
	}
	public Player getPlayer() {
		return player;
	}

}
