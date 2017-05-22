package it.polimi.ingsw.ps11.cranio.familyMember.list;

import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.player.Player;

public class NeutralFamilyMember extends FamilyMember {
	
	public NeutralFamilyMember(Player player){
		super(player);
	}
	
	@Override
	public NeutralFamilyMember clone(){
		NeutralFamilyMember familyMember = new NeutralFamilyMember(owner);
		familyMember.setValue(value);
		familyMember.setModifier(modifier);
		return familyMember;
	}
	
	@Override
	public void setValue(int value) {
		return;
	}
}
