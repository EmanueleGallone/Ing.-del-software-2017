package it.polimi.ingsw.ps11.model.gameLogics;

import java.util.ArrayList;
import java.util.HashMap;

import it.polimi.ingsw.ps11.controller.ConsoleLog;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.game.RoundManager;
import it.polimi.ingsw.ps11.model.gameLogics.states.DefaultState;
import it.polimi.ingsw.ps11.model.gameLogics.states.PlayState;
import it.polimi.ingsw.ps11.model.modelEvents.ModelEventInterface;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEventInterface;

public class GameLogic implements Runnable{

	private Game game;

	private HashMap<Player, StateHandler> playerStatus = new HashMap<>();
	
	public GameLogic(ArrayList<Player> players) {
		
		game = new Game(players);
		
		for(Player player : players){
			playerStatus.put(player, new StateHandler(this,player));
		}
		
		RoundManager roundManager = game.getRoundManager();
		roundManager.timeOutEvent(timeOutListener);
		roundManager.newTurnEvent(endTurnListener);
		roundManager.newPeriodEvent(endPeriodListener);
		roundManager.gameOverEvent(endGameListener);
	}
	
	public void nextPlayer(){
		Player nextPlayer = game.getRoundManager().next();
		for(StateHandler playerState : playerStatus.values()){
			
			if(playerState.getPlayer().equals(nextPlayer))
				playerState.nextState(new PlayState());
			else {
			    playerState.nextState(new DefaultState());
			}
		}
		game.getRoundManager().startTimer();
	}

	@Override
	public void run() {
		nextPlayer();
		for(StateHandler playerState : playerStatus.values()){
			playerState.start();
		}
	}
	
	public Game getGame() {
		return game;
	}
	
	public void attach(EventListener<ModelEventInterface> listener){
		for(StateHandler playerState : playerStatus.values()){
			playerState.attach(listener);
		}
	}

// Handle events from view
	
	public void handle(ViewEventInterface viewEvent){
		new ConsoleLog().println(" - E' arrivato l'evento "+ viewEvent.getClass().getSimpleName() + " da " + viewEvent.getSource().getName());
		playerStatus.get(viewEvent.getSource()).handle(viewEvent);
	}
	
	
// Handle turn sequence
	
    private transient EventListener<Player> timeOutListener = new EventListener<Player>() {

		@Override
		public void handle(Player e) {
			nextPlayer();
		}
	};
	
	private transient EventListener<RoundManager> endGameListener = new EventListener<RoundManager>() {

		@Override
		public void handle(RoundManager e) {
			// TODO Auto-generated method stub
			System.out.println("Il gioco è finito");
		}
	};
	
	private transient EventListener<RoundManager> endPeriodListener = new EventListener<RoundManager>() {

		@Override
		public void handle(RoundManager e) {
			// TODO Auto-generated method stub
			//C'e' da fare tutta la roba delle scomuniche
		}
	};
	
	
	private transient EventListener<RoundManager> endTurnListener = new EventListener<RoundManager>() {

		@Override
		public void handle(RoundManager e) {
			// TODO Auto-generated method stub
			
		}
	};
}
