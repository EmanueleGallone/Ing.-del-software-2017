package it.polimi.ingsw.ps11.cranio.cards.productionCard;

import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;

public class ProductionCard extends DevelopmentCard {

	protected final int DEFAULT_VALUE = 1;
	protected int activeValue; //valore necessario affinchè la carta attivi il bonus
	
	protected int period = 0;
	
	public ProductionCard(){
		activeValue = DEFAULT_VALUE;
	}

	public ProductionCard(int value){
		activeValue = value;
	}
	
	public int getActiveValue() {
		return activeValue;
	}
}
