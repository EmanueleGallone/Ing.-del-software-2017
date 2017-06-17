package it.polimi.ingsw.ps11.view.viewGenerica.components;

import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.view.viewGenerica.ViewComponent;

public abstract class FloorView extends ViewComponent{

	protected Floor floor;
	protected String tower;
	protected int whichFloor;
	protected CardView cardView;
	
	public FloorView(Class<? extends Tower> tower,int whichFloor) {
		updateWhichFloor(whichFloor);
		this.tower = tower.toString();
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
}
