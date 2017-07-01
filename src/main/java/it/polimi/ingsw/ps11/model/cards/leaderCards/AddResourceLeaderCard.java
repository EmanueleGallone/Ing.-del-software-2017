package it.polimi.ingsw.ps11.model.cards.leaderCards;

import java.util.ArrayList;
import java.util.Map.Entry;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.gameLogics.actions.effects.AddResourceEffect;
import it.polimi.ingsw.ps11.model.player.Player;

public class AddResourceLeaderCard extends LeaderCard {
	
	private AddResourceEffect effect;

	public AddResourceLeaderCard(String name,AddResourceEffect effect) {
		super(name);
		this.effect = effect;
	}
	
	@Override
	public AddResourceLeaderCard clone() {
		AddResourceLeaderCard clone = new AddResourceLeaderCard(this.name,this.effect);
		
			clone.cardsNumber.putAll(this.cardsNumber);
			clone.requiredResources = this.requiredResources.clone();
			
		return clone;
	}
	
	public void setEffect(AddResourceEffect effect) {
		this.effect = effect;
	}
	public AddResourceEffect getEffect() {
		return effect;
	}

}
