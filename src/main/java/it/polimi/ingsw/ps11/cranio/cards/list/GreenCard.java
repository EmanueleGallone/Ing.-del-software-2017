package it.polimi.ingsw.ps11.cranio.cards.list;

import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;

public class GreenCard extends DevelopmentCard {
	//carte Territori
	
	protected final int DEFAULT_VALUE = 1;
	protected int activeValue; //valore necessario affinchè la carta attivi il bonus
	
	public GreenCard() {
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
