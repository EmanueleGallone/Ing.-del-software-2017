package it.polimi.ingsw.ps11.model.cards.leaderCards.requires;

import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/**
 * <h3> ResourceRequirement </h3>
 * <p> Classe che rappresenta i requisiti di attivazione di una carta leader: richiede una resourceList.</p>
 * @param  resourceList (risorse richieste per l'attivazione della carta).</p>
 */
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
