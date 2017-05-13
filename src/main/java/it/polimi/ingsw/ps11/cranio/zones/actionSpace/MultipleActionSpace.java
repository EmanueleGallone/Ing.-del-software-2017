package it.polimi.ingsw.ps11.cranio.zones.actionSpace;

import java.util.ArrayList;
import java.util.Iterator;

import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;

public class MultipleActionSpace implements ActivableSpace,Iterable<FamilyMember> {
	protected static final int DEFAULT_COST = 1;
	protected ArrayList<FamilyMember> familyMembers;
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
	
	public boolean placeFamilyMember(FamilyMember familyMember){
		if ( familyMember.getValue() > this.cost){
			this.addFamilyMember(familyMember); 
			resources.sum(familyMember.getOwner()); //Assegna al player le risorse dell'actionSpace
			return true;
		}
		return false;
	}
	
//End logics
	//____________________________________________________________________________
//Start setters

	public void setActionCost(int actionCost) { //Forse è superfluo, una zona ha un costo fisso
		this.cost = actionCost;
	}
	protected boolean addFamilyMember(FamilyMember familyMember) {
		return this.familyMembers.add(familyMember);
	}
	
//End setters
//Start getters
	
	public int getActionCost() {
		return cost;
	}
	
//End getters
//Start iterator

	@Override
	public Iterator<FamilyMember> iterator() {
		return familyMembers.iterator();
	}
	
//End iterator
}
