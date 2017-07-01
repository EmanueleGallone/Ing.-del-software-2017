package it.polimi.ingsw.ps11.model.gameLogics.actions.base;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.modelEvents.PlayerUpdateEvent;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class DecrementAction implements Action<DecrementAction> {

	private ActionManager aManager;
	private ResourceList resource;
	
	public DecrementAction(ActionManager actionManager, ResourceList resource) {
		this.aManager = actionManager;
		this.resource = resource;
	}
	
	public ResourceList getResource() {
		return resource;
	}
	
	@Override
	public void perform() {
		aManager.getSubject().getResourceList().subtract(getResource());
		aManager.stateHandler().invoke(new PlayerUpdateEvent(aManager.stateHandler().getPlayer()));
	}
	
	@Override
	public boolean isLegal() {
		return aManager.getSubject().getResourceList().canSubtract(getResource());
	}
	
	// _________________________ Method for action system ________________________


	@Override
	public DecrementAction decore(DecrementAction action) {
		if(action != this){
			return action.decore(this);
		}
		return this;
	}

	@Override
	public void attach(ActionManager aManager) {
		DecrementAction increment = aManager.get(target());
		if(increment == null){
			increment = this;
		}
		aManager.add(increment.decore(this));
	}
	
	@Override
	public Class<DecrementAction> target() {
		return DecrementAction.class;
	}

// ________________________________________________
	
	@Override
	public DecrementAction clone() {
		DecrementAction copy = new DecrementAction(aManager, resource.clone());
		return copy;
	}
}
