package it.polimi.ingsw.ps11.model.cards.effects;

import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.affecter.EndGameAffecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.EmptyAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.resources.IncrementAction;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/**
 * <h3> ResourceAtTheEnd </h3>
 * <p> Classe che rappresenta l'effetto di una carta: modifica permanentemente il valore delle risorse ottenute da <code>IncrementAction</code> a 
 * fine partita.</p>
 * @param  resourceList (Valori delle risorse ottenute a fine partita).</p>
 * @see Effect
 * @see IncrementAction
 * @see EndGameAffecter
 */
public class ResourceAtTheEnd implements Effect {

	private ResourceList resource;
	
	public ResourceAtTheEnd(ResourceList resource) {
		this.resource = resource;
	}
	
	@Override
	public EmptyAction get(ActionManager aManager) {
		IncrementAction action = new IncrementAction(aManager, resource);
		EndGameAffecter affecter = new EndGameAffecter(action);
		aManager.add(affecter);
		return new EmptyAction();
	}
}
