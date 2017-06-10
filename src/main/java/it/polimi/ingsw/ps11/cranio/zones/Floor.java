package it.polimi.ingsw.ps11.cranio.zones;

import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.resources.ResourceList;
import it.polimi.ingsw.ps11.cranio.zones.ActionSpace.ActionSpace;
import it.polimi.ingsw.ps11.cranio.zones.ActionSpace.FamilyMemberSpace;

public class Floor implements FamilyMemberSpace,Cloneable {
	
	private DevelopmentCard card;
	private ActionSpace actionSpace;
	
// Start constructors
	
	public Floor() {
		actionSpace = new ActionSpace();
	}
	
	public Floor(int cost){
		actionSpace = new ActionSpace(cost);
	}
	
	public Floor(DevelopmentCard card){
		this();
		this.card = card;
	}
	
	public Floor(int cost, ResourceList resources){
		actionSpace = new ActionSpace(cost,resources);
	}
	
// End constructors
// Start logic
	
	@Override
	public boolean placeFamilyMember(FamilyMember familyMember, Player player) {
		return actionSpace.placeFamilyMember(familyMember, player);
	}
	
// End logic
// Start setters
	
	public void setCard(DevelopmentCard card){
		this.card = card;
	}
	
	public void setActionSpace(ActionSpace actionSpace) {
		this.actionSpace = actionSpace;
	}
	
// End setters
// Start getters
	
	public DevelopmentCard getCard() {
		return card;
	}
	
	public ActionSpace getActionSpace() {
		return actionSpace;
	}
	
// End getters
	
	@Override
	public String toString() {
		return "Floor [card=" + card +'\n' + ", actionSpace=" + actionSpace + "]";
	}
	
	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
}
