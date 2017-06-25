package it.polimi.ingsw.ps11.model.gameLogics.actions.baseAction;

import java.util.Optional;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionDecorator;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.DefaultDecorator;
import it.polimi.ingsw.ps11.model.gameLogics.actions.modifier.TowerCheck;
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
	public Action enable(ActionManager aManager) {
		Optional<ActionDecorator<DecrementResource>> optional = aManager.get(DecrementResource.class);
		if(optional.isPresent())
			return optional.get().decore(this);
		return this;
	}

	@Override
	public Player getSource() {
		return player;
	}
}
