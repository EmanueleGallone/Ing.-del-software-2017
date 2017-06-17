package it.polimi.ingsw.ps11.view.viewGenerica.components;

import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.view.viewGenerica.ViewComponent;

public abstract class FloorView extends ViewComponent{

	protected Floor floor;
	protected int whichFloor;
	
	
	public void update(Floor floor, int whichFloor){
		this.floor = floor;
		this.whichFloor = whichFloor;
	}
}
