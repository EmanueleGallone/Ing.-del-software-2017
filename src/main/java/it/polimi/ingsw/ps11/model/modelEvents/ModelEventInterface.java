package it.polimi.ingsw.ps11.model.modelEvents;

import java.io.Serializable;

import it.polimi.ingsw.ps11.model.player.Player;

public interface ModelEventInterface extends Serializable{

	public String getMessage();
	public void setMessage(String message);
	
	public Player getReceiver();
	public void setReceiver(Player player);
	
	public void accept(ModelListener listener);

}
