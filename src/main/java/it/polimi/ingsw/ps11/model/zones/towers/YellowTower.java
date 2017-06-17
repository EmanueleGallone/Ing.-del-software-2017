package it.polimi.ingsw.ps11.model.zones.towers;

import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.MilitaryPoint;
import it.polimi.ingsw.ps11.model.zones.Floor;

public class YellowTower extends Tower {

	public YellowTower() {
		addFloor(new Floor(1));
		addFloor(new Floor(3));
		
		ResourceList resource = new ResourceList();
		resource.setResource(new MilitaryPoint(1));
		addFloor(new Floor(5, resource.clone()));
		resource.setResource(new MilitaryPoint(2));
		addFloor(new Floor(7, resource.clone()));
	}
	
	private YellowTower(YellowTower toCopy){
		//copy Constructor
		for(Floor f : toCopy.getFloors())
			this.addFloor(f.clone()); //aggiungo i piani
	}
	
	@Override
	public YellowTower clone(){
		return new YellowTower(this);
		
	}
}
