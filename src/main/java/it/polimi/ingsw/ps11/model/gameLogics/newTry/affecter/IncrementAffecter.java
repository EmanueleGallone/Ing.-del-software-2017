package it.polimi.ingsw.ps11.model.gameLogics.newTry.affecter;

import it.polimi.ingsw.ps11.model.gameLogics.newTry.actions.IncrementAction;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class IncrementAffecter extends IncrementAction {

	private final boolean FORWARD = true;
	private boolean forward = FORWARD;
	private IncrementAction action;
	
	@Override
	public void perform() {
		System.out.println("Sono la affectIncrement");
		forward();
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
}
