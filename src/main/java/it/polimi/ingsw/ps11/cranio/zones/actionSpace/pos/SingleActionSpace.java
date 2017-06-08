package it.polimi.ingsw.ps11.cranio.zones.actionSpace.pos;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
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
	public boolean addFamilyMember(FamilyMember familyMember) {
		if(familyMembers.size() < DEFAULT_AVAILABLE_SPACE){
			return super.addFamilyMember(familyMember);
		}
		return false;
	}
	
	public FamilyMember getFamilyMember() {
		if(!familyMembers.isEmpty()){
			return familyMembers.get(0);
		}
		return null;
	}
}
