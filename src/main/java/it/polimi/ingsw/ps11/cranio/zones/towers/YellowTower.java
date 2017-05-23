package it.polimi.ingsw.ps11.cranio.zones.towers;

import it.polimi.ingsw.ps11.cranio.cards.list.YellowCard;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;
import it.polimi.ingsw.ps11.cranio.resources.list.MilitaryPoint;
import it.polimi.ingsw.ps11.cranio.zones.Floor;

public class YellowTower extends Tower {

	public YellowTower() {
		addFloor(new Floor(1));
		addFloor(new Floor(3));
		
		ResourceList resource = new ResourceList();
		resource.setValueOf(MilitaryPoint.class, 1);
		addFloor(new Floor(5, resource.clone()));
		resource.setValueOf(MilitaryPoint.class, 2);
		addFloor(new Floor(7, resource.clone()));
	}
}
