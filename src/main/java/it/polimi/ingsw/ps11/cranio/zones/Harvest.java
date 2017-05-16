package it.polimi.ingsw.ps11.cranio.zones;

import it.polimi.ingsw.ps11.cranio.cards.Deck;
import it.polimi.ingsw.ps11.cranio.cards.list.GreenCard;
import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.cranio.zones.actionSpace.ActivableSpace;
import it.polimi.ingsw.ps11.cranio.zones.actionSpace.MultipleActionSpace;

public class Harvest implements ActivableSpace {
	
	protected static final int DEFAULT_COST = 3; // Il costo per il multiple space
	protected ActionSpace actionSpace;
	protected MultipleActionSpace multipleActionSpace;
	
	public Harvest() {
		actionSpace = new ActionSpace();
		multipleActionSpace = new MultipleActionSpace(DEFAULT_COST);
	}
	
	public Harvest(int actionSpaceCost, int multipleActionSpaceCost) {
		actionSpace = new ActionSpace(actionSpaceCost);
		multipleActionSpace = new MultipleActionSpace(multipleActionSpaceCost);
	}
	
	
	@Override
	public boolean placeFamilyMember(FamilyMember familyMember) {
		
		if(actionSpace.placeFamilyMember(familyMember) || multipleActionSpace.placeFamilyMember(familyMember)){
			activeCards(familyMember.getOwner().getGreenDeck());
			return true;
		}
		return false;
	}
	
	protected void activeCards(Deck<GreenCard> deck){
		for(GreenCard card : deck){
			card.activePermanentEffect();
		}
	}
}
