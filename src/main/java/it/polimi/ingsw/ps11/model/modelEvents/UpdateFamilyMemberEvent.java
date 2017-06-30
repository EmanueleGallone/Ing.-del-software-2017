package it.polimi.ingsw.ps11.model.modelEvents;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMemberManager;

public class UpdateFamilyMemberEvent extends ModelEvent {

	private FamilyMemberManager manager;
	
	public UpdateFamilyMemberEvent(FamilyMemberManager familyMemberManager) {
		this.manager = manager;
	}
	
	public FamilyMemberManager getManager() {
		return manager;
	}
	
	@Override
	public void accept(ModelListener listener) {
		listener.handle(this);
	}

}
