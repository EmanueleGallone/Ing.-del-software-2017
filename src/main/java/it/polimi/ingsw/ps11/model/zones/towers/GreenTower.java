package it.polimi.ingsw.ps11.model.zones.towers;

import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Wood;
import it.polimi.ingsw.ps11.model.zones.Floor;
/**
 * <h3> GreenTower </h3>
 * <p> Classe che rappresenta la torre contenente le carte di tipo "Territorio" e identificata dal colore Verde. Estende la classe Tower.</p>
 * @see Tower
 */
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
	
	@Override
	public GreenTower clone(){
		GreenTower clone = new GreenTower();
		clone.getFloors().clear();
		
		for(Floor f : this.getFloors()){
			if (f != null)
				clone.addFloor(f.clone());
		}
		return clone;
	}
	
	
	
}
