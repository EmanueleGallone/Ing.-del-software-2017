package it.polimi.ingsw.ps11.model.gameLogics;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.game.GameLoader;
import it.polimi.ingsw.ps11.model.game.RoundManager;
import it.polimi.ingsw.ps11.model.gameLogics.states.DefaultState;
import it.polimi.ingsw.ps11.model.modelEvents.GameStartedEvent;
import it.polimi.ingsw.ps11.model.modelEvents.ModelEvent;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.zones.Board;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEvent;

public class GameLogic implements Runnable{

	private Board board;
	private RoundManager roundManager;
	
	ArrayList<PlayerStatus> playerHandlers = new ArrayList<>();
	
	
	EventHandler<ModelEvent> modelEvent = new EventHandler<>();
	
	public GameLogic(ArrayList<Player> players) {
		roundManager = new RoundManager(players);
		board = new GameLoader(players.size()).getBoard();
		for(Player player : players){
			PlayerStatus startStatus = new PlayerStatus(player);
			startStatus.setState(new DefaultState(startStatus));
			playerHandlers.add(startStatus);
		}
	}


	public Board getBoard() {
		return board;
	}
	
	public void attach(EventListener<ModelEvent> listener){
		this.modelEvent.attach(listener);
	}

	@Override
	public void run() {
		for(Player player: roundManager.getCurrentOrder()){
			modelEvent.invoke(new GameStartedEvent(board, player));
		}
	}

// Handle events from view
	
	public void handle(ViewEvent viewEvent){
		for(PlayerStatus pHandler : playerHandlers){
			if(pHandler.getPlayer().equals(viewEvent.getSource())){
				viewEvent.accept(pHandler.getState());
			}
		}
	}
}
