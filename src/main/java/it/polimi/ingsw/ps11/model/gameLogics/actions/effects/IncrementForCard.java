package it.polimi.ingsw.ps11.model.gameLogics.actions.effects;

import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.DoSeveralTimesAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.IncrementAction;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class IncrementForCard implements Effect {

	private String cardType;
	private ResourceList resource;
	
	public IncrementForCard(String cardType, ResourceList resource) {
		this.cardType = cardType;
		this.resource = resource;
	}
	
	@Override
	public DoSeveralTimesAction get(ActionManager aManager) {
		IncrementAction action = aManager.newIncrementAction(resource);
		int iterationNumber = aManager.getSubject().getCardManager().getCardList(cardType).size();
		return new DoSeveralTimesAction(aManager, action, iterationNumber);
	}

}
