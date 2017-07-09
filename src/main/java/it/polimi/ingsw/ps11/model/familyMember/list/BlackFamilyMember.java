package it.polimi.ingsw.ps11.model.familyMember.list;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMemberManager;
/**
 * <h3>BlackFamilyMemberr</h3>
 * <p> Classe concreta che rappresenta il familiare di colore Nero. Estende la classe FamilyMember</p>
 * @version 1.0
 * @see FamilyMember
 */
public class BlackFamilyMember extends FamilyMember {
	
	private static final String id = "BlackFamilyMember";
	
	public BlackFamilyMember(){
		super(id);
	}
	
	public BlackFamilyMember(String name){
		super(name);
	}
	
	@Override
	public BlackFamilyMember clone(){
		BlackFamilyMember clone = new BlackFamilyMember();
		clone.dice = this.dice;
		clone.used = this.used;
		
		return clone;
	}

	@Override
	public BlackFamilyMember getFrom(FamilyMemberManager familyMemberManager) {
		return familyMemberManager.getFamilyMember(id);
	}
	
	
}
