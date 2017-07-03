package it.polimi.ingsw.ps11.model.cards.leaderCards;

import java.util.ArrayList;
import java.util.Map.Entry;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.cards.effects.ActiveYieldEffect;
import it.polimi.ingsw.ps11.model.cards.effects.Effect;
import it.polimi.ingsw.ps11.model.player.Player;

public class ActiveYieldLeaderCard extends LeaderCard {
	
	private ActiveYieldEffect effect;

	public ActiveYieldLeaderCard(String name, ActiveYieldEffect effect) {
		super(name);
		this.effect = effect;
	}


	@Override
	public ActiveYieldLeaderCard clone() {
		ActiveYieldLeaderCard clone = new ActiveYieldLeaderCard(this.name, this.effect);
		
		clone.requiredResources = this.requiredResources.clone();
		clone.cardsNumber.putAll(this.cardsNumber);
		
		return clone;
	}
	
	@Override
	public ActiveYieldEffect getEffect() {
		return this.effect;
	}

}
