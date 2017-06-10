package it.polimi.ingsw.ps11.cranio.game.actionsEma;

import it.polimi.ingsw.ps11.cranio.cards.list.GreenCard;
import it.polimi.ingsw.ps11.cranio.player.Player;

public class EnableHarvestAction extends Action {
	
	private int productionValue;
	private Player player;
	
	public EnableHarvestAction(Player player, int productionValue) {
		this.player = player;
		this.productionValue = productionValue;
	}

	@Override
	public void perform() {
		
		for(GreenCard card : player.getCardManager().getCardList(GreenCard.class)){
			if(card.getActiveValue() <= productionValue)
				card.enablePermanentBonus();
		}
	}

	@Override
	public boolean isLegal() {
		return true;
	}

}
