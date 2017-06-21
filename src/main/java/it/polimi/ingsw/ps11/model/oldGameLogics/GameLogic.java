package it.polimi.ingsw.ps11.model.oldGameLogics;

import it.polimi.ingsw.ps11.model.oldGameLogics.events.list.FloorSelected;

public interface GameLogic {

	//Visitor pattern
	public void handle();

	public void handle(FloorSelected floorSelected);
}
