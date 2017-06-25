package it.polimi.ingsw.ps11.model.gameLogics.actions.decorator.baseAction;

import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class DecrementResource extends IncrementResource {

	public DecrementResource(Player player, ResourceList resource) {
		super(player, resource);
	}
	
	@Override
	public void perform() {
		getSource().getResourceList().subtract(getResource());
	}
	
	@Override
	public boolean isLegal() {
		return getSource().getResourceList().canSubtract(getResource());
	}

}
