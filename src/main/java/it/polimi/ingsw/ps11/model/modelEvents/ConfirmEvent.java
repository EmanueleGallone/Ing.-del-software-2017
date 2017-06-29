package it.polimi.ingsw.ps11.model.modelEvents;

import it.polimi.ingsw.ps11.model.zones.Floor;

public class ConfirmEvent extends ModelEvent {

	private Floor floor;
	
	public Floor getFloor() {
		return floor;
	}
	
	@Override
	public void accept(ModelListener listener) {
		listener.handle(this);
	}

}
