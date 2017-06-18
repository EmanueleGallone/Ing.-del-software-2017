package it.polimi.ingsw.ps11.view.viewGenerica.components;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.view.viewGenerica.ViewComponent;

public abstract class TowerView extends ViewComponent {

	private String tower;
	protected String towerName;
	protected ArrayList<FloorView> floors = new ArrayList<>();
	
	public TowerView(Class<? extends Tower> towerColor) {
		this.tower = towerColor.toString();
		towerName = towerColor.getSimpleName();
	}
	
	public String getTower() {
		return tower;
	}
	
	public void update(Tower tower){
		this.tower = tower.getClass().toString();
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
	
}
