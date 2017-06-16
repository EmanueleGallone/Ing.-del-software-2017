package it.polimi.ingsw.ps11.cranio.bonus;

import it.polimi.ingsw.ps11.cranio.player.Player;

public abstract class PlayerBonus extends Bonus {
	
	protected transient Player player;

	public abstract void behavior();
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	//@Override
	//public abstract PlayerBonus clone();

}
