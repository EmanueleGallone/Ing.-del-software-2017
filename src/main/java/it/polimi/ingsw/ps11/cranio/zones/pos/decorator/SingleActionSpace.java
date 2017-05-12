package it.polimi.ingsw.ps11.cranio.zones.pos.decorator;

import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;

public class SingleActionSpace extends ActionSpaceDecorator{
	
	private final int MAX_AVAILABLE_SPACE = 1;
	
	public SingleActionSpace(ActivableSpace activableSpace) {
		super(activableSpace);
	}
	
	@Override
	public boolean placeFamilyMember(FamilyMember familyMember) {
		if (activableSpace.getFamilyMembers().size() < MAX_AVAILABLE_SPACE){
			activableSpace.placeFamilyMember(familyMember);
			return true;
		}
		return false;
	}

}
