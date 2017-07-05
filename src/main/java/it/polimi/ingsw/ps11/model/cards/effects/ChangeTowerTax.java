package it.polimi.ingsw.ps11.model.cards.effects;

import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.affecter.FamilyInTowerAffecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.EmptyAction;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class ChangeTowerTax implements Effect{

	private ResourceList resource;
	
	public ChangeTowerTax(ResourceList resource) {
		this.resource = resource;
	}
	
	@Override
	public EmptyAction get(ActionManager aManager) {
		return new EmptyAction();
	}

	@Override
	public void attach(ActionManager aManager) {
		FamilyInTowerAffecter affecter = new FamilyInTowerAffecter(resource);
		aManager.add(affecter);
	}

}
