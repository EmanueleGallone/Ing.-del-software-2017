package it.polimi.ingsw.ps11.model.gameLogics;

import it.polimi.ingsw.ps11.controller.client.RemoteClient;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.gameLogics.event.ViewEvent;
import it.polimi.ingsw.ps11.model.player.Player;

public class PlayerHandler {
	
	private State state;
	private RemoteClient client;
	private Player player;
	private Game game;
	
	
	public void setState(State state) {
		this.state = state;
	}
	
	
	EventListener<ViewEvent> clientListener = new EventListener<ViewEvent>() {

		@Override
		public void handle(ViewEvent e) {
			e.accept(state);
		}
	};
	

	public Player getPlayer() {
		return player;
	}
	public Game getGame() {
		return game;
	}
	public RemoteClient getClient() {
		return client;
	}
	
}
