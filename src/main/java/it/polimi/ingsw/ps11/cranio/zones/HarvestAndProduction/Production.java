package it.polimi.ingsw.ps11.cranio.zones.HarvestAndProduction;

import it.polimi.ingsw.ps11.cranio.cards.CardManager;
import it.polimi.ingsw.ps11.cranio.cards.list.YellowCard;
import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;

public class Production extends CardAttivator {
	
	@Override
	protected void activeCard(FamilyMember familyMember) {
		CardManager cardManager = familyMember.getOwner().getCardManager();
		for(YellowCard card : cardManager.getCardList(YellowCard.class))
			if (card.getActiveValue() > familyMember.getValue())
				card.enablePermanentBonus();
			
		
	}
}
