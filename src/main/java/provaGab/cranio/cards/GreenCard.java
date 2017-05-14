package provaGab.cranio.cards;

import provaGab.cranio.player.Player;

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
