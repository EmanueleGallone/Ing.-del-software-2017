package it.polimi.ingsw.ps11.cranio.zones.ActionSpace;

import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;

public class ActionSpace implements FamilyMemberSpace{
	
	protected static final int DEFAULT_COST = 1;
	protected FamilyMember familyMember;
	protected Player owner;
	private int cost;
	private ResourceList resources; 
	
	
	public ActionSpace() {
		this(DEFAULT_COST);
	}
	
	public ActionSpace(int cost){
		this(cost,new ResourceList());
	}
	
	public ActionSpace(ResourceList resourceList){
		this.cost = DEFAULT_COST;
		this.resources = resourceList;
	}
	
	public ActionSpace(int cost, ResourceList resourceList){
		this.cost = cost;
		this.resources = new ResourceList();
	}

//Start setters
	
	public void setResources(ResourceList resourceList){
		this.resources = resourceList;
	}
	
	@Override
	public boolean placeFamilyMember(FamilyMember familyMember, Player player) {
		if(isFree()){
			this.familyMember = familyMember;
			this.owner = player;
			return true;
		}
		return false;
	}

// Getters
	
	public int getActionCost() {
		return cost;
	}
	
	public Player getOwner() {
		return owner;
	}
	public ResourceList getResources() {
		return resources;
	}
	
	public FamilyMember getFamilyMember() {
		return familyMember;
	}
	
	public boolean isFree(){
		if (familyMember == null)
			return true;
		return false;
	}



}
