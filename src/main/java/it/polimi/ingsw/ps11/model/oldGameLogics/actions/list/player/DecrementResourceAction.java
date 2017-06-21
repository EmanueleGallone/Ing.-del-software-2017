package it.polimi.ingsw.ps11.model.oldGameLogics.actions.list.player;

import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class DecrementResourceAction extends PlayerAction<DecrementResourceAction> {

	private ResourceList resourceList;
	
	public DecrementResourceAction(Player player) {
		super(player);
	}
	
	public DecrementResourceAction(Player player,ResourceList resourceList) {
		super(player);
		this.resourceList = resourceList;
	}
	
	public DecrementResourceAction newIstance(ResourceList resourceList){
		DecrementResourceAction action = new DecrementResourceAction(getSource(),resourceList);
		action.setObservers(observers);
		return action;
	}

	@Override
	public void perform() {
		observers.performEvent(this);
		getSource().getResourceList().subtract(resourceList);
	}

	@Override
	public boolean isLegal() {
		boolean result = observers.validationEvent(this);
		return result && getSource().getResourceList().canSubtract(resourceList);
	}

}
