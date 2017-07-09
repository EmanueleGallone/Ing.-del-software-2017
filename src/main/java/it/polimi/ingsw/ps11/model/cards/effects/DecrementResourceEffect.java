package it.polimi.ingsw.ps11.model.cards.effects;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.affecter.EndGameAffecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.affecter.IncrementAffecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.EmptyAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.resources.IncrementAction;

import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class DecrementResourceEffect implements Effect{

	private ResourceList resource = new ResourceList();
	
	public DecrementResourceEffect(ResourceList resource) {
		this.resource = resource;
	}
	
	@Override
	public EmptyAction get(ActionManager aManager) {
		IncrementAffecter affecter = new IncrementAffecter(resource);
		aManager.add(affecter);
		return new EmptyAction();
	}
}
