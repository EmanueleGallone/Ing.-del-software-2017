package it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents;

import it.polimi.ingsw.ps11.view.viewEvents.ViewListener;

public class FloorSelectedEvent extends SpaceSelectedEvent {

	private String tower;
	private int floor;
	
	public FloorSelectedEvent(String tower , int floor) {
		this.tower = tower;
		this.floor = floor;
	}
	
	public String getTower() {
		return tower;
	}
	
	public int getFloor() {
		return floor;
	}

	@Override
	public void accept(ViewListener listener) {
		listener.handle(this);
	}

}
