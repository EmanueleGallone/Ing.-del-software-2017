package it.polimi.ingsw.ps11.model.gameLogics.actions.affecter;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Affecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInTowerAction;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/**
 * <h3> FamilyInTowerAffecter </h3>
 * <p> Bonus: modifica permanentement il valore del costo di posizionamento di un familiare su una torre, se su questa è già
 * presente un'altro familiare attraverso una <code>FamilyInTowerAction</code>.</p>
 * @param  resourceList (nuovo costo del posizionamento di un familiare su una torre non vuota).</p>
 * @see Affecter
 * @see FamilyInTowerAction
 */
public class FamilyInTowerAffecter implements Affecter<FamilyInTowerAction>{

	private ResourceList resource;
	
	public FamilyInTowerAffecter(ResourceList resource) {
		this.resource = resource;
	}
	
	@Override
	public String target() {
		return FamilyInTowerAction.class.toString();
	}

	@Override
	public FamilyInTowerAction affect(FamilyInTowerAction action) {
		action.setTaxIfNotFree(resource);
		return action;
	}

}
