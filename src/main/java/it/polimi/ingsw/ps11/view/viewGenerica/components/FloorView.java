package it.polimi.ingsw.ps11.view.viewGenerica.components;

import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.view.textualView.components.TextualResourceView;
import it.polimi.ingsw.ps11.view.viewGenerica.ViewComponent;

public abstract class FloorView extends ViewComponent{

	protected Floor floor;
	protected int tower;
	protected int whichFloor;
	protected DevelopmentCardView cardView;
	protected TextualResourceView resourceView;
	
	public FloorView(int whichTower,int whichFloor) {
		updateWhichFloor(whichFloor);
		this.tower = whichTower;
	}
	
	public void update(Floor floor){
		this.floor = floor;
		cardView.update(this.floor.getCard());
		resourceView.update(this.floor.getActionSpace().getResources());
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
	
	public abstract void selected();
}
