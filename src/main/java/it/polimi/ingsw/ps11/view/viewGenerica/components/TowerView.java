package it.polimi.ingsw.ps11.view.viewGenerica.components;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.view.viewGenerica.ViewComponent;

public abstract class TowerView extends ViewComponent {

	protected String towerName;
	protected ArrayList<FloorView> floorViews = new ArrayList<>();
	protected final int TOWERNUMBER = 4;

	public TowerView(String towername) {
		this.towerName = towername;
	}
	
	public String getTowerName() {
		return towerName;
	}
	
	public void update(Tower tower){
			for(FloorView fView : floorViews){
			fView.update(tower.getFloor(fView.getWhichFloor()));
		}
	}
	
	public void addFloor(FloorView floorView){
		floorViews.add(floorView);

	}
	
	public void setFloor(Integer index, FloorView floorView) {
		floorViews.set(index, floorView);
	}
	
	public void setFloors(ArrayList<FloorView> floors) {
		this.floorViews = floors;
	}
	
	public ArrayList<FloorView> getFloorViews() {
		return floorViews;
	}
	
}
