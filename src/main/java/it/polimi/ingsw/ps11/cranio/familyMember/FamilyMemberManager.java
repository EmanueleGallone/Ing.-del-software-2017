package it.polimi.ingsw.ps11.cranio.familyMember;

import java.util.HashMap;

import it.polimi.ingsw.ps11.cranio.player.Player;

public class FamilyMemberManager {
	private BlackFamilyMember blackFamilyMember;
	private WhiteFamilyMember whiteFamilyMember;
	private NeutralFamilyMember neutralFamilyMember;
	private OrangeFamilyMember orangeFamilyMember;
	
	private HashMap<Integer,FamilyMember> family = new HashMap<Integer, FamilyMember>();
	
	public FamilyMemberManager(Player owner){
		
		blackFamilyMember = new BlackFamilyMember(owner);
		whiteFamilyMember = new WhiteFamilyMember(owner);
		orangeFamilyMember = new OrangeFamilyMember(owner);
		neutralFamilyMember = new NeutralFamilyMember(owner);
		
		family.put(blackFamilyMember.getID(), blackFamilyMember);
		family.put(whiteFamilyMember.getID(), whiteFamilyMember);
		family.put(orangeFamilyMember.getID(), orangeFamilyMember);
		family.put(neutralFamilyMember.getID(), neutralFamilyMember);
		
	}
	
	
	
	
	
	

	public BlackFamilyMember getBlackFamilyMember() {
		return blackFamilyMember;
	}

	public WhiteFamilyMember getWhiteFamilyMember() {
		return whiteFamilyMember;
	}

	public NeutralFamilyMember getNeutralFamilyMember() {
		return neutralFamilyMember;
	}

	public OrangeFamilyMember getOrangeFamilyMember() {
		return orangeFamilyMember;
	}

	/*public void setBlackFamilyMember(BlackFamilyMember blackFamilyMember) {
		this.blackFamilyMember = blackFamilyMember;
	}

	public void setWhiteFamilyMember(WhiteFamilyMember whiteFamilyMember) {
		this.whiteFamilyMember = whiteFamilyMember;
	}

	public void setNeutralFamilyMember(NeutralFamilyMember neutralFamilyMember) {
		this.neutralFamilyMember = neutralFamilyMember;
	}

	public void setOrangeFamilyMember(OrangeFamilyMember orangeFamilyMember) {
		this.orangeFamilyMember = orangeFamilyMember;
	}*/
	
	
	
	
	

}
