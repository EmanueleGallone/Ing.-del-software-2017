package it.polimi.ingsw.ps11.cranio.zones.HarvestAndProduction;

import it.polimi.ingsw.ps11.cranio.cards.CardManager;
import it.polimi.ingsw.ps11.cranio.cards.productionCard.GreenCard;
import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;

public class Harvest extends CardAttivator {

	public Harvest() {
		
	}

	/*
	@Override
	protected void activeCard(FamilyMember familyMember) {
		CardManager cardManager = familyMember.getOwner().getCardManager();
		for(GreenCard card : cardManager.getCard(GreenCard.class)){
			if (card.getActiveValue() > familyMember.getValue()){
				card.enablePermanentBonus();
			}
		}
	}
	*/
}
