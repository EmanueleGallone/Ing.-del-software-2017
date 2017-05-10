package it.polimi.ingsw.ps11.cranio.zones;

import pos.familyMembers.FamilyMember;

public class ActionSpace<RESOURCE_TYPE> {
	
	private static final int DEFAULT_COST = 1;
	private FamilyMember familyMember;
	private int cost;
	private RESOURCE_TYPE resource;
 	
// Start Constructors
// Con questi costruttori l'actionCost e' sempre definito, il familyMember invece può esseren null
	
	public ActionSpace() {
		this(DEFAULT_COST, null);
	}
	
	public ActionSpace(int cost){
		this(cost,null);
	}
	
	
	public ActionSpace(int cost,FamilyMember familyMember) {
		this.cost = cost;
		this.familyMember = familyMember;
	}
	
//End constructors
	//____________________________________________________________________________
//Start Logics
	
	public boolean isEmpty(){
		if (this.familyMember == null){
			return true;
		}
		return false;
	}
	
	public boolean placeFamilyMember(FamilyMember familyMember){
		if ( familyMember.getValue() > this.cost){
			this.familyMember = familyMember;
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
	protected void setFamilyMember(FamilyMember familyMember) {
		this.familyMember = familyMember;
	}
	
//End setters
//Start getters
	
	public int getActionCost() {
		return cost;
	}
	
	public FamilyMember getFamilyMember() {
		return familyMember;
	}
	
//End getters

}
