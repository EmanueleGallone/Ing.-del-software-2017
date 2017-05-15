package it.polimi.ingsw.ps11.cranio.zones.actionSpace;

import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;
import it.polimi.ingsw.ps11.cranio.zones.actionSpace.ActionSpace;

public class Floor extends ActionSpace {
	
	private DevelopmentCard card;
	
// Start constructors
	
	public Floor() {
		super();
	}
	
	public Floor(int cost){
		super(cost);
	}
	
	public Floor(DevelopmentCard card){
		super();
		this.card = card;
	}
	
	public Floor(ResourceList resources){
		super(resources);
	}
	
	public Floor(int cost, ResourceList resources){
		super(cost,resources);
	}
	
	public Floor(int cost,DevelopmentCard card){
		super(cost);
		this.card = card;
	}
	
// End constructors
// Start logic
	
	@Override
	public boolean placeFamilyMember(FamilyMember familyMember) {
		 if(super.placeFamilyMember(familyMember)){
			 this.card.take(familyMember.getOwner());
			 return true;
		 }
		 return false;
	}
	
// End logic
//Start getter
	public DevelopmentCard getCard() {
		return card;
	}
	
}
