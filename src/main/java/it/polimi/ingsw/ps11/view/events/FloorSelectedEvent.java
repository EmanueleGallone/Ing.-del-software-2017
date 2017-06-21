package it.polimi.ingsw.ps11.view.events;

public class FloorSelectedEvent {

	private int whichFloor;
	private int tower;
	
	public FloorSelectedEvent(int tower,int whichFloor) {
		this.tower = tower;
		this.whichFloor = whichFloor;
	}
}
