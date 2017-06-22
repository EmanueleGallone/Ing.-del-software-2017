package it.polimi.ingsw.ps11.model.gameLogics.states;

import it.polimi.ingsw.ps11.view.viewEvents.FamilySelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents.SpaceSelectedEvent;

public class WaitingFamilyMember extends PlayState{

	private SpaceSelectedEvent event;
	
	public WaitingFamilyMember(SpaceSelectedEvent event) {
		this.event = event;
	}
	
	@Override
	public void handle(FamilySelectedEvent familySelectedEvent) {
		event.setFamilySelectedEvent(familySelectedEvent);
		stateHandler().resetState();
		event.accept(stateHandler().currentState());
	}
	
}
