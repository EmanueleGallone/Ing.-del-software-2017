package it.polimi.ingsw.ps11.cranio.familyMember;

import it.polimi.ingsw.ps11.cranio.player.Player;

public class FamilyMemberManager {
	private BlackFamilyMember blackFamilyMember;
	private WhiteFamilyMember whiteFamilyMember;
	private NeutralFamilyMember neutralFamilyMember;
	private OrangeFamilyMember orangeFamilyMember;
	
	public FamilyMemberManager(Player owner){
		blackFamilyMember = new BlackFamilyMember(owner);
		whiteFamilyMember = new WhiteFamilyMember(owner);
		orangeFamilyMember = new OrangeFamilyMember(owner);
		neutralFamilyMember = new NeutralFamilyMember(owner);
	}
	
	

}
