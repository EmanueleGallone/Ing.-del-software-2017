package it.polimi.ingsw.ps11.model.familyMember.list;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;

public class WhiteFamilyMember extends FamilyMember {

	public WhiteFamilyMember(){
		super();
	}

	@Override
	public WhiteFamilyMember clone(){
		WhiteFamilyMember clone = new WhiteFamilyMember();
		clone.value = this.value;
		clone.modifier = this.modifier;
		
		return clone;
	}
}
