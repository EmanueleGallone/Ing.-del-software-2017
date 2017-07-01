package it.polimi.ingsw.ps11.model.cards.leaderCards;

import it.polimi.ingsw.ps11.model.gameLogics.actions.effects.Effect;

public class AddResourceLeaderCard extends LeaderCard {
	
	private Effect effect;

	public AddResourceLeaderCard(String name) {
		super(name);
	}

	
	@Override
	public AddResourceLeaderCard clone() {
		return null;
	}
	
	public void setEffect(Effect effect) {
		this.effect = effect;
	}
	public Effect getEffect() {
		return effect;
	}

}
