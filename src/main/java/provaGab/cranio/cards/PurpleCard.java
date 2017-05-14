package provaGab.cranio.cards;

import provaGab.cranio.player.Player;

public class PurpleCard extends DevelopmentCard {
	//carte IMPRESE
	public PurpleCard(){
		this.id = 4;
	}

	@Override
	protected void insertCard(Player player) {
		player.getCardManager().addPurpleCard(this);
	}
	

}
