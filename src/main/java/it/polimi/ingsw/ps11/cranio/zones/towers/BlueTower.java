package it.polimi.ingsw.ps11.cranio.zones.towers;

import it.polimi.ingsw.ps11.cranio.cards.list.BlueCard;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;
import it.polimi.ingsw.ps11.cranio.zones.Floor;

public class BlueTower extends Tower {

	public BlueTower() {
		addFloor(new Floor(1));
		addFloor(new Floor(3));
		/*
		ResourceList resource = new ResourceList();
		resource.setMilitaryPoint(1);
		addFloor(new Floor(5,resource.clone()));
		resource.setMilitaryPoint(2);
		addFloor(new Floor(7,resource));*/
	}

}
