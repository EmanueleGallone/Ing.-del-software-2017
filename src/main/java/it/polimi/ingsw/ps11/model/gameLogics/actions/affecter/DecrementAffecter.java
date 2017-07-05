package it.polimi.ingsw.ps11.model.gameLogics.actions.affecter;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Affecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.resources.DecrementAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.resources.IncrementAction;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class DecrementAffecter implements Affecter<DecrementAction>{

	/*
	 * Rappresenta quel malus che ti aumenta i costi delle cose, ad esempio invece di pagare 1 servitore ne spendi 2
	 */
	
	private ResourceList resources;
	
	public DecrementAffecter(ResourceList resources) {
		if(resources!= null)
			this.resources = resources.clone();
	}

	@Override
	public Class<DecrementAction> target() {
		return DecrementAction.class;
	}

	@Override
	public DecrementAction affect(DecrementAction action) {
		ResourceList resourceList = action.getResources().clone();
		resourceList.sum(resources);
		return new DecrementAction(action.getaManager(), resourceList);
	}
	
}
