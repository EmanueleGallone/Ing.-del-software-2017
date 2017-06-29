package it.polimi.ingsw.ps11.model.modelEvents;

import it.polimi.ingsw.ps11.model.resources.ResourceList;

import java.util.ArrayList;

public class ChooseResourceEvent extends ModelEvent {

	private ArrayList<ResourceList> options;
	
	public ChooseResourceEvent(ArrayList<ResourceList> options) {
		this.options = options;
	}
	
	public ArrayList<ResourceList> getOptions() {
		return options;
	}
	
	@Override
	public void accept(ModelListener listener) {
		listener.handle(this);
	}

}
