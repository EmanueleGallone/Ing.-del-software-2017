package provaGab.cranio.zones;

import provaGab.cranio.cards.DevelopmentCard;
import provaGab.cranio.familyMember.FamilyMember;

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
	
	public boolean placeFamilyMember(FamilyMember familyMember, int modifier){
		if(actionSpace.placeFamilyMember(familyMember, modifier)){
			return card.take(familyMember.getOwner());
		}
		return false;
	
	}
}
