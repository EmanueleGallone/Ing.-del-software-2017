package it.polimi.ingsw.ps11.model.modelEvents;

import java.io.Serializable;

import it.polimi.ingsw.ps11.model.player.Player;
/** <h3> ModelEventInterface </h3>
 * <p> Classe interfaccia per l'evento ModelEvent</p>
 */
public interface ModelEventInterface extends Serializable{

	public String getMessage();
	public void setMessage(String message);
	
	public Player getReceiver();
	public void setReceiver(Player player);
	
	public void accept(ModelListener listener);

}
