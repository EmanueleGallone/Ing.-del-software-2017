package it.polimi.ingsw.ps11.view.viewEvents;

import java.io.Serializable;

import it.polimi.ingsw.ps11.model.player.Player;

public interface ViewEvent extends Serializable {

	public void setSource(Player player);
	public void accept(ViewListener listener);
}
