package it.polimi.ingsw.ps11.mvc.view.events;

import it.polimi.ingsw.ps11.cranio.events.Event;
import it.polimi.ingsw.ps11.mvc.view.textualView.tree.components.TextualFloorView;

public class FloorSelectedEvent extends Event<TextualFloorView> {

	public FloorSelectedEvent(TextualFloorView floorView) {
		super(floorView);
	}
}
