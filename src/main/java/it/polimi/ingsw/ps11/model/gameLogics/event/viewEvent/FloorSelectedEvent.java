package it.polimi.ingsw.ps11.model.gameLogics.event.viewEvent;

import it.polimi.ingsw.ps11.model.gameLogics.State;
import it.polimi.ingsw.ps11.model.gameLogics.event.ViewEvent;

public class FloorSelectedEvent implements ViewEvent {

	private int whichFloor;
	private int whichTower;
	
	public FloorSelectedEvent(int tower, int floor) {
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
	public void accept(State state) {
		state.visit(this);
	}
	
	
}
