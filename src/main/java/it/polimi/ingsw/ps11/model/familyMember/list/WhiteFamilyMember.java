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
	
	public WhiteFamilyMember(String name){
		super(name);
	}

	@Override
	public WhiteFamilyMember clone(){
		WhiteFamilyMember clone = new WhiteFamilyMember();
		clone.dice = this.dice;
		clone.name = this.name;
		clone.used = this.used;
		return clone;
	}
}
