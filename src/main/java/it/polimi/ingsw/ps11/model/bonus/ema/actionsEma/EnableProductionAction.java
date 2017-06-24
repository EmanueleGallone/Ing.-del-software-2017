package it.polimi.ingsw.ps11.model.bonus.ema.actionsEma;

import it.polimi.ingsw.ps11.model.cards.list.YellowCard;
import it.polimi.ingsw.ps11.model.player.Player;

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
//			if(card.getActiveValue() <= productionValue)
//				card.enablePermanentBonus();
		}
	}

	@Override
	public boolean isLegal() {
		return true;
	}

}
