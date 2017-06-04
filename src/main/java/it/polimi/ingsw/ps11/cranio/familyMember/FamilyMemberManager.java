package it.polimi.ingsw.ps11.cranio.familyMember;

import java.util.HashMap;

import it.polimi.ingsw.ps11.cranio.familyMember.list.*;
import it.polimi.ingsw.ps11.cranio.player.Player;

public class FamilyMemberManager {
	
	private HashMap<String,FamilyMember> family = new HashMap<>();
	
	public FamilyMemberManager(Player owner){
		
		family.put(BlackFamilyMember.class.toString(), new BlackFamilyMember(owner));
		family.put(WhiteFamilyMember.class.toString(), new WhiteFamilyMember(owner));
		family.put(OrangeFamilyMember.class.toString(), new OrangeFamilyMember(owner));
		family.put(NeutralFamilyMember.class.toString(), new NeutralFamilyMember(owner));
	}
	
	public <T extends FamilyMember> T getFamilyMember(Class<T> familyMember){
		return (T) this.family.get(familyMember.toString());
	}
		
	public <T extends FamilyMember> void setFamilyMember(T familyMember){
		this.family.put(familyMember.getClass().toString(), familyMember);
	}

}
