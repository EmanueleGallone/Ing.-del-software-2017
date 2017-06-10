package it.polimi.ingsw.ps11.cranio.zones.actionSpace;

import java.util.ArrayList;
import java.util.Iterator;

import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;

public class ActionSpace implements Iterable<FamilyMember> {
	
	protected static final int DEFAULT_COST = 1;
	protected static final int DEFAULT_AVAILABLE_SPACE = 1;
	protected ArrayList<FamilyMember> familyMembers = new ArrayList<>();
	private int cost;
	private int availableSpace;
	private ResourceList resources; //Sarebbe meglio un arrayList, poi vediamo
	
	
// Start Constructors
	
	public ActionSpace() {
		this(DEFAULT_COST);
	}
	
	public ActionSpace(int cost){
		this(cost,DEFAULT_AVAILABLE_SPACE);
	}
	
	public ActionSpace(int cost,int availableSpace){
		this.cost = cost;
		this.availableSpace = availableSpace;
		resources = new ResourceList();
	}
	
	public ActionSpace(ResourceList resources){
		this();
		this.resources = resources;
	}
	
	public ActionSpace(int cost, ResourceList resources){
		this(cost);
		this.resources = resources;
	}
	

//Start setters
	
	public void setResources(ResourceList resourceList){
		this.resources = resourceList;
	}
	
	public boolean addFamilyMember(FamilyMember familyMember) {
		if (isFree())
			return this.familyMembers.add(familyMember);
		return false;
	}
	

// Getters
	
	public int getActionCost() {
		return cost;
	}
	
	public ResourceList getResources() {
		return resources;
	}
	
	public ArrayList<FamilyMember> getFamilyMembers() {
		return familyMembers;
	}
	
	public boolean isFree(){
		if(this.familyMembers.size() <= availableSpace)
			return true;
		
		return false;
	}
	
// Setters	

	public void setAvailableSpace(int availableSpace) {
		this.availableSpace = availableSpace;
	}
	
// Iterator

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
