package it.polimi.ingsw.ps11.cranio.familyMember.list;

import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;

public class NeutralFamilyMember extends FamilyMember {
	
	public NeutralFamilyMember() {
		super();
	}
	
	private NeutralFamilyMember(NeutralFamilyMember toCopy) {
		super(toCopy);
	}
	
	@Override
	public NeutralFamilyMember clone(){
		return new NeutralFamilyMember(this);
	}
	
	@Override
	public void setValue(int value) {
		return;
	}
}
