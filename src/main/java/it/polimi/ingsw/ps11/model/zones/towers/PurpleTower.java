package it.polimi.ingsw.ps11.model.zones.towers;

import it.polimi.ingsw.ps11.model.cards.list.PurpleCard;
import it.polimi.ingsw.ps11.model.zones.Floor;
/**
 * <h3> PurpleTower </h3>
 * <p> Classe che rappresenta la torre contenente le carte di tipo "Impresa" e identificata dal colore Viola. Estende la classe Tower.</p>
 * @see Tower
 */
public class PurpleTower extends Tower {

	public PurpleTower() {
//		addFloor(new Floor(1));
//		addFloor(new Floor(3));
//		
//		ResourceList resource = new ResourceList();
//		resource.setResource(new Coin(1));
//		addFloor(new Floor(5,resource.clone()));
//		resource.setResource(new Coin(2));
//		addFloor(new Floor(7,resource.clone()));
		setCardType(PurpleCard.class);
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
