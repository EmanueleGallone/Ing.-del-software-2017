package it.polimi.ingsw.ps11.model.modelEvents;

import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.player.Player;

public class GameStartedEvent implements ModelEvent{

	private Game game;
	private Player player;
	
	public GameStartedEvent(Game game, Player player) {
		this.game = game;
		this.player = player;
	}
	
	public Game getGame() {
		return game;
	}
	public Player getPlayer() {
		return player;
	}
	
	@Override
	public void accept(ModelListener listener) {
		listener.handle(this);
	}

	@Override
	public void setReceiver(Player player) {
		this.player = player;
	}

	@Override
	public Player getReceiver() {
		return player;
	}

}
