package it.polimi.ingsw.ps11.cranio.zones.HarvestAndProduction;

import it.polimi.ingsw.ps11.cranio.resources.ResourceList;

public class Production extends CardAttivator {
	
	private ResourceList resourceList;
	
	public Production() {
		resourceList = new ResourceList();
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
