package it.polimi.ingsw.ps11.cranio.zones.actionSpace.pos;

import java.util.ArrayList;
import java.util.Iterator;

import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;

public class ActionSpace implements Iterable<FamilyMemberSlot> {
	
	protected static final int DEFAULT_COST = 1;
	protected ArrayList<FamilyMemberSlot> familyMembers = new ArrayList<>();
	private int cost;
	private ResourceList resources; //Sarebbe meglio un arrayList, poi vediamo
	
	
// Start Constructors
	
	public ActionSpace() {
		this(DEFAULT_COST);
	}
	
	public ActionSpace(int cost) {
		this.cost = cost;
		this.resources = new ResourceList();
	}
	
	public ActionSpace(ResourceList resources){
		this();
		this.resources = resources;
	}
	
	public ActionSpace(int cost, ResourceList resources){
		this(cost);
		this.resources = resources;
	}
	

// Getters
	
	public int getActionCost() {
		return cost;
	}
	
	public ResourceList getResources() {
		return resources;
	}
	
	public ArrayList<FamilyMemberSlot> getFamilyMembers() {
		return familyMembers;
	}
	
// Setters	

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public void setResources(ResourceList resourceList){
		this.resources = resourceList;
	}
	
// Logics
	
	public boolean addFamilyMember(FamilyMember familyMember, Player player) {
		return this.familyMembers.add(new FamilyMemberSlot(player, familyMember));
	}
	
	public boolean addFamilyMember(FamilyMemberSlot fSlot) {
		return this.familyMembers.add(fSlot);
	}
	
	
	public void clear(){
		this.familyMembers.clear();
	}
	
// __________________________

	@Override
	public Iterator<FamilyMemberSlot> iterator() {
		return familyMembers.iterator();
	}

	@Override
	public String toString() {
		return "MultipleActionSpace [familyMembers=" + familyMembers 
				+ ", cost=" + cost 
				+ ", resources=" + resources
				+ "]";
	}

	
	
	
}
