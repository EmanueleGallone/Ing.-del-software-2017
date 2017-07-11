package it.polimi.ingsw.ps11.model.gameLogics;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.gameLogics.actions.endGame.EndGameAction;
import it.polimi.ingsw.ps11.model.gameLogics.states.DefaultState;
import it.polimi.ingsw.ps11.model.gameLogics.states.VaticanReport;
import it.polimi.ingsw.ps11.model.modelEvents.GameUpdateEvent;
import it.polimi.ingsw.ps11.model.modelEvents.ModelEvent;
import it.polimi.ingsw.ps11.model.modelEvents.ModelEventInterface;
import it.polimi.ingsw.ps11.model.modelEvents.TextualEvent;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.VictoryPoint;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEventInterface;
/**
 * <h3> GameLogic </h3>
 * <p> Classe che gestisce la logica dela partita, organizza i giocatori e ele loro interazioni.</p>
 * @see 
 */
public class GameLogic implements Runnable{

	private Game game;
	private boolean stopTimer  = false, periodEnd = false;;
	
	private HashMap<String, StateHandler> playerStatus = new HashMap<>();
	
	public GameLogic(ArrayList<Player> players) {
		
		game = new Game(players);
		
		for(Player player : players){
			StateHandler sHandler = new StateHandler(this,player);
			playerStatus.put(player.getName(), sHandler);
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
		if(periodEnd){
			playerStatus.values().stream().forEach(s -> s.nextState(new VaticanReport(s)));
			return;
		}
		round(nextPlayer);
	}
	
	private void round(StateHandler nextPlayer){
		nextPlayer.play();
		for(StateHandler pState : playerStatus.values()){
			
			if(pState != nextPlayer ){
			    pState.nextState(new DefaultState());
			    //pState.invoke(new TextualEvent("E' il turno di " + nextPlayer.getPlayer().getName()));
			    pState.invoke(new GameUpdateEvent(game));
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
		if(game.getRoundManager().isSuspended())
			nextPlayer();
	}
	
	public void notifyVaticanReportConclusion(StateHandler sHandler){
		periodEnd = false;
		Player currentPlayer = game.getRoundManager().currentPlayer();
		if(sHandler.getPlayer().equals(currentPlayer)){
			sHandler.play();
			game.getRoundManager().startTimer();
		}
		else
			sHandler.nextState(new DefaultState());
	}

// Handle events from view
	
	public void handle(ViewEventInterface viewEvent){
		System.out.println(" - The Event "+ viewEvent.getClass().getSimpleName() + " has arrived from " + viewEvent.getSource().getName());
		playerStatus.get(viewEvent.getSource().getName()).handle(viewEvent);
		//notifyAllClients(new GameUpdateEvent(game));
	}
	
	
	public void notifyAllClients(ModelEvent event){
		for(StateHandler sHandler : playerStatus.values()){
			//System.out.println("Invio " + event.getClass().getSimpleName() + " a " + sHandler.getPlayer().getName());
			sHandler.invoke(event.clone());
		}
	}
	
	
// Handle turn sequence
	
    private transient EventListener<Player> timeOutListener = new EventListener<Player>() {

		@Override
		public void handle(Player e) {
			System.out.println("Timer ended fot the player " + e.getName());
			for(StateHandler player : playerStatus.values()){
				player.invoke(new TextualEvent("The player " + e.getName() + " is inactive."));
			}
			nextPlayer();
		}
	};
	
	private transient EventListener<RoundManager> endGameListener = new EventListener<RoundManager>() {

		@Override
		public void handle(RoundManager e) {
			
			Player winner = new Player();
			
			int maxVictoryPoint = 0;
			for(StateHandler sHandler : playerStatus.values()){
				EndGameAction endGame = new EndGameAction(sHandler.actions());
				endGame = sHandler.actions().affect(endGame);
				endGame.perform();
				
				
				sHandler.nextState(new DefaultState());
				
				ResourceList pList = sHandler.getPlayer().getResourceList();
				int victoryP = new VictoryPoint().getFrom(pList).getValue();
				if(victoryP > maxVictoryPoint){
					maxVictoryPoint = victoryP;
					winner = sHandler.getPlayer();
				}
				
			}
			
			notifyAllClients(new TextualEvent("Game over, the winner is " + winner.getName()));
		}
	};
	
	private transient EventListener<RoundManager> endPeriodListener = new EventListener<RoundManager>() {

		@Override
		public void handle(RoundManager e) {
			periodEnd = true;
		}
	};
	
	
	private transient EventListener<RoundManager> endTurnListener = new EventListener<RoundManager>() {

		@Override
		public void handle(RoundManager e) {
			try {
				if(!e.isOver()){
					game.refreshCard(e.currentPeriod());
					game.getBoard().getDices().rollDices();
					ArrayList<Player> newOrder = game.getBoard().getCouncilPalace().getNewOrder();
					game.getBoard().resetFamilyMember();
					RoundManager rManager = game.getRoundManager();
					rManager.setNewOrder(newOrder);
					for(Player player : rManager.getCurrentOrder()){
						player.getCardManager().resetLeaderCard();
					}
					
					notifyAllClients(new GameUpdateEvent(game));
				}
				
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
	};
	
	private transient EventListener<RoundManager> nobodyOnListener = new EventListener<RoundManager>() {

		@Override
		public void handle(RoundManager e) {
			stopTimer = true;
			game.getRoundManager().stopTimer();
			System.err.println("\nGame suspended, no player is active.\n");
		}
	};
	
}
