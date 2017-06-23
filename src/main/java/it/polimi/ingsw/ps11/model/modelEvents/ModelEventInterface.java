package it.polimi.ingsw.ps11.model.modelEvents;

import java.io.Serializable;

import it.polimi.ingsw.ps11.model.player.Player;

public interface ModelEventInterface extends Serializable{

	public void setReceiver(Player player);
	public Player getReceiver();
	public void accept(ModelListener listener);

}
