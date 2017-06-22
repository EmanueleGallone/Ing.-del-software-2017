package it.polimi.ingsw.ps11.view.viewEvents;

import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;

public class FloorSelectedEvent extends ViewEvent {

	private String tower;
	private int floor;
	
	public FloorSelectedEvent(Player player,Class<? extends Tower> tower , int floor) {
		super(player);
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
