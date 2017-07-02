package it.polimi.ingsw.ps11.model.familyMember.list;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
/**
 * <h3>NeutralFamilyMember</h3>
 * <p> Classe concreta che rappresenta il familiare di colore Neutro. Estende la classe FamilyMember.</p>
 * @version 1.0
 * @see FamilyMember
 */
public class NeutralFamilyMember extends FamilyMember {
	
	public NeutralFamilyMember() {
		super();
	}
	
	public NeutralFamilyMember(String name){
		super(name);
	}
	
	@Override
	public NeutralFamilyMember clone(){
		NeutralFamilyMember clone = new NeutralFamilyMember();
		clone.dice = this.dice;
		clone.modifier = this.modifier;
		
		return clone;
	}
	@Override
	public boolean isNeutral() {
		return true;
	}
}
