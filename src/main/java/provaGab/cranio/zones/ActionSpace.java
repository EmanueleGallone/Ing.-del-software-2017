package provaGab.cranio.zones;

import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;

import provaGab.cranio.cards.GreenCard;
import provaGab.cranio.familyMember.FamilyMember;
import provaGab.cranio.player.Player;
import provaGab.cranio.resources.ResourceList;

public class ActionSpace {
	
	private static final int DEFAULT_COST = 1;
	private FamilyMember familyMember;
	private int cost;
	private ResourceList resources;
// Start Constructors
// Con questi costruttori l'actionCost e' sempre definito, il familyMember invece può esseren null
	
	public ActionSpace() {
		this(DEFAULT_COST);
		resources = new ResourceList();
	}
	
	
	public ActionSpace(int cost){
		this.cost = cost;
	}
	
	
	public ActionSpace(int cost, ResourceList resources){
		this(cost);
		this.resources = resources;
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
	
	public boolean placeFamilyMember(FamilyMember familyMember, int modifier){
		if ( familyMember.getValue() + modifier > this.cost){
			this.setFamilyMember(familyMember);
			System.out.println("\nRiuscito");
			return true;
		}
		System.err.println("\nNon riuscito");
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
	
	public void activateHarvest(FamilyMember familyMember){
		Player Caller = familyMember.getOwner();
		for(GreenCard card: Caller.getCardManager().getGreenDeck()){
			activateHarvest(familyMember);
		}
	}
//End getters

}
