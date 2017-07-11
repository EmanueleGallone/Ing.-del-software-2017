package it.polimi.ingsw.ps11.model.cards.effects;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.ChangeStateAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.resources.IncrementAction;
import it.polimi.ingsw.ps11.model.gameLogics.states.WaitResource;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/**
 * <h3> CouncilPrivilege </h3>
 * <p> Classe che rappresenta l'Effetto di una carta: attiva l'azione <code>IncrementAction</code>. Limitato a una scelta
 * tra: 1 wood e 1 stone, 2 servants, 2 coins, 2 militaryPoints, 1 faithPoint.</p>
 * @param  arrayList di resource (valori delle resourceLists che incrementano le risorse).
 * @see Effect
 * @see IncrementAction
 */
@SuppressWarnings("serial")
public class CouncilPrivilege implements Effect {
	
	private ArrayList<ResourceList> resources;
	
	public CouncilPrivilege() {
	
	}
	
	public CouncilPrivilege(ArrayList<ResourceList> resources) {
		this.resources = resources;
	}
	
	public void setResources(ArrayList<ResourceList> resources) {
		this.resources = resources;
	}
	
	@Override
	public ChangeStateAction get(ActionManager aManager) {
		IncrementAction action = new IncrementAction(aManager, null);
		return new ChangeStateAction(aManager, new WaitResource(resources,action));
	}
}
