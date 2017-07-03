package it.polimi.ingsw.ps11.view.viewEvents;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;

public class FamilySelectedEvent extends ViewEvent {

	private String familyMember;
	
	public FamilySelectedEvent(String familyMemberType) {
		this.familyMember = familyMemberType;
	}

	public FamilySelectedEvent(Class<? extends FamilyMember> familyMember) {
		this(familyMember.toString());
	}

	@Override
	public void accept(ViewListener listener) {
		listener.handle(this);
	}

	public String getFamilyMember() {
		return familyMember;
	}

}
