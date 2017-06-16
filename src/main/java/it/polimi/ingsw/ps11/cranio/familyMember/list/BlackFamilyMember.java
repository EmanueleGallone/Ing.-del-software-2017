package it.polimi.ingsw.ps11.cranio.familyMember.list;

import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;

public class BlackFamilyMember extends FamilyMember {
	
	public BlackFamilyMember(){
		super();
	}
	
	@Override
	public BlackFamilyMember clone(){
		BlackFamilyMember clone = new BlackFamilyMember();
		clone.value = this.value;
		clone.modifier = this.modifier;
		
		return clone;
	}
}
