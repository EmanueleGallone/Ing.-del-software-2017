package it.polimi.ingsw.ps11.model.gameLogics.actions.affecter;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Affecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInTowerAction;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class FamilyInTowerAffecter implements Affecter<FamilyInTowerAction>{

	private ResourceList resource;
	
	public FamilyInTowerAffecter(ResourceList resource) {
		this.resource = resource;
	}
	
	@Override
	public Class<FamilyInTowerAction> target() {
		return FamilyInTowerAction.class;
	}

	@Override
	public FamilyInTowerAction affect(FamilyInTowerAction action) {
		FamilyInTowerAction newAction = action.clone();
		newAction.setTaxIfNotFree(resource);
		return newAction;
	}

}
