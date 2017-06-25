package it.polimi.ingsw.ps11.model.gameLogics.actions.decorator.baseAction;

import it.polimi.ingsw.ps11.model.gameLogics.actions.decorator.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.decorator.ActionDecorator;
import it.polimi.ingsw.ps11.model.gameLogics.actions.decorator.ActionManager;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class IncrementResource implements Action {

	private Player player;
	private ResourceList resource;
	
	public IncrementResource(Player player, ResourceList resource) {
		this.player = player;
		this.resource = resource;
	}

	public ResourceList getResource() {
		return resource;
	}
	
	@Override
	public Player getSource() {
		return player;
	}
	
	@Override
	public void perform() {
		getSource().getResourceList().sum(resource);
	}

	@Override
	public boolean isLegal() {
		return true;
	}

	@Override
	public ActionDecorator<IncrementResource> enable(ActionManager aManager) {
		ActionDecorator<IncrementResource> decorator = aManager.get(IncrementResource.class);
		return decorator.decore(this);
	}
}
