package it.polimi.ingsw.ps11.cranio.bonus;

import it.polimi.ingsw.ps11.cranio.resources.ResourceList;

public class IncrementResourceBonus extends Bonus {

	private ResourceList resourceList;
	
	public IncrementResourceBonus(ResourceList resourceList) {
		this.resourceList = resourceList;
	}

	@Override
	public void behavior() {
		getOwner().getResourceList().sum(resourceList);
	}
	
	public ResourceList getResourceList() {
		return resourceList;
	}
	
}
