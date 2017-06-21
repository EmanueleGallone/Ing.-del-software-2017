package it.polimi.ingsw.ps11.view.viewGenerica;

import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.events.EventManager;
import it.polimi.ingsw.ps11.model.game.GameLoader;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.zones.Board;
import it.polimi.ingsw.ps11.view.ViewInterface;
import it.polimi.ingsw.ps11.view.viewEvents.FloorSelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEvent;
import it.polimi.ingsw.ps11.view.viewGenerica.components.BoardView;
import it.polimi.ingsw.ps11.view.viewGenerica.components.Console;
import it.polimi.ingsw.ps11.view.viewGenerica.components.PlayerView;

public abstract class View implements ViewInterface, Runnable {
	
	protected Console console;
	protected PlayerView you;
	protected BoardView boardView;
	
	protected EventManager events = new EventManager();
	protected EventHandler<ViewEvent> viewEvent = new EventHandler<>();
	
	public View() {
		
	}


	@Override
	public void out(String message) {
		console.println(message);
	}
	
	// EVENT _____________________________
	
	public void attachFloorSelected(EventListener<FloorSelectedEvent> listener) {
		events.attach(FloorSelectedEvent.class, listener);
	}
	
	public void attach(EventListener<ViewEvent> listener){
		this.viewEvent.attach(listener);
	}
	
	// UPDATE ____________________________
	
	@Override
	public void update(Board board) {
		boardView.update(board);
	}

	@Override
	public void update(Player player) {
		you.update(player);
	}
}
