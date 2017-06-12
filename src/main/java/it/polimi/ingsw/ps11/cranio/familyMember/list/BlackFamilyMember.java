package it.polimi.ingsw.ps11.cranio.familyMember.list;

import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;

public class BlackFamilyMember extends FamilyMember {
	
	public BlackFamilyMember(){
		super();
	}
	
	private BlackFamilyMember(BlackFamilyMember toCopy) {
		super(toCopy);
	}
	
	@Override
	public BlackFamilyMember clone(){
		return new BlackFamilyMember(this);
	}
}
