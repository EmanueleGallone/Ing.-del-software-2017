package it.polimi.ingsw.ps11.model.cards.effects;

import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.affecter.FamilyInTowerAffecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.EmptyAction;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/**
 * <h3> ChangeTowerTax </h3>
 * <p> Classe che rappresenta l'effetto di una carta: modifica permanentemente il costo di posizionamento di un familiare su una torre se su questa c'è
 * già un altro familiare attraverso un <code>FamilyInTowerAffecter</code>.</p>
 * @param  resourceList (valore delle risorse che modificano il costo di posizionamento su una torre).</p>
 * @see Effect
 * @see FamilyInTowerAffecter
 */
public class ChangeTowerTax implements Effect{

	private ResourceList resource;
	
	public ChangeTowerTax(ResourceList resource) {
		this.resource = resource;
	}
	
	@Override
	public EmptyAction get(ActionManager aManager) {
		FamilyInTowerAffecter affecter = new FamilyInTowerAffecter(resource);
		aManager.add(affecter);
		return new EmptyAction();
	}

}
