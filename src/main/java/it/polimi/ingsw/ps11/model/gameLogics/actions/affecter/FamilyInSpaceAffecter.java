package it.polimi.ingsw.ps11.model.gameLogics.actions.affecter;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Affecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInSpaceAction;

public class FamilyInSpaceAffecter implements Affecter<FamilyInSpaceAction> {

	private String familyType;
	private int value;
	
	public FamilyInSpaceAffecter(String familyType, int value) {
		this.value = value;
		this.familyType = familyType;
	}
	
	@Override
	public Class<FamilyInSpaceAction> target() {
		return FamilyInSpaceAction.class;
	}

	@Override
	public FamilyInSpaceAction affect(FamilyInSpaceAction action) {
		FamilyInSpaceAction newAction = action.clone();
		FamilyMember familyMember = newAction.getFamilyMember();
		if(familyMember.getClass().toString().equals(familyType))
			familyMember.setModifier(familyMember.getModifier() + value);
		return newAction;
	}

}
