package it.polimi.ingsw.ps11.cranio.zones.pos.decorator;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;

public abstract class ActionSpaceDecorator implements ActivableSpace{

	protected ActivableSpace activableSpace;
	
	public ActionSpaceDecorator(ActivableSpace activableSpace) {
		this.activableSpace = activableSpace;
	}
	
	@Override
	public boolean placeFamilyMember(FamilyMember familyMember) {
		return activableSpace.placeFamilyMember(familyMember);
	}
	
	@Override
	public ArrayList<FamilyMember> getFamilyMembers() {
		return activableSpace.getFamilyMembers();
	}

}
