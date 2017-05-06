package pos.zones;

import java.util.ArrayList;

import pos.cards.Card;
import pos.cards.Cards;
import pos.familyMembers.FamilyMember;

public class ActivableZone {
	
	private final static int MULTIPLE_SPACE_COST = 3;
	private FamilyMemberSpace singleSpace = new FamilyMemberSpace();
	private ArrayList<FamilyMemberSpace> multipleSpace = new ArrayList<>();
	private Cards whichCard;
	
	public ActivableZone(Cards whichCard) {
		this.whichCard = whichCard;
	}
	
	public boolean placeInSingleArea(FamilyMember familyMember){
		
		if (singleSpace.placeFamilyMember(familyMember)){
			ActiveCards(familyMember);
			return true;
		}
		return false;
	}
	
	public boolean placeInMultipleArea(FamilyMember familyMember){
		FamilyMemberSpace newFamilyMemberSpace = new FamilyMemberSpace(MULTIPLE_SPACE_COST);
		if(newFamilyMemberSpace.placeFamilyMember(familyMember)){
			multipleSpace.add(newFamilyMemberSpace);
			ActiveCards(familyMember);
			return true;
		}
		return false;
	}
	
	protected void ActiveCards(FamilyMember familyMember){
		for(Card card : familyMember.getOwner().getCardsByType(whichCard)){
			card.active();
		}
	}
	
}
