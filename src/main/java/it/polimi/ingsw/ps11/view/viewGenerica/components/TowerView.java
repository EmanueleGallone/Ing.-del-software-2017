package it.polimi.ingsw.ps11.view.viewGenerica.components;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.view.viewGenerica.ViewComponent;

public abstract class TowerView extends ViewComponent {

	private int tower;
	protected String towerName;
	protected ArrayList<FloorView> floors = new ArrayList<>();
	
	public TowerView(int whichTower) {
		this.tower = whichTower;
		this.towerName = towerName;
	}
	
	public TowerView(int whichTower, String towerName) {
		this.tower = whichTower;
		this.towerName = towerName;
	}
	
	public int getTower() {
		return tower;
	}
	
	public void update(Tower tower){
		for(FloorView fView : floors){
			fView.update(tower.getFloor(fView.getWhichFloor()));
		}
	}
	
	public void addFloor(FloorView floorView){
		floors.add(floorView);
	}
	
	public void setFloors(ArrayList<FloorView> floors) {
		this.floors = floors;
	}
	
	public ArrayList<FloorView> getFloors() {
		return floors;
	}
	
}
