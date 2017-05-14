package provaGab.cranio.cards;

import provaGab.cranio.player.Player;

public class BlueCard extends DevelopmentCard {
	//carte PERSONAGGI

	public BlueCard(){
		this.id = 3;
	}

	@Override
	protected void insertCard(Player player) {
		player.getCardManager().addBlueCard(this);
	}

}
