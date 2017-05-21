package it.polimi.ingsw.ps11.cranio.familyMember;

import java.util.Arrays;
import java.util.HashMap;

import it.polimi.ingsw.ps11.cranio.player.Player;

public class FamilyMemberManager {
	private BlackFamilyMember blackFamilyMember;
	private WhiteFamilyMember whiteFamilyMember;
	private NeutralFamilyMember neutralFamilyMember;
	private OrangeFamilyMember orangeFamilyMember; // inutili immagino
	
	private HashMap<Class<? extends FamilyMember>,FamilyMember> family = new HashMap<Class<? extends FamilyMember>,FamilyMember>();
	
	public FamilyMemberManager(Player owner){
		
		blackFamilyMember = new BlackFamilyMember(owner);
		whiteFamilyMember = new WhiteFamilyMember(owner);
		orangeFamilyMember = new OrangeFamilyMember(owner);
		neutralFamilyMember = new NeutralFamilyMember(owner);
		
		family.put(BlackFamilyMember.class, blackFamilyMember);
		family.put(WhiteFamilyMember.class, whiteFamilyMember);
		family.put(OrangeFamilyMember.class, orangeFamilyMember);
		family.put(NeutralFamilyMember.class, neutralFamilyMember);
		
	}
	
	
	
	
	
	

	
	public <T extends FamilyMember> T getFamilyMember(T familyMember){
		
		return (T) this.family.get(familyMember.getClass());
		
	}
	
	public <T extends FamilyMember> void setFamilyMember(T familyMember){
		this.family.put(familyMember.getClass(), familyMember);
	}








	@Override
	public String toString() {		
		return "FamilyMemberManager [family=" 
				+ "\nBlackFamilyMember= " + family.get(BlackFamilyMember.class).value
				+ "\nWhiteFamilyMember= " + family.get(WhiteFamilyMember.class).value
				+ "\nOrangeFamilyMember= " + family.get(OrangeFamilyMember.class).value
				+ "\nNeutrlaFamilyMember= " + family.get(NeutralFamilyMember.class).value
				
				+ "]";
	}

	
	
	
	
	

}
