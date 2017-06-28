package it.polimi.ingsw.ps11.model.gameLogics.actions.base;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEvent;

public class IncrementAction implements Action<IncrementAction>{

	protected ActionManager aManager;
	protected ResourceList resource;
	
	public IncrementAction(){
		
	}
	
	public IncrementAction(ActionManager actionManager, ResourceList resource) {
		this.aManager = actionManager;
		this.resource = resource;
	}
	
	public ResourceList getResource() {
		return resource;
	}
	
	public void setResource(ResourceList resource) {
		this.resource = resource;
	}	

	@Override
	public boolean isLegal() {
		return true;
	}

	@Override
	public void perform() {
		aManager.getSubject().getResourceList().sum(resource);
	}
	
// _________________________ Method for action system ________________________
	

	@Override
	public IncrementAction decore(IncrementAction action) {
		if(action != this){
			return action.decore(this);
		}
		return this;
	}
	
	@Override
	public void attach(ActionManager aManager){
		IncrementAction increment = aManager.get(target());
		if(increment == null){
			increment = this;
		}
		aManager.add(increment.decore(this));
	}

	@Override
	public Class<IncrementAction> target() {
		return IncrementAction.class;
	}
	
// ___________________________________________________
	
	@Override
	public IncrementAction clone(){
		IncrementAction copy = new IncrementAction(aManager, resource.clone());
		return copy;
	}
}
