package it.polimi.ingsw.ps11.cranio.game.actionsEma;

import it.polimi.ingsw.ps11.cranio.cards.list.YellowCard;
import it.polimi.ingsw.ps11.cranio.player.Player;

public class EnableProductionAction extends Action {
	
	private int productionValue;
	private Player player;
	
	public EnableProductionAction(Player player, int productionValue) {
		this.player = player;
		this.productionValue = productionValue;
	}

	@Override
	public void perform() {
		
		for(YellowCard card : player.getCardManager().getCardList(YellowCard.class)){
			if(card.getActiveValue() <= productionValue)
				card.enablePermanentBonus();
		}
	}

	@Override
	public boolean isLegal() {
		return true;
	}

}
