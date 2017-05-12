package it.polimi.ingsw.ps11.cranio.zones.pos.decorator;

import it.polimi.ingsw.ps11.cranio.cards.Deck;
import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;

public class CardsAttivatorActionSpace extends ActionSpaceDecorator{

	
	protected Deck<DevelopmentCard> deck = new Deck<>();
	
	public CardsAttivatorActionSpace(ActivableSpace activableSpace,Deck<DevelopmentCard> deck) {
		super(activableSpace);
		this.deck = deck;
	}
	
	@Override
	public boolean placeFamilyMember(FamilyMember familyMember) {
		if (super.placeFamilyMember(familyMember)){
			activeCards(this.deck);
			return true;
		}
		return false;
	}
	
	protected void activeCards(Deck<DevelopmentCard> deck){
		for(DevelopmentCard card : deck){
			card.activePermanentEffect();
		}
	}

}
