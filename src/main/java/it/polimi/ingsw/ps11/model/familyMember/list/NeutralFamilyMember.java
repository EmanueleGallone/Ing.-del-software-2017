package it.polimi.ingsw.ps11.model.familyMember.list;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
/**
 * <h3>NeutralFamilyMember</h3>
 * <p> Classe concreta che rappresenta il familiare neutro. </p>
 * @version 1.0
 */
public class NeutralFamilyMember extends FamilyMember {
	
	public NeutralFamilyMember() {
		super();
	}
	
	@Override
	public NeutralFamilyMember clone(){
		NeutralFamilyMember clone = new NeutralFamilyMember();
		clone.value = this.value;
		clone.modifier = this.modifier;
		
		return clone;
	}
	
	@Override
	public void setValue(int value) {
		return;
	}
}
