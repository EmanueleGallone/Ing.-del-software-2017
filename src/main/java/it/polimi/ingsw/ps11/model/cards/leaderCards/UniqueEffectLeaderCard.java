package it.polimi.ingsw.ps11.model.cards.leaderCards;

import it.polimi.ingsw.ps11.model.cards.Card;
import it.polimi.ingsw.ps11.model.gameLogics.actions.effects.Effect;

public class UniqueEffectLeaderCard extends LeaderCard {
	
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

}
