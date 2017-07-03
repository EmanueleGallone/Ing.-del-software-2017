package it.polimi.ingsw.ps11.model.cards.leaderCards;

import it.polimi.ingsw.ps11.model.cards.effects.CardDiscount;

public class DiscountLeaderCard extends LeaderCard {
	
	private CardDiscount effect;
	
	public DiscountLeaderCard(String name, CardDiscount cardDiscount) {
		super(name);
		this.effect = cardDiscount;
	}

	@Override
	public DiscountLeaderCard clone() {
		DiscountLeaderCard clone = new DiscountLeaderCard(this.name, this.effect);
		
		clone.cardsNumber.putAll(this.cardsNumber);
		clone.requiredResources = this.requiredResources.clone();
		
		return clone;
	}
	
	@Override
	public CardDiscount getEffect() {
		return this.effect;
	}

}
