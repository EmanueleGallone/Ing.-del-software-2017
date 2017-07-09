package it.polimi.ingsw.ps11.model.familyMember.list;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMemberManager;
/**
 * <h3>NeutralFamilyMember</h3>
 * <p> Classe concreta che rappresenta il familiare di colore Neutro. Estende la classe FamilyMember.</p>
 * @version 1.0
 * @see FamilyMember
 */
public class NeutralFamilyMember extends FamilyMember {
	
	private static final String id = "NeutralFamilyMember";
	
	public NeutralFamilyMember() {
		super(id);
	}
	
	@Override
	public NeutralFamilyMember clone(){
		NeutralFamilyMember clone = new NeutralFamilyMember();
		clone.dice = this.dice;
		clone.used = this.used;
		return clone;
	}
	@Override
	public boolean isNeutral() {
		return true;
	}

	@Override
	public NeutralFamilyMember getFrom(FamilyMemberManager familyMemberManager) {
		return familyMemberManager.getFamilyMember(id);
	}
}
