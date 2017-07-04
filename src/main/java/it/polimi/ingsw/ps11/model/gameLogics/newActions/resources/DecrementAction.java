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
		return super.isLegal() &&  player.getResourceList().canSubtract(getModifier());
	}
	
	@Override
	public void perform() {
		aManager.state().getPlayer().getResourceList().subtract(getModifier());
	}
	
	@Override
	public DecrementAction clone() {
		DecrementAction copy = new DecrementAction(aManager, resources.clone());
		if(modifier != null)
			copy.modifier = modifier.clone();
		return copy;
	}
}
