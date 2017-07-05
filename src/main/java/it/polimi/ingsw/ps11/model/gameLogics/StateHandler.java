package it.polimi.ingsw.ps11.model.gameLogics;

import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.states.PlayState;
import it.polimi.ingsw.ps11.model.modelEvents.GameUpdateEvent;
import it.polimi.ingsw.ps11.model.modelEvents.ModelEventInterface;
import it.polimi.ingsw.ps11.model.modelEvents.TextualEvent;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEventInterface;

public class StateHandler {

	private State currState;
	//private State mainState;
	private Player player;
	private GameLogic gameLogic;
	private boolean suspended;
	
	private ActionManager aManager;
	
	private EventHandler<ModelEventInterface> modelEvent = new EventHandler<>();
	
	public StateHandler(GameLogic gameLogic,Player player) {
		this.gameLogic = gameLogic;
		this.player = player;
		aManager = new ActionManager(this);
	}
	
	public void start(){
		//this.mainState = currState;
		invoke(new GameUpdateEvent(gameLogic.getGame()));
	}
	
	
	public ActionManager actions() {
		return aManager;
	}
	
// Events handling 
	
	public synchronized void handle(ViewEventInterface viewEvent){
		viewEvent.accept(currState);
	}
	
	/**
	 * E' la funzione con cui le azioni inviano eventi alla view
	 */
	public void invoke(ModelEventInterface event){
		event.setReceiver(player);
		modelEvent.invoke(event);
	}
	
	public void invoke(String message){
		this.invoke(new TextualEvent(message));
	}
	
	public void attach(EventListener<ModelEventInterface> listener){
		this.modelEvent.attach(listener);
	}
	
	public void suspended(boolean value){
		this.suspended = value;
	}
	
	public boolean isSuspended() {
		return suspended;
	}
	
	public void play(){
		nextState(new PlayState());
	}
// State handling 
	
	public void nextState(State state){
		state.setStateHandler(this);
		this.currState = state;
		System.out.println(" • Player: "+ this.getPlayer().getName() + " -> Stato: " + state.getClass().getSimpleName());
		state.notifyToClient();
	}
	
//	public void resetState(){
//		this.nextState(mainState);
//	}
	
	public State currentState() {
		return currState;
	}
	
	
// _________________________________________
	
//	public void setMainState(State mainState) {
//		this.mainState = mainState;
//	}
	public void setPlayer(Player player) {
		this.player = player;
	}

	public GameLogic getGameLogic() {
		return gameLogic;
	}
	
	public Game getGame(){
		return gameLogic.getGame();
	}
	public Player getPlayer() {
		return player;
	}

}
