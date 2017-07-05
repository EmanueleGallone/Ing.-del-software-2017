package it.polimi.ingsw.ps11.model.gameLogics.actions.resources;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ResourceListener;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/** <h3> IncrementAction </h3>
 * <p> Classe che rappresenta l'azione di incremento di risorse in una ResourceList</p>
 * @see Action
 */
public class IncrementAction implements Action, ResourceListener{

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
	public void update(ResourceList resource) {
		IncrementAction action = new IncrementAction(aManager, resource);
		action = aManager.affect(action);
		if(action.isLegal())
			action.perform();
	}
	
	@Override
	public IncrementAction clone() {
		ResourceList resourceList = resources;
		if(resources != null)
			resourceList = resources.clone();
		return new IncrementAction(aManager, resourceList);
	}
}
