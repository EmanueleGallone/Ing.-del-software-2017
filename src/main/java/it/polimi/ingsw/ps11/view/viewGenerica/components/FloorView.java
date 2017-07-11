package it.polimi.ingsw.ps11.view.viewGenerica.components;

import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.view.viewGenerica.ViewComponent;

public abstract class FloorView extends ViewComponent{

	protected Floor floor;
	protected String tower;
	protected int whichFloor;

	protected DevelopmentCardView cardView;
	protected ResourceView resourceView;

	public FloorView(String whichTower,int whichFloor) {
		updateWhichFloor(whichFloor);
		this.tower = whichTower;
	}
	
	public void update(Floor floor){
		this.floor = floor;
		cardView.update(this.floor.getCard());
		if(resourceView != null)
			resourceView.update(this.floor.getActionSpace().getResources());
	}
	
	public void updateWhichFloor(int whichFloor){
		this.whichFloor = whichFloor;
	}
	
	public int getWhichFloor() {
		return whichFloor;
	}
	
	public String getTower() {
		return tower;
	}

}
