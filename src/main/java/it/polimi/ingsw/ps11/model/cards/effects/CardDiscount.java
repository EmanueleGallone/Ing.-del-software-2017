package it.polimi.ingsw.ps11.model.cards.effects;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.affecter.CardCostAffecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.EmptyAction;
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
	public EmptyAction get(ActionManager aManager) {
		return new EmptyAction();
	}

	@Override
	public void attach(ActionManager aManager) {
		CardCostAffecter affecter = new CardCostAffecter(cardType, discount);
		aManager.add(affecter);
	}

}
