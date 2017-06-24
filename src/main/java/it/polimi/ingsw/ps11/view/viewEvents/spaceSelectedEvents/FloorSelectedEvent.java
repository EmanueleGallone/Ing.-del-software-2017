package it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents;

import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEvent;
import it.polimi.ingsw.ps11.view.viewEvents.ViewListener;

public class FloorSelectedEvent extends SpaceSelectedEvent {

	private String tower;
	private int floor;
	
	public FloorSelectedEvent(Class<? extends Tower> tower , int floor) {
		this.tower = tower.toString();
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
