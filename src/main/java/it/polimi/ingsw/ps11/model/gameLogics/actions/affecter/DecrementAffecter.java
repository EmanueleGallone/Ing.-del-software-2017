package it.polimi.ingsw.ps11.model.gameLogics.actions.affecter;

import javax.imageio.ImageTypeSpecifier;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Affecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.resources.DecrementAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.resources.IncrementAction;
import it.polimi.ingsw.ps11.model.resources.Resource;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/**
 * <h3> DecrementAffecter </h3>
 * <p> Malus: aumenta permanentemente ogni il costo di ogni cosa (carte, azioni, ecc) attraverso una <code>DecrementAction</codde>.</p>
 * <p> Richiede: resourceList (valori delle risorse ch vanno applicate ad ogni costo).</p>
 * @see Affecter
 * @see DecrementAction
 */
public class DecrementAffecter implements Affecter<DecrementAction>{

	/*
	 * Rappresenta quel malus che ti aumenta i costi delle cose, ad esempio invece di pagare 1 servitore ne spendi 2
	 */
	
	private String condiction;
	private int increment;
	
	public DecrementAffecter(String condiction, int increment) {
		this.condiction = condiction;
		this.increment = increment;
	}

	@Override
	public Class<DecrementAction> target() {
		return DecrementAction.class;
	}

	@Override
	public DecrementAction affect(DecrementAction action) {
		Resource resource = action.getResources().get(condiction);
		if(resource != null){
			resource.setValue(resource.getValue() * increment);
			ResourceList resourceList = action.getResources().clone();
			resourceList.setResource(resource);
			return new DecrementAction(action.getaManager(), resourceList);
		}
		return action;
	}
	
}
