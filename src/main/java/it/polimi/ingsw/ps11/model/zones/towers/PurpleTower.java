package it.polimi.ingsw.ps11.model.zones.towers;

import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.zones.Floor;

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
	
	@Override
	public PurpleTower clone(){
		PurpleTower clone = new PurpleTower();
		clone.getFloors().clear();
		
		
		for(Floor f : this.getFloors()){
			if (f != null)
				clone.addFloor(f.clone());
		}	
		return clone;
	}
}
