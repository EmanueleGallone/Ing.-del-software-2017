package it.polimi.ingsw.ps11.model.zones.towers;

import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Stone;
import it.polimi.ingsw.ps11.model.zones.Floor;

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
	
	@Override
	public BlueTower clone(){
		BlueTower clone = new BlueTower();
		clone.getFloors().clear();
		
		for(Floor f : this.getFloors()){
			if (f != null)
				clone.addFloor(f.clone());
		}
		return clone;
		
	}
	
	

}
