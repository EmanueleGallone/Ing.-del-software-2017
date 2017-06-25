package it.polimi.ingsw.ps11.view.viewEvents;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;

public class FamilySelectedEvent extends ViewEvent {

	private String familyMember;
	

	public FamilySelectedEvent(Class<? extends FamilyMember> class1) {
		familyMember = class1.toString();
	}

	@Override
	public void accept(ViewListener listener) {
		listener.handle(this);
	}

	public String getFamilyMember() {
		return familyMember;
	}

}
