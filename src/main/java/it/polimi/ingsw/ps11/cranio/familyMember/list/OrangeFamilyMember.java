package it.polimi.ingsw.ps11.cranio.familyMember.list;

import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.player.Player;

public class OrangeFamilyMember extends FamilyMember {
	
	public OrangeFamilyMember(Player player){
		super(player);
	}
	
	@Override
	public OrangeFamilyMember clone(){
		OrangeFamilyMember familyMember = new OrangeFamilyMember(owner);
		familyMember.setValue(value);
		familyMember.setModifier(modifier);
		return familyMember;
	}
}
