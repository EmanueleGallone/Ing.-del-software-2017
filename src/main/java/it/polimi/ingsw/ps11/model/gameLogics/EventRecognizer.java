package it.polimi.ingsw.ps11.model.gameLogics;

import it.polimi.ingsw.ps11.model.gameLogics.event.viewEvent.FloorSelectedEvent;

public interface EventRecognizer {

	public void visit(FloorSelectedEvent floorSelectedEvent);
}
