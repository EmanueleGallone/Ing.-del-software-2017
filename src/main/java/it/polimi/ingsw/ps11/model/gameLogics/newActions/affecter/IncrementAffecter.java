package it.polimi.ingsw.ps11.model.gameLogics.newActions.affecter;

import it.polimi.ingsw.ps11.model.gameLogics.newActions.Affecter;
import it.polimi.ingsw.ps11.model.gameLogics.newActions.resources.IncrementAction;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class IncrementAffecter implements Affecter<IncrementAction> {

	/*
	 * Rappresenta quel bonus che ogni volta che prendi +x risorse te ne sottrae un tot
	 */
	
	private ResourceList resources;
	
	public IncrementAffecter(ResourceList resources) {
		if(resources!= null)
			this.resources = resources.clone();
	}
	
	@Override
	public Class<IncrementAction> target() {
		return IncrementAction.class;
	}

	@Override
	public IncrementAction affect(IncrementAction action) {
		ResourceList resourceList = action.getResources().clone();
		resourceList.subtract(resources);
		return new IncrementAction(action.getaManager(), resourceList);
	}

}
