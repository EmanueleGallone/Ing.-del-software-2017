package it.polimi.ingsw.ps11.model.familyMember.list;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
/**
 * <h3>BlackFamilyMemberr</h3>
 * <p> Classe concreta che rappresenta il familiare nero. </p>
 * @version 1.0
 */
public class BlackFamilyMember extends FamilyMember {
	
	public BlackFamilyMember(){
		super();
	}
	
	@Override
	public BlackFamilyMember clone(){
		BlackFamilyMember clone = new BlackFamilyMember();
		clone.value = this.value;
		clone.modifier = this.modifier;
		
		return clone;
	}
}
