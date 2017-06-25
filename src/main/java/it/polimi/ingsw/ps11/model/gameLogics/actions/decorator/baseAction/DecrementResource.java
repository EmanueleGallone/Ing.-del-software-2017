package it.polimi.ingsw.ps11.model.gameLogics.actions.decorator.baseAction;

import it.polimi.ingsw.ps11.model.gameLogics.actions.decorator.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.decorator.ActionDecorator;
import it.polimi.ingsw.ps11.model.gameLogics.actions.decorator.ActionManager;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class DecrementResource implements Action {

	private Player player;
	private ResourceList resource;
	
	public DecrementResource(Player player, ResourceList resource) {
		this.player = player;
		this.resource = resource;
	}
	
	public ResourceList getResource() {
		return resource;
	}
	
	@Override
	public void perform() {
		getSource().getResourceList().subtract(getResource());
	}
	
	@Override
	public boolean isLegal() {
		return getSource().getResourceList().canSubtract(getResource());
	}

	
	@Override
	public ActionDecorator<DecrementResource> enable(ActionManager aManager) {
		ActionDecorator<DecrementResource> decorator = aManager.get(DecrementResource.class);
		return decorator.decore(this);
	}

	@Override
	public Player getSource() {
		return player;
	}
}
