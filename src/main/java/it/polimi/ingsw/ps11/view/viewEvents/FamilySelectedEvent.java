package it.polimi.ingsw.ps11.view.viewEvents;

import it.polimi.ingsw.ps11.model.familyMember.list.BlackFamilyMember;

public class FamilySelectedEvent extends ViewEvent {

	private String familyMember;
	

	public FamilySelectedEvent(Class<BlackFamilyMember> class1) {
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
