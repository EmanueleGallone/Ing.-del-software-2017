package it.polimi.ingsw.ps11.cranio.bonus;

import it.polimi.ingsw.ps11.cranio.player.Player;

public abstract class Bonus {
	
	protected Player player;
	
	public abstract void behavior(Player player);
}
