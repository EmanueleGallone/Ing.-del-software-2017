package it.polimi.ingsw.ps11.cranio.zones.actionSpace.pos;

import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;

public class SingleActionSpace extends ActionSpace {
	
	protected static final int DEFAULT_AVAILABLE_SPACE = 1;
	
	public SingleActionSpace() {
		super();
	}
	
	public SingleActionSpace(int cost) {
		super(cost);
	}
	
	public SingleActionSpace(ResourceList resources){
		super(resources);
	}
	
	public SingleActionSpace(int cost, ResourceList resources){
		super(cost, resources);
	}
	
	@Override
	public boolean addFamilyMember(FamilyMember familyMember, Player player) {
		if(familyMembers.size() < DEFAULT_AVAILABLE_SPACE){
			return super.addFamilyMember(familyMember,player);
		}
		return false;
	}
	
	@Override
	public boolean addFamilyMember(FamilyMemberSlot fSlot) {
		if(familyMembers.size() < DEFAULT_AVAILABLE_SPACE){
			return super.addFamilyMember(fSlot);
		}
		return false;
	}
	
	public FamilyMemberSlot getFamilyMember() {
		if(!familyMembers.isEmpty()){
			return familyMembers.get(0);
		}
		return null;
	}
}
