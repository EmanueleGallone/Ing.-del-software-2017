package it.polimi.ingsw.ps11.cranio.familyMember.list;

import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;

public class NeutralFamilyMember extends FamilyMember {
	
	public NeutralFamilyMember() {
		super();
	}
	
	@Override
	public NeutralFamilyMember clone(){
		NeutralFamilyMember clone = new NeutralFamilyMember();
		clone.value = this.value;
		clone.modifier = this.modifier;
		
		return clone;
	}
	
	@Override
	public void setValue(int value) {
		return;
	}
}
