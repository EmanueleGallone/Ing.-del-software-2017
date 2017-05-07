package pos.events.event;

import pos.cards.Card;
import pos.familyMembers.FamilyMember;

public class FamilyCardCheckEvent {
	
	private Card card;
	private FamilyMember familyMember;
	
	public FamilyCardCheckEvent(Card card, FamilyMember familyMember) {
		this.card = card;
		this.familyMember = familyMember;
	}
	
	public Card getCard() {
		return card;
	}
	public FamilyMember getFamilyMember() {
		return familyMember;
	}
}
