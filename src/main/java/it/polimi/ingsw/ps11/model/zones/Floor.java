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
 *<p> Classe che rappresenta un piano della torre e contiene al suo interno una DevelopmentCard dello stesso tipo della torre che viene 
 *assegnata ad un giocatore al posizionamento di un familiare sull'action space associata o come effetto di una carta, ed un ActionSpace
 *su cui è possibile posizionare un familiare. </p>
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
	
	/**<h3> boolean placeFamilymember(FamilyMember, Player) </h3>
	 *<p> Piazza il familiare nell'actionspace se questo non è già occupato.</p>
	 *@return true se è stato piazzato, false altrimenti
	 */
	@Override
	public void placeFamilyMember(FamilyMember familyMember, Player player) {
		actionSpace.placeFamilyMember(familyMember, player);
	}
	
	@Override
	public void clean() {
		this.actionSpace.clean();
	}
	
	public void cleanCard(){
		this.card = null;
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
	
	/**<h3> String toString() </h3>
	 *<p> Floor [card= </p> 
	 * <p>, actionSpace= ]</p>
	 */
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
