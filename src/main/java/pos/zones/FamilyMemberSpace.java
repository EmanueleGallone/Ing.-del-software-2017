package pos.zones;

import pos.Resources.FamilyMember;

public class FamilyMemberSpace {
	
	private static final int DEFAULT_COST = 1;
	private FamilyMember familyMember;
	private int actionCost;
	
	
// Start Constructors
// Con questi costruttori l'actionCost e' sempre definito, il familyMember invece può esseren null
	public FamilyMemberSpace(int actionCost,FamilyMember familyMember) {
		this.actionCost = actionCost;
		this.familyMember = familyMember;
	}
	
	public FamilyMemberSpace(FamilyMember familyMember){
		this(DEFAULT_COST,familyMember);
	}
	
	public FamilyMemberSpace() {
		this(DEFAULT_COST, null);
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
		if ( familyMember.getValue() > this.actionCost){
			this.familyMember = familyMember;
			return true;
		}
		return false;
	}
	
//End logics
	//____________________________________________________________________________
//Start setters

	public void setActionCost(int actionCost) { //Forse è superfluo, una zona ha un costo fisso
		this.actionCost = actionCost;
	}
	protected void setFamilyMember(FamilyMember familyMember) {
		this.familyMember = familyMember;
	}
	
//End setters
//Start getters
	
	public int getActionCost() {
		return actionCost;
	}
	
	public FamilyMember getFamilyMember() {
		return familyMember;
	}
	
//End getters

}
