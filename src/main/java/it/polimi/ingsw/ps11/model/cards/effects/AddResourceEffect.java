package it.polimi.ingsw.ps11.model.cards.effects;

import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.resources.IncrementAction;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/**
 * <h3> AddResourceEffect </h3>
 * <p> Classe che rappresenta l'effetto di una carta: attiva l'azione <code>IncrementAction</code>.</p>
 * @param  resource (il tipo di risorsa da incrementare).
 * @see Effect
 * @see IncrementAction
 */
@SuppressWarnings("serial")
public class AddResourceEffect implements Effect {

	private ResourceList resource;
	
	public AddResourceEffect(ResourceList resource) {
		this.resource = resource;
	}
	
	@Override
	public IncrementAction get(ActionManager aManager) {
		IncrementAction action = new IncrementAction(aManager, resource);
		return aManager.affect(action);
	}

}
