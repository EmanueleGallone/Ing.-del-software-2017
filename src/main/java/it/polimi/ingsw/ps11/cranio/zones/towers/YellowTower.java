package it.polimi.ingsw.ps11.cranio.zones.towers;

import it.polimi.ingsw.ps11.cranio.resources.ResourceList;
import it.polimi.ingsw.ps11.cranio.zones.actionSpace.Floor;

public class YellowTower extends Tower {

	public YellowTower() {
		addFloor(new Floor(1));
		addFloor(new Floor(3));
		
		ResourceList resource = new ResourceList();
		resource.setWood(1);
		addFloor(new Floor(5,resource.clone()));
		resource.setWood(2);
		addFloor(new Floor(7,resource));
	}
}
