package it.polimi.ingsw.ps11.model.familyMember.list;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
/**
 * <h3>WhiteFamilyMember</h3>
 * <p> Classe concreta che rappresenta il familiare di colore Bianco. Estende la classe FamilymMmber.</p>
 * @version 1.0
 */
public class WhiteFamilyMember extends FamilyMember {

	public WhiteFamilyMember(){
		super();
	}

	@Override
	public WhiteFamilyMember clone(){
		WhiteFamilyMember clone = new WhiteFamilyMember();
		clone.value = this.value;
		clone.modifier = this.modifier;
		
		return clone;
	}
}
