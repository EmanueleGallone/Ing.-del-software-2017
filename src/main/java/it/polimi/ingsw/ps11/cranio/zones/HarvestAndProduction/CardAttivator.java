package it.polimi.ingsw.ps11.cranio.zones.HarvestAndProduction;

import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.cranio.zones.actionSpace.ActivableSpace;
import it.polimi.ingsw.ps11.cranio.zones.actionSpace.MultipleActionSpace;

public abstract class CardAttivator implements ActivableSpace {
	
	protected static final int DEFAULT_COST = 3; // Il costo per il multiple space
	protected ActionSpace actionSpace;
	protected MultipleActionSpace multipleActionSpace;
	
	public CardAttivator() {
		actionSpace = new ActionSpace();
		multipleActionSpace = new MultipleActionSpace(DEFAULT_COST);
	}
	
	public CardAttivator(int actionSpaceCost, int multipleActionSpaceCost) {
		actionSpace = new ActionSpace(actionSpaceCost);
		multipleActionSpace = new MultipleActionSpace(multipleActionSpaceCost);
	}

	@Override
	public boolean placeFamilyMember(FamilyMember familyMember) {
		if (actionSpace.placeFamilyMember(familyMember)){
			return true;
		}
		return false;
	}
	
	public boolean placeInMultipleSpace(FamilyMember familyMember) {
		if (actionSpace.placeFamilyMember(familyMember)){
			FamilyMember f = familyMember.clone();
			f.setValue(f.getValue() - DEFAULT_COST);
			return true;
		}
		return false;
	}
	
}
