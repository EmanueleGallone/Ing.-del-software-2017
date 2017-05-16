package it.polimi.ingsw.ps11.cranio.zones.actionSpace;

import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;

public class ActionSpace extends MultipleActionSpace {
	
	private final int MAX_AVAILABLE_SPACE = 1; 
	
	public ActionSpace() {
		super(DEFAULT_COST);
	}
	
	public ActionSpace(int cost){
		super(cost);
	}
	
	public ActionSpace(ResourceList resources){
		super(resources);
	}
	
	public ActionSpace(int cost, ResourceList resources){
		super(cost,resources);
	}
	
// Start logic
	
	@Override
	public boolean placeFamilyMember(FamilyMember familyMember) {
		if (familyMembers.size() > MAX_AVAILABLE_SPACE ){
			return false;
		}
		return super.placeFamilyMember(familyMember);
	}
	
	
	/*
	 Il get family member è meglio evitarlo perchè dovremmo prevedere il caso in cui 
	  il familyMember sia null
	*/
	
// End logic

}
