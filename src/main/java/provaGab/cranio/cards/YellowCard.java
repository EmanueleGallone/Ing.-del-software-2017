package provaGab.cranio.cards;

import provaGab.cranio.player.Player;

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
