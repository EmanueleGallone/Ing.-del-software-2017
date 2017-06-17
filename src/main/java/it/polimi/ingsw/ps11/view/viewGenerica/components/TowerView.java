package it.polimi.ingsw.ps11.view.viewGenerica.components;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.model.zones.towers.Tower;
import it.polimi.ingsw.ps11.view.viewGenerica.ViewComponent;

public abstract class TowerView extends ViewComponent {

	protected ArrayList<FloorView> floors = new ArrayList<>();
	
	public void update(Tower tower){
		floors.clear();
		int i = 0;
		for(Floor f : tower.getFloors()){
			FloorView fView = floors.get(i);
			if (fView != null)
				fView.update(f,i);
			i++;
		}
	}
	
	public FloorView getFloor(int index) {
		if (index < floors.size()){
			return floors.get(index);
		}
		return null;
	}
	
	public void addFloor(FloorView floorView){
		floors.add(floorView);
	}
	
	public void setFloors(ArrayList<FloorView> floors) {
		this.floors = floors;
	}
	
}
