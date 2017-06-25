package it.polimi.ingsw.ps11.model.gameLogics.actions.old.list;

import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class DecrementResourceAction extends IncrementResourceAction {

	public DecrementResourceAction(Player player, ResourceList resourceList) {
		super(player, resourceList);
	}

	@Override
	public void perform() {
		getPlayer().getResourceList().subtract(getResources());
	}

	@Override
	public boolean isLegal() {
		return getPlayer().getResourceList().canSubtract(getResources());
	}

}
