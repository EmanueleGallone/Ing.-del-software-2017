package it.polimi.ingsw.ps11.cranio.zones.pos.decorator;

import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;

public class RewardedActionSpace extends ActionSpaceDecorator {
	
	protected ResourceList resources;

	public RewardedActionSpace(ActivableSpace activableSpace,ResourceList resources) {
		super(activableSpace);
		this.resources = resources;
	}
	
	@Override
	public boolean placeFamilyMember(FamilyMember familyMember) {
		if (super.placeFamilyMember(familyMember)){
			resources.sum(familyMember.getOwner());
			return true;
		}
		return false;
	}

}
