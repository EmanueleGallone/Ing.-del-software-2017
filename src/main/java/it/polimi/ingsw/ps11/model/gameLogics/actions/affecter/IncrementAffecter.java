package it.polimi.ingsw.ps11.model.gameLogics.actions.affecter;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Affecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.resources.IncrementAction;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/**
 * <h3> IncrementAffecter </h3>
 * <p> Bonus: modifica la resourceList ottenuta da un giocatore a seguito di un'azione qualunque attraverso una 
 * <code>IncrementAction</code>.</p>
 * @param  resourceList (valore delle risorse che modificano la resourceList).</p>
 * @see Affecter
 * @see 
 */
public class IncrementAffecter implements Affecter<IncrementAction> {

	private ResourceList resources;
	
	public IncrementAffecter(ResourceList resources) {
		if(resources!= null)
			this.resources = resources.clone();
	}
	
	@Override
	public String target() {
		return IncrementAction.class.toString();
	}

	@Override
	public IncrementAction affect(IncrementAction action) {
		ResourceList resourceList = action.getResources().clone();
		resourceList.subtract(resources);
		return new IncrementAction(action.getaManager(), resourceList);
	}

}
