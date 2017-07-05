package it.polimi.ingsw.ps11.model.gameLogics.newActions.resources;

import it.polimi.ingsw.ps11.model.gameLogics.newActions.ActionManager;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class DecrementAction extends IncrementAction{

	public DecrementAction(ActionManager aManager, ResourceList resources) {
		super(aManager, resources);
	}
	
	@Override
	public boolean isLegal() {
		Player player = aManager.state().getPlayer();
		boolean result = super.isLegal() &&  player.getResourceList().canSubtract(getResources());
		
		if(!result)
			aManager.state().invoke("Le risorse che hai non sono abbastanza");
		
		return result;
	}
	
	@Override
	public void perform() {
		aManager.state().getPlayer().getResourceList().subtract(getResources());
	}
	
	@Override
	public DecrementAction clone() {
		ResourceList resourceList = resources;
		if(resources != null)
			resourceList = resources.clone();
		return new DecrementAction(aManager, resourceList);
	}
}
