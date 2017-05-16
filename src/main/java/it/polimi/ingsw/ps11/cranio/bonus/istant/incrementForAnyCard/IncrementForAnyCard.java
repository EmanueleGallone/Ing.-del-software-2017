package it.polimi.ingsw.ps11.cranio.bonus.istant.incrementForAnyCard;

import it.polimi.ingsw.ps11.cranio.bonus.Bonus;
import it.polimi.ingsw.ps11.cranio.player.Player;

public abstract class IncrementForAnyCard extends Bonus{
	
	protected int cardType;
	protected int value;
	protected Player player;
	
	public IncrementForAnyCard(int cardType, int value) {
		this.cardType = cardType;
		this.value = value;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
}
