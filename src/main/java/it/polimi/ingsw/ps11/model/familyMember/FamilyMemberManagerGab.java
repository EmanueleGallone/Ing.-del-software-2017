package it.polimi.ingsw.ps11.model.familyMember;

import java.util.HashMap;

import it.polimi.ingsw.ps11.model.familyMember.list.BlackFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.NeutralFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.OrangeFamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.list.WhiteFamilyMember;


public class FamilyMemberManagerGab {

private HashMap<String,FamilyMember> family = new HashMap<>();
	
	public FamilyMemberManagerGab(){
		
		family.put(BlackFamilyMember.class.toString(), new BlackFamilyMember());
		family.put(OrangeFamilyMember.class.toString(), new OrangeFamilyMember());
		family.put(WhiteFamilyMember.class.toString(), new WhiteFamilyMember());
		family.put(NeutralFamilyMember.class.toString(), new NeutralFamilyMember());
	}
	
	public BlackFamilyMember getBlackFamilyMember() {
		
		return (BlackFamilyMember) family.get(BlackFamilyMember.class.toString());
	}
	
	public OrangeFamilyMember getOrangeFamilyMember() {
		
		return (OrangeFamilyMember) family.get(OrangeFamilyMember.class.toString());
	}
	
	public WhiteFamilyMember getWhiteFamilyMember() {
		
		return (WhiteFamilyMember) family.get(WhiteFamilyMember.class.toString());
	}
	
	public NeutralFamilyMember getNeutralFamilyMember() {
		
		return (NeutralFamilyMember) family.get(NeutralFamilyMember.class.toString());
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