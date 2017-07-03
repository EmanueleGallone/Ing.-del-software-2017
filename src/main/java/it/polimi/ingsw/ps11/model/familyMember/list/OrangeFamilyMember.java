package it.polimi.ingsw.ps11.model.familyMember.list;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
/**
 * <h3>OrangeFamilyMember</h3>
 * <p> Classe concreta che rappresenta il familiare di colore Arancione. Estende la classe FamilyMember.</p>
 * @version 1.0
 */
public class OrangeFamilyMember extends FamilyMember {
	
	public OrangeFamilyMember(){
		super();
	}
	
	public OrangeFamilyMember(String name){
		super(name);
	}
	
	@Override
	public OrangeFamilyMember clone(){
		OrangeFamilyMember clone = new OrangeFamilyMember();
		clone.dice = this.dice;
		clone.modifier = this.modifier;
		clone.name = this.name;
		clone.used = this.used;
		return clone;
	}
}
