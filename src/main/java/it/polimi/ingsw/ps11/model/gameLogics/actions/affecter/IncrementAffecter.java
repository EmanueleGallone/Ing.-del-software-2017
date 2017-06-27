package it.polimi.ingsw.ps11.model.gameLogics.actions.affecter;

import it.polimi.ingsw.ps11.model.gameLogics.actions.base.IncrementAction;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class IncrementAffecter extends IncrementAction {

	private final boolean FORWARD = true;
	private boolean forward = FORWARD;
	
	private IncrementAction action;
	
	public IncrementAffecter(ResourceList resource) {
		this.resource = resource;
	}

	@Override
	public void setResource(ResourceList resource) {
		action.setResource(resource);
	}
	
	@Override
	public ResourceList getResource() {
		return action.getResource();
	}
	
	@Override
	public boolean isLegal() {
		return action.isLegal();
	}
	
	@Override
	public void perform() {
		ResourceList resourceList = action.getResource();
		resourceList.subtract(resource);
		action.setResource(resourceList);
		forward();
	}
	
// Method for decorator system ____________	
	
	@Override
	public IncrementAction decore(IncrementAction action) {
		if(this.action == null && action != this){
			this.action = action;
			return this;
		}
		else if(this.action != null){
			return this.action.decore(action);	
		}
		return this;
	}

	public void forward(){
		if (action!= null)
			action.perform(forward && FORWARD);
		this.forward = FORWARD;
	}
	
	@Override
	public void perform(boolean forward) {
		this.forward = forward;
		perform();
	}
	
// __________________________
	
	@Override
	public IncrementAffecter clone(){
		IncrementAffecter copy = new IncrementAffecter(resource.clone());
		copy.aManager = aManager;
		if(action != null)
			copy.action = action.clone();
		return copy;
	}
}
