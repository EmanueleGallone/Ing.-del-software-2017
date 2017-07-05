package it.polimi.ingsw.ps11.model.gameLogics;

import java.util.ArrayList;
import java.util.HashMap;

import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.gameLogics.states.DefaultState;
import it.polimi.ingsw.ps11.model.gameLogics.states.PlayState;
import it.polimi.ingsw.ps11.model.modelEvents.ModelEventInterface;
import it.polimi.ingsw.ps11.model.modelEvents.TextualEvent;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEventInterface;

public class GameLogic implements Runnable{

	private Game game;
	private boolean stopTimer  = false;
	private HashMap<String, StateHandler> playerStatus = new HashMap<>();
	
	public GameLogic(ArrayList<Player> players) {
		
		game = new Game(players);
		
		for(Player player : players){
			playerStatus.put(player.getName(), new StateHandler(this,player));
		}
		
		RoundManager roundManager = game.getRoundManager();
		roundManager.timeOutEvent(timeOutListener);
		roundManager.newTurnEvent(endTurnListener);
		roundManager.newPeriodEvent(endPeriodListener);
		roundManager.gameOverEvent(endGameListener);
		roundManager.nobodyOnEvent(nobodyOnListener);
	}
	
	public void nextPlayer(){
		String nextPlayerName = game.getRoundManager().next().getName();
		StateHandler nextPlayer = playerStatus.get(nextPlayerName);
		
		nextPlayer.nextState(new PlayState());
		nextPlayer.invoke(new TextualEvent("E' il tuo turno!"));
		
		for(StateHandler pState : playerStatus.values()){
			
			if(pState != nextPlayer ){
			    pState.nextState(new DefaultState());
			    pState.invoke(new TextualEvent("Non è il tuo turno"));
			}
		}
		
		if(!stopTimer)
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
	
	public ArrayList<StateHandler> getPlayerStatus() {
		return new ArrayList<>(playerStatus.values());
	}
	
	public void attach(EventListener<ModelEventInterface> listener){
		for(StateHandler playerState : playerStatus.values()){
			playerState.attach(listener);
		}
	}
	
	public void notifyNewConnection(Player newPlayer){
		stopTimer = false;
		game.getRoundManager().removeFromAfk(newPlayer);
		nextPlayer();
	}

// Handle events from view
	
	public void handle(ViewEventInterface viewEvent){
		System.out.println(" - E' arrivato l'evento "+ viewEvent.getClass().getSimpleName() + " da " + viewEvent.getSource().getName());
		playerStatus.get(viewEvent.getSource().getName()).handle(viewEvent);
	}
	
	
// Handle turn sequence
	
    private transient EventListener<Player> timeOutListener = new EventListener<Player>() {

		@Override
		public void handle(Player e) {
			System.out.println("Timer scattato per il player " + e);
			for(StateHandler player : playerStatus.values()){
				player.invoke(new TextualEvent("Il giocatore " + e + " è inattivo"));
			}
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
	
	private transient EventListener<RoundManager> nobodyOnListener = new EventListener<RoundManager>() {

		@Override
		public void handle(RoundManager e) {
			stopTimer = true;
			game.getRoundManager().stopTimer();
			System.err.println("\nPartita sospesa, nessuno sta giocando\n");
		}
	};
}
