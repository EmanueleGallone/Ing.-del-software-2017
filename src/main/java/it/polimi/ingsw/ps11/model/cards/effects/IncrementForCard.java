package it.polimi.ingsw.ps11.model.cards.effects;

import it.polimi.ingsw.ps11.model.gameLogics.newActions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.newActions.base.DoSeveralTimeAction;
import it.polimi.ingsw.ps11.model.gameLogics.newActions.resources.IncrementAction;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class IncrementForCard implements Effect {

	private String cardType;
	private ResourceList resource;
	
	public IncrementForCard(String cardType, ResourceList resource) {
		this.cardType = cardType;
		this.resource = resource;
	}
	

	@Override
	public DoSeveralTimeAction get(ActionManager aManager) {
		IncrementAction action = new IncrementAction(aManager, resource);
		action = aManager.affect(action);
		int iterationNumber = aManager.state().getPlayer().getCardManager().getCardList(cardType).size();
		return new DoSeveralTimeAction(aManager, action, iterationNumber);
	}

	@Override
	public void attach(ActionManager aManager) {

	}

}
