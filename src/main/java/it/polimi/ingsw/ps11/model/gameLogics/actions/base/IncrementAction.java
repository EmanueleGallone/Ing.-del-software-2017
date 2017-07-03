package it.polimi.ingsw.ps11.model.gameLogics.actions.base;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ResourceListener;
import it.polimi.ingsw.ps11.model.modelEvents.GameUpdateEvent;
import it.polimi.ingsw.ps11.model.modelEvents.PlayerUpdateEvent;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/** <h3> IncrementAction </h3>
 * <p> Classe che rappresenta l'azione di incremento di risorse in una ResourceList</p>
 * @see Action
 */
public class IncrementAction implements Action<IncrementAction>, ResourceListener{

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
		return (resource != null);
	}

	@Override
	public void perform() {
		aManager.getSubject().getResourceList().sum(resource);
		//aManager.stateHandler().invoke(new PlayerUpdateEvent(aManager.stateHandler().getPlayer()));
	}
	
	@Override
	public void update(ResourceList resource) {
		this.resource = resource;
		if(isLegal())
			perform();
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
//		IncrementAction action = aManager.get(target());
//		if(action == null){
//			action = this;
//		}
//		aManager.add(action.decore(this));
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
