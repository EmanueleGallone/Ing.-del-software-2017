package it.polimi.ingsw.ps11.model.gameLogics.actions.list.player;

import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class IncrementResourceAction extends PlayerAction<IncrementResourceAction> {

	private ResourceList resourceList;
	
	public IncrementResourceAction(Player player) {
		super(player);
	}

	public IncrementResourceAction(Player player,ResourceList resourceList) {
		super(player);
		this.resourceList = resourceList;
	}
	
	public IncrementResourceAction newIstance(ResourceList resourceList){
		IncrementResourceAction action = new IncrementResourceAction(getSource(),resourceList);
		action.setObservers(observers);
		return action;
	}
	
	@Override
	public void perform() {
		getSource().getResourceList().sum(resourceList);
		observers.performEvent(this);
	}

	@Override
	public boolean isLegal() {
		return observers.validationEvent(this);
	}

}
