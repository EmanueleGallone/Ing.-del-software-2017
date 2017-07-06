package it.polimi.ingsw.ps11.model.gameLogics.actions.affecter;

import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInSpaceAction;

public class FixFamilyValue extends FamilyInSpaceAffecter {

	public FixFamilyValue(String familyType, int fixedValue) {
		super(familyType, fixedValue);
	}

	@Override
	public FamilyInSpaceAction affect(FamilyInSpaceAction action) {
		FamilyInSpaceAction newAction = action.clone();
		int currentValue = newAction.getFamilyMember().getValue();
		int difference = this.value - currentValue;
		newAction.getFamilyMember().setModifier(difference);
		return newAction;
	}
}
