package it.polimi.ingsw.ps11.cranio.zones;

import java.util.ArrayList;

import pos.cards.Card;
import pos.cards.Cards;
import pos.events.Event;
import pos.events.EventHandler;
import pos.events.EventListener;
import pos.familyMembers.FamilyMember;
import pos.games.Player;

public class CardsAttivatorZone {
	
	private final static int MULTIPLE_SPACE_COST = 3;
	
	private ActionSpace singleSpace = new ActionSpace();
	private ArrayList<ActionSpace> multipleSpace = new ArrayList<>();
	private Cards cardType;
	
	EventHandler<Event<Cards, FamilyMember>> preFamilyMemberCheck = new EventHandler<>();
	
	EventListener<Void> clearAtTurnEnd = new EventListener<Void>() {
		@Override
		public void handle(Void event) {
			singleSpace = new ActionSpace();
			multipleSpace.clear();
		}
	};
	
//Start constructors
	
	public CardsAttivatorZone(Cards whichCard,ActionSpace familyMemberSpace) {
		this.cardType = whichCard;
		this.singleSpace = familyMemberSpace;
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
		ActionSpace newFamilyMemberSpace = new ActionSpace(MULTIPLE_SPACE_COST);
		if(checkFamilyMemberValue(newFamilyMemberSpace, familyMember)){
			multipleSpace.add(newFamilyMemberSpace);
			ActiveCards(familyMember.getOwner());
			return true;
		}
		return false;
	}
	
	private boolean checkFamilyMemberValue(ActionSpace familyMemberSpace, FamilyMember familyMember){
		preFamilyMemberCheck.invoke(new Event<Cards, FamilyMember>(this.cardType, familyMember));
		boolean esito = familyMemberSpace.placeFamilyMember(familyMember);
		familyMember.resetModifier();
		return esito;
	}
	
	public EventHandler<Event<Cards, FamilyMember>> getPreFamilyMemberCheck() {
		return preFamilyMemberCheck;
	}
	
	public void ActiveCards(Player player){
		for(Card card : player.getCardsByType(cardType)){
			card.active();
		}
	}
	
}