package it.polimi.ingsw.ps11.cranio.cards.list;

import it.polimi.ingsw.ps11.cranio.cards.CardManager;
import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;

public class GreenCard extends DevelopmentCard {
	//carte Territori
	
	private final int DEFAULT_VALUE = 1;
	private int activeValue;
	
	public GreenCard(){
		activeValue = DEFAULT_VALUE;
	}

	public GreenCard(int value){
		activeValue = value;
	}

	@Override
	public void enablePermanentBonus() {
		// TODO Auto-generated method stub
		
	}
}
