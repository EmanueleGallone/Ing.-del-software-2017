package pos.zones;

import pos.cards.Card;

public class Floors {
	
	private FamilyMemberSpace familyMemberSpace;
	private Card card;
	
	
	public Floors(FamilyMemberSpace familyMemberSpace) {
		this.familyMemberSpace = familyMemberSpace;
	}
	
	public Floors(FamilyMemberSpace familyMemberSpace, Card card) {
		this(familyMemberSpace);
		this.card = card;
	}
	
//Start getters
	public Card getCard() {
		return card;
	}
	public FamilyMemberSpace getFamilyMemberSpace() {
		return familyMemberSpace;
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
