package it.polimi.ingsw.ps11.cranio.zones.HarvestAndProduction;

import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.cranio.zones.actionSpace.pos.SingleActionSpace;

public abstract class CardAttivator{
	
	protected static final int DEFAULT_COST = 3; // Il costo per il multiple space
	protected SingleActionSpace actionSpace;
	protected ActionSpace multipleActionSpace;
	
	public CardAttivator() {
		actionSpace = new SingleActionSpace();
		multipleActionSpace = new ActionSpace(DEFAULT_COST);
	}
	
	public CardAttivator(int actionSpaceCost, int multipleActionSpaceCost) {
		actionSpace = new SingleActionSpace(actionSpaceCost);
		multipleActionSpace = new ActionSpace(multipleActionSpaceCost);
	}
	
// End constructors

	public boolean SingleActionSpaceisFree(){
		if( actionSpace.getFamilyMember() == null )
		return true;
		
		return false;
		
	}
	
	public abstract void activeCard(FamilyMember familyMember, Player player);
	public abstract void activeCard(int value, Player player); //per i bonus. senza dover utilizzare i familiari
	
}
