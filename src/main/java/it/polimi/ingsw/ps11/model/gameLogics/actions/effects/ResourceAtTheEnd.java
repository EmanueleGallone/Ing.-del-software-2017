package it.polimi.ingsw.ps11.model.gameLogics.actions.effects;

import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.affecter.EndGameAffecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.EndGameAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.IncrementAction;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class ResourceAtTheEnd implements Effect {

	private ResourceList resource;
	
	public ResourceAtTheEnd(ResourceList resource) {
		this.resource = resource;
	}
	
	@Override
	public EndGameAction get(ActionManager aManager) {
		IncrementAction action = aManager.newIncrementAction(resource);
		EndGameAffecter endAction = new EndGameAffecter(action);
		return endAction;
	}

}
