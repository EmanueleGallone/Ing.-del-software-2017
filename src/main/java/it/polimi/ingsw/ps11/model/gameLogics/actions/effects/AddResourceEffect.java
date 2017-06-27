package it.polimi.ingsw.ps11.model.gameLogics.actions.effects;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class AddResourceEffect implements Effect {

	private ResourceList resource;
	
	public AddResourceEffect(ResourceList resource) {
		this.resource = resource;
	}
	
	@Override
	public Action get(ActionManager aManager) {
		return aManager.newIncrementAction(resource);
	}

}
