package it.polimi.ingsw.ps11.cranio.cards;

import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.resources.*;

public class BlueCard extends DevelopmentCard {
	//carte PERSONAGGI

	public BlueCard(){
		this.id = 3;
	}

	@Override
	protected void insertCard(Player player) {
		player.getCardManager().addBlueCard(this);
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
