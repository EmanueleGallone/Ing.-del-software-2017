package it.polimi.ingsw.ps11.model.cards.effects;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.gameLogics.newActions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.newActions.base.ChangeStateAction;
import it.polimi.ingsw.ps11.model.gameLogics.newActions.resources.IncrementAction;
import it.polimi.ingsw.ps11.model.gameLogics.states.WaitResource;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

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

	@Override
	public void attach(ActionManager aManager) {

	}
}
