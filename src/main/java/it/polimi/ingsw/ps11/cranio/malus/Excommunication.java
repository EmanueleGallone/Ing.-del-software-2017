package it.polimi.ingsw.ps11.cranio.malus;

import it.polimi.ingsw.ps11.cranio.player.Player;

public abstract class Excommunication {
	
	protected Player owner;
	
	public abstract void behaviour();
	
	public void setOwner(Player owner) {
		this.owner = owner;
	}
	
	public Player getOwner() {
		return owner;
	}

}
