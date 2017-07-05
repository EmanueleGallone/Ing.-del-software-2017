package it.polimi.ingsw.ps11.model.cards.leaderCards.old;

import it.polimi.ingsw.ps11.model.cards.effects.AddResourceEffect;

public class AddResourceLeaderCard extends oldLeaderCard {
	
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
