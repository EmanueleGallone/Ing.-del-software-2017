package it.polimi.ingsw.ps11.model.gameLogics.actions.old.list;

import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class IncrementResourceAction extends PlayerAction {

	private ResourceList resourceList;

	public IncrementResourceAction(Player player,ResourceList resourceList) {
		super(player);
		this.resourceList = resourceList;
	}
	
	public ResourceList getResources() {
		return resourceList;
	}
	
	@Override
	public void perform() {
		getPlayer().getResourceList().sum(resourceList);
	}

	@Override
	public boolean isLegal() {
		return true;
	}

}
