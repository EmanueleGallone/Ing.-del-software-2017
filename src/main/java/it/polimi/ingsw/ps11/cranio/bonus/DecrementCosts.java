package it.polimi.ingsw.ps11.cranio.bonus;

import it.polimi.ingsw.ps11.cranio.resources.ResourceList;
import it.polimi.ingsw.ps11.cranio.zones.towers.Tower;

public class DecrementCosts extends Bonus {

	private Tower tower;
	private ResourceList resourceList;
	private ResourceList result;
	
	public DecrementCosts(Tower tower, ResourceList resourceList) {
		this.tower = tower;
		this.resourceList = resourceList;
	}
	
	public ResourceList getResult() {
		return result;
	}
	
	@Override
	public void behavior() {
		result.sum(owner.getResourceList());
	}
}
