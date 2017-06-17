package it.polimi.ingsw.ps11.model.familyMember.list;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.player.Player;

public class OrangeFamilyMember extends FamilyMember {
	
	public OrangeFamilyMember(){
		super();
	}
	
	@Override
	public OrangeFamilyMember clone(){
		OrangeFamilyMember clone = new OrangeFamilyMember();
		clone.value = this.value;
		clone.modifier = this.modifier;
		
		return clone;
	}
}
