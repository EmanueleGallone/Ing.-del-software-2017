package it.polimi.ingsw.ps11.cranio.zones.towers;

import it.polimi.ingsw.ps11.cranio.resources.ResourceList;
import it.polimi.ingsw.ps11.cranio.resources.list.Coin;
import it.polimi.ingsw.ps11.cranio.zones.Floor;

public class PurpleTower extends Tower {

	public PurpleTower() {
		addFloor(new Floor(1));
		addFloor(new Floor(3));
		
		ResourceList resource = new ResourceList();
		resource.setResource(new Coin(1));
		addFloor(new Floor(5,resource.clone()));
		resource.setResource(new Coin(2));
		addFloor(new Floor(7,resource.clone()));
	}
}
