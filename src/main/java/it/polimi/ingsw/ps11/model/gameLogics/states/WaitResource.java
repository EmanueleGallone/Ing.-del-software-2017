package it.polimi.ingsw.ps11.model.gameLogics.states;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.gameLogics.actions.ResourceListener;
import it.polimi.ingsw.ps11.model.modelEvents.ChooseResourceEvent;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.view.viewEvents.ResourceSelectedEvent;
/**
 * <h3> State </h3>
 * <p> Classe che rappresenta lo stato di attesa della scelta di una ResourceList da parte del giocatore.</p>
 * @see 
 */
public class WaitResource extends PlayState{

	private ArrayList<ResourceList> choices;
	private ResourceListener action;
	
	public WaitResource(ResourceListener action) {
		this.action = action;
	}
	
	public WaitResource(ArrayList<ResourceList> choices, ResourceListener action) {
		this.action = action;
		this.choices = choices;
	}
	
	@Override
	public void notifyToClient() {
		ChooseResourceEvent c = new ChooseResourceEvent(choices);
		stateHandler().invoke(c);
	}
	
	
	@Override
	public void handle(ResourceSelectedEvent resourceSelectedEvent) {
		action.update(resourceSelectedEvent.getResourceList());
	}
}
