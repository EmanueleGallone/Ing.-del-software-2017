package it.polimi.ingsw.ps11.model.cards.effects;

import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.affecter.FixFamilyValue;

public class FixFamilyValueEffect extends FamilyInSpaceBonus {

	public FixFamilyValueEffect(String familyType, int value) {
		super(familyType, value);
	}

	@Override
	public void attach(ActionManager aManager) {
		FixFamilyValue affecter = new FixFamilyValue(familyType, value);
		aManager.add(affecter);
	}
}
