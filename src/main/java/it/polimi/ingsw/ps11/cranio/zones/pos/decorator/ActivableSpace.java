package it.polimi.ingsw.ps11.cranio.zones.pos.decorator;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;

public interface ActivableSpace {
	public boolean placeFamilyMember(FamilyMember familyMember);
	public ArrayList<FamilyMember> getFamilyMembers();
}
