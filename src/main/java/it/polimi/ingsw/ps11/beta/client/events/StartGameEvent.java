package it.polimi.ingsw.ps11.beta.client.events;

import it.polimi.ingsw.ps11.cranio.game.Game;
import it.polimi.ingsw.ps11.cranio.player.Player;

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
