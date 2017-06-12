package it.polimi.ingsw.ps11.cranio.zones.towers;

import it.polimi.ingsw.ps11.cranio.resources.ResourceList;
import it.polimi.ingsw.ps11.cranio.resources.list.Wood;
import it.polimi.ingsw.ps11.cranio.zones.Floor;

public class GreenTower extends Tower {

	public GreenTower() {
		
		addFloor(new Floor(1));
		addFloor(new Floor(3));
		
		ResourceList resource = new ResourceList();
		resource.setResource(new Wood(1));
		addFloor(new Floor(5,resource.clone()));
		resource.setResource(new Wood(2));
		addFloor(new Floor(7,resource.clone()));
		
	}
	
	private GreenTower(GreenTower toCopy){
		//copy Constructor
		for(Floor f : toCopy.getFloors())
			this.addFloor(f.clone()); //aggiungo i piani
	}
	
	@Override
	public GreenTower clone(){
		return new GreenTower(this);
		
	}
	
	
	
}
