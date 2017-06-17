package it.polimi.ingsw.ps11.model.bonus;

import it.polimi.ingsw.ps11.model.game.actionsEma.IncrementResourceAction;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class IncrementResourceBonus extends PlayerBonus {

	private ResourceList resourceList;
	
	public IncrementResourceBonus(ResourceList resourceList) {
		this.resourceList = resourceList;
	}

	@Override
	public void behavior() {
		new IncrementResourceAction(getPlayer(), resourceList).perform();
	}
	
	public ResourceList getResourceList() {
		return resourceList;
	}
	
}
