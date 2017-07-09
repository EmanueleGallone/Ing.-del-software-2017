package it.polimi.ingsw.ps11.model.familyMember.list;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMemberManager;
/**
 * <h3>OrangeFamilyMember</h3>
 * <p> Classe concreta che rappresenta il familiare di colore Arancione. Estende la classe FamilyMember.</p>
 * @version 1.0
 */
public class OrangeFamilyMember extends FamilyMember {
	
	private static final String id = "OrangeFamilyMember";
	
	public OrangeFamilyMember(){
		super(id);
	}
	
	@Override
	public OrangeFamilyMember clone(){
		OrangeFamilyMember clone = new OrangeFamilyMember();
		clone.dice = this.dice;
		clone.used = this.used;
		return clone;
	}

	@Override
	public OrangeFamilyMember getFrom(FamilyMemberManager familyMemberManager) {
		return familyMemberManager.getFamilyMember(id);
	}
}
