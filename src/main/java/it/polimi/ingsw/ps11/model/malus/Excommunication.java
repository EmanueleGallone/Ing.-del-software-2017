package it.polimi.ingsw.ps11.model.malus;

import it.polimi.ingsw.ps11.model.player.Player;

public abstract class Excommunication {
	
	//due soluzioni: o questi oggetti li tratto come "flag" e definisco il loro comportamento all'interno di Action
	//oppure sono oggetti a loro stanti che devono conoscere il loro proprietario affinchè attivino il loro comportamento
	//all'interno dell'Action
	
	protected transient Player owner;
	protected int period;
	
	/*public Excommunication(Player player) {
		this.owner = player;
	}*/
	
	public abstract void behaviour();
	
	public void setOwner(Player owner) {
		this.owner = owner;
	}
	
	public Player getOwner() {
		return owner;
	}
	
	public void setPeriod(int period) {
		this.period = period;
	}
	
	public int getPeriod() {
		return period;
	}

}
