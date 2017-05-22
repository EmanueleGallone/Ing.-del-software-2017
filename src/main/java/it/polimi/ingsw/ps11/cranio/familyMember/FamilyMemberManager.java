package it.polimi.ingsw.ps11.cranio.familyMember;

import java.util.HashMap;

import it.polimi.ingsw.ps11.cranio.familyMember.list.*;
import it.polimi.ingsw.ps11.cranio.player.Player;

public class FamilyMemberManager {
	
	private HashMap<Class<? extends FamilyMember>,FamilyMember> family = new HashMap<Class<? extends FamilyMember>,FamilyMember>();
	
	public FamilyMemberManager(Player owner){
		
		family.put(BlackFamilyMember.class, new BlackFamilyMember(owner));
		family.put(WhiteFamilyMember.class, new WhiteFamilyMember(owner));
		family.put(OrangeFamilyMember.class, new OrangeFamilyMember(owner));
		family.put(NeutralFamilyMember.class, new NeutralFamilyMember(owner));
	}
	
	public <T extends FamilyMember> T getFamilyMember(Class<T> familyMember){
		return (T) this.family.get(familyMember);
	}
		
	public <T extends FamilyMember> void setFamilyMember(T familyMember){
		this.family.put(familyMember.getClass(), familyMember);
	}

}
