package it.polimi.ingsw.ps11.cranio.cards;

import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.resources.*;

public class YellowCard extends DevelopmentCard {
	//carte EDIFICIO
	
	public YellowCard(){
		this.id = 2;
	}


	@Override
	protected void insertCard(Player player) {
		player.getCardManager().addYellowCard(this);
	}

}
