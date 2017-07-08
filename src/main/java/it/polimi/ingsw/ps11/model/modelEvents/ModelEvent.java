package it.polimi.ingsw.ps11.model.modelEvents;

import it.polimi.ingsw.ps11.model.player.Player;
/** <h3> ModelEvent </h3>
 * <p> Classe evento che notifica l'avvenimento di un cambiamento nel model</p>
 */
public abstract class ModelEvent implements ModelEventInterface {

	private Player player;
	private String message = "";
	
	public ModelEvent() {

	}
	
	public ModelEvent(String message) {
		this.message = message;
	}
	
	
	public ModelEvent(Player player){
		setReceiver(player);
	}
	
	@Override
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
	@Override
	public void setReceiver(Player player) {
		this.player = player;
	}

	@Override
	public Player getReceiver() {
		return player;
	}
	
	@Override
	public abstract ModelEvent clone();
}
