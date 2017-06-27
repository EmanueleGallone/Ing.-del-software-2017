package it.polimi.ingsw.ps11.view.viewGenerica.components;

import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.view.textualView.components.TextualDevelopmentCardView;
import it.polimi.ingsw.ps11.view.textualView.components.TextualResourceView;
import it.polimi.ingsw.ps11.view.viewGenerica.ViewComponent;

public abstract class FloorView extends ViewComponent{

	protected Floor floor;
	protected String tower;
	protected int whichFloor;
	protected DevelopmentCardView cardView = new TextualDevelopmentCardView();
	protected TextualResourceView resourceView = new TextualResourceView();
	
	public FloorView(Class<? extends Tower> whichTower,int whichFloor) {
		updateWhichFloor(whichFloor);
		this.tower = whichTower.toString();
	}
	
	public FloorView(Floor floor){
		//potrebbe creare problemi.
		update(floor);
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
	
	public String getTower() {
		return tower;
	}
	
}
