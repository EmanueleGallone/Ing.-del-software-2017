package it.polimi.ingsw.ps11.cranio.zones.actionSpace;

import java.util.ArrayList;
import java.util.Iterator;

import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;

public class MultipleActionSpace implements ActivableSpace,Iterable<FamilyMember> {
	
	protected static final int DEFAULT_COST = 1;
	protected ArrayList<FamilyMember> familyMembers = new ArrayList<>();
	private int cost;
	private ResourceList resources;
	
	
// Start Constructors
	
	public MultipleActionSpace() {
		this(DEFAULT_COST);
	}
	
	public MultipleActionSpace(int cost){
		this.cost = cost;
		resources = new ResourceList();
	}
	
	public MultipleActionSpace(ResourceList resources){
		this();
		this.resources = resources;
	}
	
	public MultipleActionSpace(int cost, ResourceList resources){
		this(cost);
		this.resources = resources;
	}
	
	
//End constructors
	//____________________________________________________________________________
//Start Logics
	
	@Override
	public boolean placeFamilyMember(FamilyMember familyMember){
		if ( familyMember.getValue() > this.cost){
			this.addFamilyMember(familyMember); 
			familyMember.getOwner().getResourceList().sum(this.resources); //Assegna al player le risorse dell'actionSpace
			return true;
		}
		return false;
	}
	
//End logics
	//____________________________________________________________________________
//Start setters
	
	public void setResources(ResourceList resourceList){
		this.resources = resourceList;
	}
	
	protected boolean addFamilyMember(FamilyMember familyMember) {
		return this.familyMembers.add(familyMember);
	}
	
//End setters
//Start getters
	
	public int getActionCost() {
		return cost;
	}
	
	public ResourceList getResources() {
		return resources;
	}
	
//End getters
//Start iterator

	@Override
	public Iterator<FamilyMember> iterator() {
		return familyMembers.iterator();
	}

	@Override
	public String toString() {
		return "MultipleActionSpace [familyMembers=" + familyMembers 
				+ ", cost=" + cost 
				+ ", resources=" + resources
				+ "]";
	}
	
//End iterator
	
	
	
}
