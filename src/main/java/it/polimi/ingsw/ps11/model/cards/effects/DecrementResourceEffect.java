package it.polimi.ingsw.ps11.model.cards.effects;

import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.affecter.IncrementAffecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.EmptyAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.resources.IncrementAction;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/**
 * <h3> Decrement ResourceEffect </h3>
 * <p> Classe che rappresenta l'Effetto di una carta: modifica permanentemente le risorse guadagnate con ogni mossa attraverso una <code>IncrementAffecter</code>.</p>
 * <p> Richiede: arrayList di resource (valori delle resourceLists che incrementano le risorse).</p>
 * @see Effect
 * @see IncrementAffecter
 */
public class DecrementResourceEffect implements Effect{

	private ResourceList resource = new ResourceList();
	
	public DecrementResourceEffect(ResourceList resource) {
		this.resource = resource;
	}
	
	@Override
	public EmptyAction get(ActionManager aManager) {
		IncrementAffecter affecter = new IncrementAffecter(resource);
		aManager.add(affecter);
		return new EmptyAction();
	}
}
