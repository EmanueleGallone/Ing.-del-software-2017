package it.polimi.ingsw.ps11.model.zones;

import java.io.Serializable;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.model.zones.actionSpace.FamilyMemberSpace;
/**
 *<h3>Floor</h3>
 *<p> Classe che contiene al suo interno una DevelopmentCard ed un ActionSpace. </p>
 *@see it.polimi.ingsw.ps11.model.cards.DevelopmentCard DevelopmentCard
 *@see it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace ActionSpace.
 */
public class Floor implements FamilyMemberSpace, Serializable {
	
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
	public Floor clone() {		
		Floor clone = new Floor();
		
		if(this.card != null)
			clone.card = this.card.clone();
		
		clone.actionSpace = this.actionSpace.clone();
		
		return clone; 
	}
}
