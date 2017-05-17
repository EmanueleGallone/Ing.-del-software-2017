package it.polimi.ingsw.ps11.cranio.zones.HarvestAndProduction;

import it.polimi.ingsw.ps11.cranio.cards.CardManager;
import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.cranio.zones.actionSpace.ActivableSpace;
import it.polimi.ingsw.ps11.cranio.zones.actionSpace.MultipleActionSpace;

public abstract class CardAttivator implements ActivableSpace {
	
	protected static final int DEFAULT_COST = 3; // Il costo per il multiple space
	protected ActionSpace actionSpace;
	protected MultipleActionSpace multipleActionSpace;
	protected Class<? extends DevelopmentCard> cardType;
	
	public CardAttivator(Class<? extends DevelopmentCard> cardType) {
		actionSpace = new ActionSpace();
		multipleActionSpace = new MultipleActionSpace(DEFAULT_COST);
		this.cardType = cardType;
	}
	
	public CardAttivator(int actionSpaceCost, int multipleActionSpaceCost) {
		actionSpace = new ActionSpace(actionSpaceCost);
		multipleActionSpace = new MultipleActionSpace(multipleActionSpaceCost);
	}

	@Override
	public boolean placeFamilyMember(FamilyMember familyMember) {
		if (actionSpace.placeFamilyMember(familyMember)){
			activeCard(familyMember.getOwner().getCardManager());
		}
		return false;
	}
	
	protected void activeCard(CardManager cardManager){
		for(DevelopmentCard card : cardManager.getCard(cardType)){
			
		}
	}
}
