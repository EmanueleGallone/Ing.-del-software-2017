package it.polimi.ingsw.ps11.cranio.cards.list;

import it.polimi.ingsw.ps11.cranio.cards.CardManager;
import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;

public class GreenCard extends DevelopmentCard {
	//carte Territori
	
	public GreenCard(){
		this.id = 1;
	}

	@Override
	protected void insertCard(CardManager cardManager) {
		cardManager.addGreenCard(this);
	}

	@Override
	public void activePermanentEffect() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void activeIstantEffect() {
		// TODO Auto-generated method stub
		
	}

}
