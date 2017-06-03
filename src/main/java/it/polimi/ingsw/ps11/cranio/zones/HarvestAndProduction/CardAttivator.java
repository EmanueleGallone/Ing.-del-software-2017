package it.polimi.ingsw.ps11.cranio.zones.HarvestAndProduction;

import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.zones.actionSpace.ActionSpace;

public abstract class CardAttivator{
	
	protected static final int DEFAULT_COST = 3; // Il costo per il multiple space
	protected ActionSpace actionSpace;
	protected ActionSpace multipleActionSpace;
	
	public CardAttivator() {
		actionSpace = new ActionSpace();
		multipleActionSpace = new ActionSpace(DEFAULT_COST);
	}
	
	public CardAttivator(int actionSpaceCost, int multipleActionSpaceCost) {
		actionSpace = new ActionSpace(actionSpaceCost);
		multipleActionSpace = new ActionSpace(multipleActionSpaceCost);
	}
	
// End constructors

	/*
	@Override
	public boolean placeFamilyMember(FamilyMember familyMember) {
		if (actionSpace.placeFamilyMember(familyMember)){
			return true;
		}
		return false;
	}
	
	public boolean placeInMultipleSpace(FamilyMember familyMember) {
		if (actionSpace.placeFamilyMember(familyMember)){
			familyMember.setModifier(-DEFAULT_COST);
			activeCard(familyMember);
			return true;
		}
		return false;
	}
	}
	*/
	
	protected abstract void activeCard(FamilyMember familyMember);
	
}
