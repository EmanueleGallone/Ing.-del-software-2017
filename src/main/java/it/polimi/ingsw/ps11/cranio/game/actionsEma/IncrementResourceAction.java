package it.polimi.ingsw.ps11.cranio.game.actionsEma;

import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;

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
