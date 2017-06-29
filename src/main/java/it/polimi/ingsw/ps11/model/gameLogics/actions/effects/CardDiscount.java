package it.polimi.ingsw.ps11.model.gameLogics.actions.effects;

import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.affecter.CardCostAffecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.GetCardAction;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class CardDiscount implements Effect {

	private ResourceList discount;
	
	public CardDiscount(ResourceList discount) {
		this.discount = discount;
	}
	
	@Override
	public GetCardAction get(ActionManager aManager) {
		return new CardCostAffecter(discount);	
	}

}
