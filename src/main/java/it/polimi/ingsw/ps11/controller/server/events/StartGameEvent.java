package it.polimi.ingsw.ps11.controller.server.events;

import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.player.Player;

public class StartGameEvent {

	private Game game;
	private Player player;
	
	public StartGameEvent(Game game , Player player) {
		this.game = game;
		this.player = player;
	}
	
	public Game getGame() {
		return game;
	}
	public Player getPlayer() {
		return player;
	}
}
