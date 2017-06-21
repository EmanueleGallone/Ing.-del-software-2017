package it.polimi.ingsw.ps11.model.oldGameLogics.events.list;

import it.polimi.ingsw.ps11.model.oldGameLogics.GameLogic;
import it.polimi.ingsw.ps11.model.oldGameLogics.events.GameEvent;

public class FloorSelected implements GameEvent {

	private int whichFloor;
	private int whichTower;
	
	public FloorSelected(int tower, int floor) {
		this.whichTower = tower;
		this.whichFloor = floor;
	}
	
	public int getFloor() {
		return whichFloor;
	}
	
	public int getTower() {
		return whichTower;
	}
	
	@Override
	public void accept(GameLogic gameLogic) {
		gameLogic.handle(this);
	}

}
