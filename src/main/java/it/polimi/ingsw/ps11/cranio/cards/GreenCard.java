package it.polimi.ingsw.ps11.cranio.cards;

import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.resources.Coin;
import it.polimi.ingsw.resources.Wood;

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
