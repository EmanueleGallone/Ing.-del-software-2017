package it.polimi.ingsw.ps11.model.gameLogics.actions.effects;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.affecter.CardCostAffecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.GetCardAction;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class CardDiscount implements Effect {

	private String cardType;
	private ResourceList discount;
	
	public CardDiscount(Class<? extends DevelopmentCard> cardType,ResourceList discount){
		this(cardType.toString(),discount);
	}
	public CardDiscount(String cardType,ResourceList discount) {
		this.discount = discount;
		this.cardType = cardType;
	}
	
	@Override
	public GetCardAction get(ActionManager aManager) {
		return new CardCostAffecter(cardType,discount);	
	}

}
