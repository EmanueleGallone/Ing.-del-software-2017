package it.polimi.ingsw.ps11.model.gameLogics.actions.baseAction;

import java.util.Optional;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionDecorator;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
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
	public Action enable(ActionManager aManager) {
		Optional<ActionDecorator<IncrementResource>> optional = aManager.get(IncrementResource.class);
		if(optional.isPresent())
			return optional.get().decore(this);
		return this;
	}
}
