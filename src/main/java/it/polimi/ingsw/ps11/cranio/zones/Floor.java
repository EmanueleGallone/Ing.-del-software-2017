package it.polimi.ingsw.ps11.cranio.zones;

import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;
import it.polimi.ingsw.ps11.cranio.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.cranio.zones.actionSpace.ActivableSpace;

public class Floor implements ActivableSpace {
	
	private DevelopmentCard card;
	private ActionSpace actionSpace;
	
// Start constructors
	
	public Floor() {
		actionSpace = new ActionSpace();
	}
	
	public Floor(int cost){
		actionSpace = new ActionSpace(cost);
	}
	
	public Floor(DevelopmentCard card){
		this();
		this.card = card;
	}
	
	public Floor(int cost, ResourceList resources){
		actionSpace = new ActionSpace(cost,resources);
	}
	
// End constructors
// Start logic
	
	@Override
	public boolean placeFamilyMember(FamilyMember familyMember) {
		 if(actionSpace.placeFamilyMember(familyMember)){
			 return true;
		 }
		 return false;
	}
	
	public boolean getCard(FamilyMember familyMember, ResourceList cost){
		if (placeFamilyMember(familyMember)){
			return card.take(familyMember.getOwner(), cost);
		}
		return false;
	}
	
// End logic
// Start setters
	
	public void setCard(DevelopmentCard card){
		this.card = card;
	}
	
// End setters
// Start getters
	
	public <T extends DevelopmentCard> T getCard() {
		return (T) card;
	}
	
	public Class<? extends DevelopmentCard> getType(){
		return this.card.getClass();
	}
	
// End getters
}
