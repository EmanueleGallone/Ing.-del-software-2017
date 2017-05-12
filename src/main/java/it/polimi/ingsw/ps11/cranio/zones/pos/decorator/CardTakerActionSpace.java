package it.polimi.ingsw.ps11.cranio.zones.pos.decorator;

import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;

public class CardTakerActionSpace extends ActionSpaceDecorator {

	protected DevelopmentCard card;
	
	public CardTakerActionSpace(ActivableSpace activableSpace,DevelopmentCard card) {
		super(activableSpace);
		this.card = card;
	}
	
	@Override
	public boolean placeFamilyMember(FamilyMember familyMember) {
		if(super.placeFamilyMember(familyMember)){
			this.card.take(familyMember.getOwner());
			return true;
		}
		return false; 
	}

}
