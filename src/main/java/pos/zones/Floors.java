package pos.zones;

import pos.cards.Card;
import pos.events.EventHandler;
import pos.events.event.FamilyCardCheckEvent;
import pos.familyMembers.FamilyMember;

public class Floors {
	
	private FamilyMemberSpace familyMemberSpace;
	private Card card;
	
	private static EventHandler<FamilyCardCheckEvent> preFamilyMemberCheck = new EventHandler<>();
	
	public Floors(FamilyMemberSpace familyMemberSpace) {
		this.familyMemberSpace = familyMemberSpace;
	}
	
	public Floors(FamilyMemberSpace familyMemberSpace, Card card) {
		this(familyMemberSpace);
		this.card = card;
	}
	
//Start Logics
	
	public boolean placeFamilyMember(FamilyMember familyMember){
		preFamilyMemberCheck.invoke(new FamilyCardCheckEvent(card, familyMember));
		boolean result = familyMemberSpace.placeFamilyMember(familyMember);
		familyMember.resetModifier();
		return result;
	}
	
//End Logics
	

//Start getters
	public Card getCard() {
		return card;
	}
	public FamilyMemberSpace getFamilyMemberSpace() {
		return familyMemberSpace;
	}
	
	public static EventHandler<FamilyCardCheckEvent> getPreFamilyMemberCheck() {
		return preFamilyMemberCheck;
	}
//End getters
	//____________________________________________________________________________
//Start setters
	public void setCard(Card card) {
		this.card = card;
	}
	private void setFamilyMemberSpace(FamilyMemberSpace familyMemberSpace) {
		this.familyMemberSpace = familyMemberSpace;
	}
//End setters
	
}
