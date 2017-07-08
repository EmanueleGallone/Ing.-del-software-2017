package it.polimi.ingsw.ps11.model.modelEvents;

import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.player.Player;
/** <h3> GameStartedEvent </h3>
 * <p> Classe evento che gestisce l'inizio di una partita</p>
 */
public class GameUpdateEvent extends ModelEvent{

	private Game game;
	
	public GameUpdateEvent(Game game) {
		this.game = game;
	}
	
	public GameUpdateEvent(Game game, Player player) {
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

	@Override
	public ModelEvent clone() {
		GameUpdateEvent copy = new GameUpdateEvent(game);
		if(getReceiver()!=null)
			copy.setReceiver(getReceiver().clone());
		copy.setMessage(getMessage());
		return copy;
	}
	
	

}
