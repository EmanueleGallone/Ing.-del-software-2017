package it.polimi.ingsw.ps11.model.zones.towers;

import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.MilitaryPoint;
import it.polimi.ingsw.ps11.model.zones.Floor;

public class YellowTower extends Tower {

	public YellowTower() {
		addFloor(new Floor(1));
		addFloor(new Floor(3));
		
		ResourceList resource = new ResourceList(new MilitaryPoint(1));
		addFloor(new Floor(5, resource.clone()));
		resource.setResource(new MilitaryPoint(2));
		addFloor(new Floor(7, resource.clone()));
	}
	
	@Override
	public YellowTower clone(){
		YellowTower clone = new YellowTower();
		clone.getFloors().clear();
		
		for(Floor f : this.getFloors()){
			if (f != null)
				clone.addFloor(f.clone());
		}
		
		return clone;
		
	}
}
