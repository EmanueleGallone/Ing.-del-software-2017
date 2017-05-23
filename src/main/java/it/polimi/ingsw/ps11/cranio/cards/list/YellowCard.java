package it.polimi.ingsw.ps11.cranio.cards.list;

import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;

public class YellowCard extends DevelopmentCard {
	//carte EDIFICIO

	protected final int DEFAULT_VALUE = 1;
	protected int activeValue; //valore necessario affinchè la carta attivi il bonus
	
	public YellowCard() {
		super();
		this.activeValue = DEFAULT_VALUE;
	}
	
	public int getActiveValue() {
		return activeValue;
	}
	public void setActiveValue(int activeValue) {
		this.activeValue = activeValue;
	}
}
