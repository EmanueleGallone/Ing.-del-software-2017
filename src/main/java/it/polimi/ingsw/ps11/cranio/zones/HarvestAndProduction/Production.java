package it.polimi.ingsw.ps11.cranio.zones.HarvestAndProduction;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.cards.CardManager;
import it.polimi.ingsw.ps11.cranio.cards.productionCard.GreenCard;
import it.polimi.ingsw.ps11.cranio.cards.productionCard.YellowCard;
import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;

public class Production extends CardAttivator {
	
	private ResourceList resourceList;
	
	public Production() {
		resourceList = new ResourceList();
		resourceList.setAllToZeroValue();

	}

	@Override
	public String toString() {
		return "Production [resourceList=" + resourceList 
				+ ", actionSpace=" + actionSpace 
				+ "]";
	}
	
	
	
	
	/*
	@Override
	protected void activeCard(FamilyMember familyMember) {
		CardManager cardManager = familyMember.getOwner().getCardManager();
		for(YellowCard card : cardManager.getCard(YellowCard.class)){
			if (card.getActiveValue() > familyMember.getValue()){
				card.enablePermanentBonus();
			}
		}
	}
	*/
}
