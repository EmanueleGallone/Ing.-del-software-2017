package pos.zones;

import java.util.ArrayList;

import pos.cards.Card;
import pos.cards.Cards;
import pos.events.EventHandler;
import pos.events.EventListener;
import pos.events.event.FamilyCardCheckEvent;
import pos.events.event.FamilyZoneCheckEvent;
import pos.familyMembers.FamilyMember;
import pos.players.Player;

public class ActivableZone {
	
	private final static int MULTIPLE_SPACE_COST = 3;
	private ActivableZones type;
	
	private FamilyMemberSpace singleSpace = new FamilyMemberSpace();
	private ArrayList<FamilyMemberSpace> multipleSpace = new ArrayList<>();
	private Cards whichCard;
	
	EventHandler<FamilyZoneCheckEvent> familyZoneCheckEvent = new EventHandler<>();
	
	EventListener<Void> clearAtTurnEnd = new EventListener<Void>() {
		@Override
		public void handle(Void event) {
			singleSpace = new FamilyMemberSpace();
			multipleSpace.clear();
		}
	};
	
//Start constructors
	
	public ActivableZone(ActivableZones type,Cards whichCard) {
		this.whichCard = whichCard;
		this.type = type;
		//Bisogna attaccare l'evento "clearAtTurnEnd" a chi invoca l'evento "TurnEnd"
	}
	
//End constructors

	
	public boolean placeInSingleArea(FamilyMember familyMember){
		if (checkFamilyMemberValue(singleSpace, familyMember)){
			ActiveCards(familyMember.getOwner());
			return true;
		}
		familyMember.resetModifier();
		return false;
	}
	
	public boolean placeInMultipleArea(FamilyMember familyMember){
		FamilyMemberSpace newFamilyMemberSpace = new FamilyMemberSpace(MULTIPLE_SPACE_COST);
		if(checkFamilyMemberValue(newFamilyMemberSpace, familyMember)){
			multipleSpace.add(newFamilyMemberSpace);
			ActiveCards(familyMember.getOwner());
			return true;
		}
		return false;
	}
	
	private boolean checkFamilyMemberValue(FamilyMemberSpace familyMemberSpace, FamilyMember familyMember){
		familyZoneCheckEvent.invoke(new FamilyZoneCheckEvent(this.type, familyMember));
		boolean esito = familyMemberSpace.placeFamilyMember(familyMember);
		familyMember.resetModifier();
		return esito;
	}
	
	public EventHandler<FamilyZoneCheckEvent> getFamilyZoneCheckEvent() {
		return familyZoneCheckEvent;
	}
	
	public void ActiveCards(Player player){
		for(Card card : player.getCardsByType(whichCard)){
			card.active();
		}
	}
	
}
