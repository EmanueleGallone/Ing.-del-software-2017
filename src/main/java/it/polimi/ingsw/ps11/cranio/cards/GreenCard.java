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
	protected void insertCard(Player player) {
		player.getCardManager().addGreenCard(this);
	}

}
