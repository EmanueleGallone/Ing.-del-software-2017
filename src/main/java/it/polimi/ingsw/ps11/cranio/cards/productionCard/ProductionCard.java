package it.polimi.ingsw.ps11.cranio.cards.productionCard;

import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;

public class ProductionCard extends DevelopmentCard {

	private final int DEFAULT_VALUE = 1;
	private int activeValue;
	
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
