package it.polimi.ingsw.ps11.view.viewGenerica.components;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.view.viewGenerica.ViewComponent;

public abstract class TowerView extends ViewComponent {

	private String whichTower;
	protected String towerName;
	protected ArrayList<FloorView> floorViews = new ArrayList<>();
	protected final int TOWERNUMBER = 4;
	
	public TowerView(Class<? extends Tower> whichTower, String towerName) {
		this.whichTower = whichTower.toString();
		this.towerName = towerName;
	}
	
	public TowerView(Class<? extends Tower> whichTower) {
		this(whichTower, whichTower.getSimpleName());
	}
	
	public TowerView(Tower tower){
		update(tower);
	}
	
	public String getTower() {
		return whichTower;
	}
	
	public void update(Tower tower){
		for(FloorView fView : floorViews){
			fView.update(tower.getFloor(fView.getWhichFloor()));
		}
	}
	
	public void addFloor(FloorView floorView){
		floorViews.add(floorView);
	}
	
	/*public void setFloors(ArrayList<FloorView> floors) {
		this.floorViews = floors;
	}*/
	
	public ArrayList<FloorView> getFloorViews() {
		return floorViews;
	}
	
	public abstract void selected();
	
}
