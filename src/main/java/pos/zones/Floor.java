package pos.zones;

import pos.cards.Card;
import pos.cards.Cards;
import pos.events.Event;
import pos.events.EventHandler;
import pos.familyMembers.FamilyMember;

public class Floor {
	
	private FamilyMemberSpace familyMemberSpace;
	private Card card;
	
	private static EventHandler<Event<Cards, FamilyMember>> preFamilyMemberCheck = new EventHandler<>();
	//Potrebbe essere sostituito con una mappa con EventType -> eventhandler
	
	
	public Floor(FamilyMemberSpace familyMemberSpace) {
		this.familyMemberSpace = familyMemberSpace;
	}
	
	public Floor(FamilyMemberSpace familyMemberSpace, Card card) {
		this(familyMemberSpace);
		this.card = card;
	}
	
//Start Logics
	
	public boolean placeFamilyMember(FamilyMember familyMember){
		preFamilyMemberCheck.invoke(new Event<Cards, FamilyMember>(card.getType(), familyMember) );
		boolean result = familyMemberSpace.placeFamilyMember(familyMember);
		familyMember.resetModifier();//Questa riga va sostituita con l'invocazione di un post event
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
	
	public static EventHandler<Event<Cards, FamilyMember>> getPreFamilyMemberCheck() {
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
