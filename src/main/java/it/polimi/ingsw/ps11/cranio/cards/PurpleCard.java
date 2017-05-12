package it.polimi.ingsw.ps11.cranio.cards;

import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.resources.Coin;
import it.polimi.ingsw.resources.Wood;

public class PurpleCard extends DevelopmentCard {
	//carte IMPRESE
	public PurpleCard(){
		this.id = 4;
	}

	@Override
	protected void insertCard(Player player) {
		player.getCardManager().addPurpleCard(this);
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
