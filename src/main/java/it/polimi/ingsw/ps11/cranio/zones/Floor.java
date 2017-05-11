package it.polimi.ingsw.ps11.cranio.zones;

import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;

public class Floor {
	
	private ActionSpace actionSpace;
	private DevelopmentCard card;
	
	public Floor(ActionSpace actionSpace){
		this.actionSpace = actionSpace;
	
	}
	
	public Floor(ActionSpace actionSpace,DevelopmentCard card){
		this(actionSpace);
		this.card = card;
	}
	
	public DevelopmentCard getCard() {
		return card;
	}
	
	public ActionSpace getActionSpace() {
		return actionSpace;
	}
	
	public boolean placeFamilyMember(FamilyMember familyMember){
		if(actionSpace.placeFamilyMember(familyMember)){
			return card.take(familyMember.getOwner());
		}
		return false;
	
	}
}
