package it.polimi.ingsw.ps11.model.gameLogics.states;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.gameLogics.actions.ResourceListener;
import it.polimi.ingsw.ps11.model.modelEvents.ChooseResource;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.view.viewEvents.ResourceSelectedEvent;

public class WaitResource extends PlayState{

	private ResourceListener action;
	
	public WaitResource(ArrayList<ResourceList> choice, ResourceListener action) {
		ChooseResource c = new ChooseResource(choice);
		stateHandler().invoke(c);
	}
	
	
	@Override
	public void handle(ResourceSelectedEvent resourceSelectedEvent) {
		action.update(resourceSelectedEvent.getResourceList());
		stateHandler().resetState();
	}
}
