package it.polimi.ingsw.ps11.model.cards.leaderCards.old;

import it.polimi.ingsw.ps11.model.cards.effects.Effect;

public class UniqueEffectLeaderCard extends oldLeaderCard {
	
	private Effect effect;

	public UniqueEffectLeaderCard(String name, Effect effect) {
		super(name);
		this.effect = effect;
	}

	@Override
	public UniqueEffectLeaderCard clone() {
		UniqueEffectLeaderCard clone = new UniqueEffectLeaderCard(this.name, this.effect);
		
		clone.cardsNumber.putAll(this.cardsNumber);
		clone.requiredResources = this.requiredResources.clone();
		
		return clone;
	}
	
	@Override
	public Effect getEffect() {
		return this.effect;
	}

}
