package it.polimi.ingsw.ps11.mvc.view.viewGenerica.components;

import it.polimi.ingsw.ps11.cranio.zones.Floor;
import it.polimi.ingsw.ps11.mvc.view.viewGenerica.ViewComponent;

public abstract class FloorView extends ViewComponent{

	protected Floor floor;
	
	public FloorView(String id) {
		super(id);
	}

	public void update(Floor floor){
		this.floor = floor;
	}
}
