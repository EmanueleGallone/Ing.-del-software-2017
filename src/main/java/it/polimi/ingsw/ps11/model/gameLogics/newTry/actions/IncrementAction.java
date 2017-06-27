package it.polimi.ingsw.ps11.model.gameLogics.newTry.actions;

import it.polimi.ingsw.ps11.model.gameLogics.newTry.Action;
import it.polimi.ingsw.ps11.model.gameLogics.newTry.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.newTry.Affecter;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class IncrementAction implements Action, Affecter<IncrementAction> {

	private ActionManager aManager;
	private ResourceList resource;
	
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
	
	
	
// _________________________ Method for decorator system ________________________
	

	@Override
	public IncrementAction decore(IncrementAction action) {
		if(action != this){
			return action.decore(this);
		}
		return this;
	}

	@Override
	public void perform(boolean execute) {
		if(execute){
			perform();
		}
	}
	
	@Override
	public void attach(ActionManager actionManager){
		IncrementAction increment = actionManager.get(IncrementAction.class);
		if(increment == null){
			increment = this;
		}
		actionManager.add(increment.decore(this));
	}

	@Override
	public Class<IncrementAction> target() {
		return IncrementAction.class;
	}
}
