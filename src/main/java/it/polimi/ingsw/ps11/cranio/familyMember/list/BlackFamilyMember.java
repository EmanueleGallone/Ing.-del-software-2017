package it.polimi.ingsw.ps11.cranio.familyMember.list;

import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.player.Player;

public class BlackFamilyMember extends FamilyMember {
	
	
	public BlackFamilyMember(Player player){
		super(player);
	}
	
	@Override
	public BlackFamilyMember clone(){
		BlackFamilyMember familyMember = new BlackFamilyMember(owner);
		familyMember.setValue(value);
		familyMember.setModifier(modifier);
		return familyMember;
	}
}
