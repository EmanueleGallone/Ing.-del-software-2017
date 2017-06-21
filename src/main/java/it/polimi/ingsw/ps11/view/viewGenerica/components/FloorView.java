package it.polimi.ingsw.ps11.view.viewGenerica.components;

import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.view.viewGenerica.ViewComponent;

public abstract class FloorView extends ViewComponent{

	protected Floor floor;
	protected int tower;
	protected int whichFloor;
	protected CardView cardView;
	
	public FloorView(int whichTower,int whichFloor) {
		updateWhichFloor(whichFloor);
		this.tower = whichTower;
	}
	
	public void update(Floor floor){
		this.floor = floor;
		cardView.update(floor.getCard());
	}
	
	public void updateWhichFloor(int whichFloor){
		this.whichFloor = whichFloor;
	}
	
	public int getWhichFloor() {
		return whichFloor;
	}
	
	public int getTower() {
		return tower;
	}
}
