package it.polimi.ingsw.ps11.mvc.view.viewGenerica.components;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.mvc.view.viewGenerica.ViewComponent;

public abstract class TowerView extends ViewComponent {

	protected ArrayList<FloorView> tower;
	
	public TowerView(String id) {
		super(id);
	}
	
	public void update(ArrayList<FloorView> floors){
	  this.tower = floors;
	}
	
}
