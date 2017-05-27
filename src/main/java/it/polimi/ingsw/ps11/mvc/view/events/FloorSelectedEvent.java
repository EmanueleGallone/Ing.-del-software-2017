package it.polimi.ingsw.ps11.mvc.view.events;

import it.polimi.ingsw.ps11.cranio.events.Event;
import it.polimi.ingsw.ps11.mvc.components.FloorView;

public class FloorSelectedEvent extends Event<FloorView> {

	public FloorSelectedEvent(FloorView floorView) {
		super(floorView);
	}
}
