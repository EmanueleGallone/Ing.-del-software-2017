package it.polimi.ingsw.ps11.model.gameLogics;

import java.io.IOException;
import java.util.ArrayList;

import it.polimi.ingsw.ps11.controller.message.ModelMessage;
import it.polimi.ingsw.ps11.controller.network.Connection;
import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.modelEvents.GameStartedEvent;
import it.polimi.ingsw.ps11.model.modelEvents.ModelEvent;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.view.viewEvents.FloorSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.ViewListener;

public class GameLogic implements Runnable,ViewListener{

	private Game game;
	
	EventHandler<ModelEvent> modelEvent = new EventHandler<>();
	
	public GameLogic(ArrayList<Player> players) {
		game = new Game(players);
	}

	
	public Game getGame() {
		return game;
	}
	
	public void attach(EventListener<ModelEvent> listener){
		this.modelEvent.attach(listener);
	}
	
	@Override
	public void handle(FloorSelectedEvent floorSelectedEvent) {
		System.out.println("Un floor e' stato selezionato da " + floorSelectedEvent.getPlayer().getName());
	}


	@Override
	public void run() {
		for(Player player: game.getRoundManager().getCurrentOrder()){
			modelEvent.invoke(new GameStartedEvent(game, player));
		}
	}

}
