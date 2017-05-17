package it.polimi.ingsw.ps11.cranio.cards.list;

import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;

public class YellowCard extends DevelopmentCard {
	//carte EDIFICIO
	
	private final int DEFAULT_VALUE = 1;
	private int activeValue;
	
	public YellowCard(){
		activeValue = DEFAULT_VALUE;
	}

	public YellowCard(int value){
		activeValue = value;
	}
	
	@Override
	public void enablePermanentBonus() {
		// TODO Auto-generated method stub
		
	}
}
