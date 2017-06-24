package it.polimi.ingsw.ps11.model.bonus.ema.actionsEma;

import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class IncrementResourceAction extends Action {
	
	private Player player;
	private ResourceList resourceList;
	
	public IncrementResourceAction(Player player, ResourceList resourceList) {
		this.player = player;
		this.resourceList = resourceList;
	}

	@Override
	public void perform() {
		player.getResourceList().sum(resourceList);
	}

	@Override
	public boolean isLegal() {
		return true;
	}	

}
