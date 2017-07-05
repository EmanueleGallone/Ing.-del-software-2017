package it.polimi.ingsw.ps11.model.gameLogics.newActions.affecter;

import it.polimi.ingsw.ps11.model.gameLogics.newActions.Affecter;
import it.polimi.ingsw.ps11.model.gameLogics.newActions.resources.IncrementAction;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/** <h3> Nome </h3>
 * <p> Classe che rappresenta il bonus che ha il compito di modificare le Risorse ottenute da un giocatore in seguito 
 * ad una qualunque azione</p>
 * @see IncrementAction
 */
public class IncrementAffecter implements Affecter<IncrementAction> {

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
