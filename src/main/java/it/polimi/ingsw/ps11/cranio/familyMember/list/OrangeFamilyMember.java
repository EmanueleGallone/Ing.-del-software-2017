package it.polimi.ingsw.ps11.cranio.familyMember.list;

import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.player.Player;

public class OrangeFamilyMember extends FamilyMember {
	
	public OrangeFamilyMember(){
		super();
	}
	
	private OrangeFamilyMember(OrangeFamilyMember toCopy) {
		super(toCopy);
	}
	
	@Override
	public OrangeFamilyMember clone(){
		return new OrangeFamilyMember(this);
	}
}
