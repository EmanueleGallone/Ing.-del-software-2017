package it.polimi.ingsw.ps11.view.events;

import it.polimi.ingsw.ps11.model.events.Event;
import it.polimi.ingsw.ps11.view.textualView.tree.components.TextualFloorView;

public class FloorSelectedEvent extends Event<TextualFloorView> {

	public FloorSelectedEvent(TextualFloorView floorView) {
		//Occhio è la textualFloorView vecchia
		super(floorView);
	}
}
