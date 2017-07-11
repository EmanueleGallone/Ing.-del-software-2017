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
/**
 * <h3> State </h3>
 * <p> Classe che rappresenta lo stato di un giocatore e ne gestisce le azioni. Associa un giocatore al relativo action manager.</p>
 * @see 
 */
public class StateHandler {

	private State currState;
	private Player player;
	private GameLogic gameLogic;
	private boolean actionDone;
	
	private ActionManager aManager;
	
	private EventHandler<ModelEventInterface> modelEvent = new EventHandler<>();
	
	public StateHandler(GameLogic gameLogic,Player player) {
		this.gameLogic = gameLogic;
		this.player = player;
		aManager = new ActionManager(this);
	}
	
	public void start(){
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
	
	public void play(){
		actionDone = false;
		nextState(new PlayState());
		invoke(new TextualEvent("It's your turn to Play!"));
		aManager.state().invoke(new GameUpdateEvent(aManager.state().getGame()));
	}
// State handling 
	
	public void nextState(State state){
		state.setStateHandler(this);
		this.currState = state;
		System.out.println(" • Player: "+ this.getPlayer().getName() + " -> State: " + state.getClass().getSimpleName());
		state.notifyToClient();
	}
	
	
	public State currentState() {
		return currState;
	}
	
	public boolean isDone() {
		return actionDone;
	}
	public void setActionDone(boolean actionDone) {
		this.actionDone = actionDone;
	}
// _________________________________________
	

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
