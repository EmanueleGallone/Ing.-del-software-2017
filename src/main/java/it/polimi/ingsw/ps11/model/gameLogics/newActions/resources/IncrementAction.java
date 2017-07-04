package it.polimi.ingsw.ps11.model.gameLogics.newActions.resources;

import it.polimi.ingsw.ps11.model.gameLogics.newActions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.newActions.ActionManager;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class IncrementAction implements Action{

	protected ActionManager aManager;
	protected ResourceList resources;
	
	protected ResourceList modifier;
	
	public IncrementAction(ActionManager aManager, ResourceList resources) {
		this.aManager = aManager;
		if(resources!= null){
			this.resources = resources.clone();
			modifier = resources.clone();
		}	
	}
	
	
	@Override
	public boolean isLegal() {
		return (resources != null && aManager != null);
	}

	@Override
	public void perform() {
		aManager.state().getPlayer().getResourceList().sum(modifier);
	}

	public ResourceList getModifier() {
		return modifier;
	}
	
	@Override
	public Action clone() {
		IncrementAction copy = new IncrementAction(aManager, resources.clone());
		if(modifier != null)
			copy.modifier = modifier.clone();
		return copy;
	}
}
