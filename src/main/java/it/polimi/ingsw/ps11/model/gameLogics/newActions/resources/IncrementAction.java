package it.polimi.ingsw.ps11.model.gameLogics.newActions.resources;

import it.polimi.ingsw.ps11.model.gameLogics.newActions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.newActions.ActionManager;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class IncrementAction implements Action{

	protected ActionManager aManager;
	protected ResourceList resources;
	
	public IncrementAction(ActionManager aManager, ResourceList resources) {
		this.aManager = aManager;
		if(resources!= null)
			this.resources = resources.clone();
	}
	
	
	@Override
	public boolean isLegal() {
		return (resources != null && aManager != null);
	}

	@Override
	public void perform() {
		aManager.state().getPlayer().getResourceList().sum(getResources());
	}

	public ResourceList getResources() {
		return resources;
	}
	
	public ActionManager getaManager() {
		return aManager;
	}
	
	@Override
	public IncrementAction clone() {
		ResourceList resourceList = resources;
		if(resources != null)
			resourceList = resources.clone();
		return new IncrementAction(aManager, resourceList);
	}
}
