package it.polimi.ingsw.ps11.cranio.zones.pos.decorator;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;

public class ActionSpace implements ActivableSpace {
	
	private ArrayList<FamilyMember> familyMembers = new ArrayList<>();
	
	@Override
	public boolean placeFamilyMember(FamilyMember familyMember) {
		return this.familyMembers.add(familyMember);
	}

	@Override
	public ArrayList<FamilyMember> getFamilyMembers() {
		return familyMembers;
	}
}
