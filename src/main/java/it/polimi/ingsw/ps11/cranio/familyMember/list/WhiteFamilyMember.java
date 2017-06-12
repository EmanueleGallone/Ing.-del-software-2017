package it.polimi.ingsw.ps11.cranio.familyMember.list;

import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;

public class WhiteFamilyMember extends FamilyMember {

	public WhiteFamilyMember(){
		super();
	}
	
	private WhiteFamilyMember(WhiteFamilyMember toCopy) {
		super(toCopy);
	}

	@Override
	public WhiteFamilyMember clone(){
		return new WhiteFamilyMember(this);
	}
}
