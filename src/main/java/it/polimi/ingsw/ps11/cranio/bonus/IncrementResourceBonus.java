package it.polimi.ingsw.ps11.cranio.bonus;

import it.polimi.ingsw.ps11.cranio.game.actionsEma.IncrementResourceAction;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;

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
