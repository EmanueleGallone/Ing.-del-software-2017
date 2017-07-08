package it.polimi.ingsw.ps11.model.cards.leaderCards.requires;

import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class ResourceRequirement implements Requirement{

	private ResourceList resources;
	
	public ResourceRequirement(ResourceList resources) {
		this.resources = resources;
	}

	@Override
	public boolean isSatisfied(Player player) {
		if(player.getResourceList().canSubtract(resources))
			return true;
		return false;		
	}
}
