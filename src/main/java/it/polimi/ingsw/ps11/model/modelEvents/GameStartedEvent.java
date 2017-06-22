package it.polimi.ingsw.ps11.model.modelEvents;

import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.player.Player;

public class GameStartedEvent extends ModelEvent{

	private Game game;
	
	public GameStartedEvent(Game game) {
		this.game = game;
	}
	
	public GameStartedEvent(Game game, Player player) {
		super(player);
		this.game = game;
	}
	
	public Game getGame() {
		return game;
	}
	
	@Override
	public void accept(ModelListener listener) {
		listener.handle(this);
	}

}
