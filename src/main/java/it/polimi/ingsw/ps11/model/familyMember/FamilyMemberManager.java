package it.polimi.ingsw.ps11.model.familyMember;

import java.util.HashMap;

import it.polimi.ingsw.ps11.model.familyMember.list.BlackFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.NeutralFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.OrangeFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.WhiteFamilyMember;

public class FamilyMemberManager {
	
	private HashMap<String,FamilyMember> family = new HashMap<>();
	
	public FamilyMemberManager(){
		
		family.put(BlackFamilyMember.class.toString(), new BlackFamilyMember());
		family.put(WhiteFamilyMember.class.toString(), new WhiteFamilyMember());
		family.put(OrangeFamilyMember.class.toString(), new OrangeFamilyMember());
		family.put(NeutralFamilyMember.class.toString(), new NeutralFamilyMember());
	}
	
	@SuppressWarnings("unchecked")
	public <T extends FamilyMember> T getFamilyMember(Class<T> familyMember){
		return (T) this.family.get(familyMember.toString());
	}
		
	public <T extends FamilyMember> void setFamilyMember(T familyMember){
		this.family.put(familyMember.getClass().toString(), familyMember);
	}
	
	@Override
	public FamilyMemberManager clone(){
		FamilyMemberManager clone = new FamilyMemberManager();
		
		for(FamilyMember f : this.family.values())
			clone.setFamilyMember(f.clone());
		
		return clone;
		
	}

}
