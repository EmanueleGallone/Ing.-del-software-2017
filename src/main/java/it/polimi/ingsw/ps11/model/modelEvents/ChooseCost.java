package it.polimi.ingsw.ps11.model.modelEvents;

import it.polimi.ingsw.ps11.model.resources.ResourceList;

import java.util.ArrayList;

public class ChooseCost extends ModelEvent {

	private ArrayList<ResourceList> costs;
	
	public ChooseCost(ArrayList<ResourceList> costs) {
		this.costs = costs;
	}
	
	@Override
	public void accept(ModelListener listener) {
		listener.handle(this);
	}

}
