package it.polimi.ingsw.ps11.model.bonus;

import it.polimi.ingsw.ps11.model.game.actionsEma.PlaceFamilyTowerAction;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;

public class DecrementCostBonus extends PlayerBonus {

	private Tower tower;
	private ResourceList resourceList;
	private ResourceList result;
	
	public DecrementCostBonus(Tower tower, ResourceList resourceList) {
		this.tower = tower;
		this.resourceList = resourceList;
	}
	
	public ResourceList getResult() {
		return result;
	}
	
	@Override
	public void behavior() {
		new PlaceFamilyTowerAction().perform(this);
	}
	
	public Tower getTower() {
		return tower;
	}
}
