package it.polimi.ingsw.ps11.model.modelEvents;

import it.polimi.ingsw.ps11.model.player.Player;
/** <h3> PlayerUpdateEvent </h3>
 * <p> Classe evento che notifica l'avvenimento di un cambiamento in un giocatore</p>
 */
public class PlayerUpdateEvent extends ModelEvent{

	public PlayerUpdateEvent(Player player) {
		super(player);
	}
	
	public PlayerUpdateEvent(Player player, String message) {
		super(player);
		setMessage(message);
	}
	
	@Override
	public void accept(ModelListener listener) {
		listener.handle(this);
	}

	@Override
	public PlayerUpdateEvent clone() {
		PlayerUpdateEvent copy = new PlayerUpdateEvent(getReceiver().clone(),getMessage());
		copy.setMessage(getMessage());
		return copy;
	}
	
	

}
