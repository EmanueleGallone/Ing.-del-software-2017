package it.polimi.ingsw.ps11.model.gameLogics.newActions.affecter;

import it.polimi.ingsw.ps11.model.gameLogics.newActions.Affecter;
import it.polimi.ingsw.ps11.model.gameLogics.newActions.resources.DecrementAction;
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
		action.getModifier().sum(resources);
		return action;
	}
	
}
