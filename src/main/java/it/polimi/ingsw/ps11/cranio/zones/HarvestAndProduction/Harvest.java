package it.polimi.ingsw.ps11.cranio.zones.HarvestAndProduction;

import it.polimi.ingsw.ps11.cranio.cards.CardManager;
import it.polimi.ingsw.ps11.cranio.cards.list.GreenCard;
import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;

public class Harvest extends CardAttivator {
	
	@Override
	protected void activeCard(FamilyMember familyMember) {
		CardManager cardManager = familyMember.getOwner().getCardManager();
		for(GreenCard card : cardManager.getCardList(GreenCard.class)){
			if (card.getActiveValue() > familyMember.getValue()){
				card.enablePermanentBonus();
			}
		}
	}

}
