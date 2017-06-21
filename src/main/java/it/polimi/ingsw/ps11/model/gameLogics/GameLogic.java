package it.polimi.ingsw.ps11.model.gameLogics;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.game.RoundManager;
import it.polimi.ingsw.ps11.model.modelEvents.GameStartedEvent;
import it.polimi.ingsw.ps11.model.modelEvents.ModelEvent;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.view.viewEvents.FloorSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.ViewListener;

public class GameLogic implements Runnable,ViewListener{

	private Game game;
	private RoundManager roundManager;

	EventHandler<ModelEvent> modelEvent = new EventHandler<>();
	
	public GameLogic(ArrayList<Player> players) {
		roundManager = new RoundManager(players);
		game = new Game(players.size());
	}

	
	public Game getGame() {
		return game;
	}
	
	public void attach(EventListener<ModelEvent> listener){
		this.modelEvent.attach(listener);
	}

	@Override
	public void run() {
		for(Player player: roundManager.getCurrentOrder()){
			modelEvent.invoke(new GameStartedEvent(game, player));
		}
	}

// Handle events from view
	
	@Override
	public void handle(FloorSelectedEvent floorSelectedEvent) {
		System.out.println("Un floor e' stato selezionato da " + floorSelectedEvent.getPlayer().getName());
	}

}
