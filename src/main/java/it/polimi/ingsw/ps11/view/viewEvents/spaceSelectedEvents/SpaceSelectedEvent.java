package it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents;

import it.polimi.ingsw.ps11.view.viewEvents.FamilySelectedEvent;
import it.polimi.ingsw.ps11.view.viewEvents.ViewEvent;

public abstract class SpaceSelectedEvent extends ViewEvent {

	private FamilySelectedEvent familySelectedEvent;
	
	
	public void setFamilySelectedEvent(FamilySelectedEvent familySelectedEvent) {
		this.familySelectedEvent = familySelectedEvent;
	}
	public FamilySelectedEvent getFamilySelectedEvent() {
		return familySelectedEvent;
	}
	
	public boolean isComplete(){
		return (familySelectedEvent != null);
	}

}
