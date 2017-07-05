package it.polimi.ingsw.ps11.model.cards.effects;

import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.affecter.EndGameAffecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.EmptyAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.resources.IncrementAction;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class ResourceAtTheEnd implements Effect {

	private ResourceList resource;
	
	public ResourceAtTheEnd(ResourceList resource) {
		this.resource = resource;
	}
	
	@Override
	public EmptyAction get(ActionManager aManager) {
		return new EmptyAction();
	}

	@Override
	public void attach(ActionManager aManager) {
		IncrementAction action = new IncrementAction(aManager, resource);
		EndGameAffecter affecter = new EndGameAffecter(action);
		aManager.add(affecter);
	}

}
