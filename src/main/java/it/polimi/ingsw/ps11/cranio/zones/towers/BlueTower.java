package it.polimi.ingsw.ps11.cranio.zones.towers;

import it.polimi.ingsw.ps11.cranio.resources.ResourceList;
import it.polimi.ingsw.ps11.cranio.resources.list.MilitaryPoint;
import it.polimi.ingsw.ps11.cranio.resources.list.Stone;
import it.polimi.ingsw.ps11.cranio.zones.Floor;

public class BlueTower extends Tower {

	public BlueTower() {
		addFloor(new Floor(1));
		addFloor(new Floor(3));
		
		ResourceList resource = new ResourceList();
		resource.setResource(new Stone(1));
		addFloor(new Floor(5,resource.clone()));
		resource.setResource(new Stone(2));
		addFloor(new Floor(7,resource.clone()));
	}
	
	

}
