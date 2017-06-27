package it.polimi.ingsw.ps11.model.gameLogics.newTry.actions;

import it.polimi.ingsw.ps11.model.gameLogics.newTry.Action;
import it.polimi.ingsw.ps11.model.gameLogics.newTry.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.newTry.Affecter;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class DecrementAction implements Action, Affecter<DecrementAction> {

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
	}
	
	@Override
	public boolean isLegal() {
		return aManager.getSubject().getResourceList().canSubtract(getResource());
	}
	
//  _______________ Method for decorator system _____________________


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
