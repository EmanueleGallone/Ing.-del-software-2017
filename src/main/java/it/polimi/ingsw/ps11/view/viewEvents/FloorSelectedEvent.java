package it.polimi.ingsw.ps11.view.viewEvents;

import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;

public class FloorSelectedEvent implements ViewEvent {

	private Player player;
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
	
	public Player getPlayer() {
		return player;
	}
	
	@Override
	public void accept(ViewListener listener) {
		listener.handle(this);
	}

	@Override
	public void setSource(Player player) {
		this.player = player;
	}

}
