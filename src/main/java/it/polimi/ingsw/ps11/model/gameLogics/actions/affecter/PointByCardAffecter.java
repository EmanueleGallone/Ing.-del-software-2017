package it.polimi.ingsw.ps11.model.gameLogics.actions.affecter;

import java.util.HashMap;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Affecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.endGame.PointByCardAction;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class PointByCardAffecter implements Affecter<PointByCardAction> {

	private String card;
	private  HashMap<Integer, ResourceList> rewards;
	
	public PointByCardAffecter(String card, HashMap<Integer, ResourceList> rewards) {
		this.rewards = rewards;
		this.card = card;
	}
	
	@Override
	public String target() {
		return PointByCardAction.class.toString();
	}

	@Override
	public PointByCardAction affect(PointByCardAction action) {
		if(action.getCard().equals(card))
			action.setRewards(rewards);
		return action;
	}

}
