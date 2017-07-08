package it.polimi.ingsw.ps11.model.familyMember.list;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMemberManager;
/**
 * <h3>WhiteFamilyMember</h3>
 * <p> Classe concreta che rappresenta il familiare di colore Bianco. Estende la classe FamilymMmber.</p>
 * @version 1.0
 */
public class WhiteFamilyMember extends FamilyMember {
	
	private static final String id = "WhiteFamilyMember";

	public WhiteFamilyMember(){
		super(id);
	}

	@Override
	public WhiteFamilyMember clone(){
		WhiteFamilyMember clone = new WhiteFamilyMember();
		clone.dice = this.dice;
		clone.used = this.used;
		return clone;
	}

	@Override
	public WhiteFamilyMember getFrom(FamilyMemberManager familyMemberManager) {
		return familyMemberManager.getFamilyMember(id);
	}
}
