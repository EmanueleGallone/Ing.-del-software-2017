package it.polimi.ingsw.ps11.cranio.familyMember.list;

import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.player.Player;

public class WhiteFamilyMember extends FamilyMember {

	
	public WhiteFamilyMember(Player player){
		super(player);
	}

	@Override
	public WhiteFamilyMember clone(){
		WhiteFamilyMember familyMember = new WhiteFamilyMember(owner);
		familyMember.setValue(value);
		familyMember.setModifier(modifier);
		return familyMember;
	}
}
