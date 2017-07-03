package it.polimi.ingsw.ps11.model.cards.effects;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.ChangeStateAction;
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
		return new ChangeStateAction(aManager, new WaitResource(resources,aManager.newIncrementAction(null)));
	}
}
