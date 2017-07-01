package it.polimi.ingsw.ps11.model.zones;

import java.io.Serializable;
import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.game.RoundManager;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.model.zones.actionSpace.MultipleActionSpace;
/**
 * <h3>CouncilPalace</h3>
 * <p> Classe che rappresenta il palazzo del consiglio. Permette di variare l'ordine in cui i giocatori possono compiere azioni.</p>
 * @version 1.0
 * @see it.polimi.ingsw.ps11.model.zones.actionSpace.MultipleActionSpace MultipleActionSpace
 * @see RoundManager
 */
public class CouncilPalace extends MultipleActionSpace  implements Serializable{
	
	public ArrayList<Player> getNewOrder(){
		ArrayList<Player> newOrder = new ArrayList<>();
		for(ActionSpace space : multipleActionSpace){
			if(!newOrder.contains(space.getOwner())) //altrimenti se un giocatore ha posizionato più di un familiare, si avranno più players uguali nell'array
				newOrder.add(space.getOwner());
		}
		return newOrder;
	}
	
	/**<h3> boolean placeFamilyMember(FamilyMember) </h3>
	 *<p> Piazza il familiare nell'actionspace se questo non contiene già un altro familiare dello stesso giocatore che non sia di 
	 * tipo Neutral</p>
	 * @return true se è stato piazzato, false se non è stato possibile
	 */
	@Override
	public boolean placeFamilyMember(FamilyMember familyMember, Player player) {
		ActionSpace actionSpace = new ActionSpace(COST);
		if(actionSpace.placeFamilyMember(familyMember, player)){
			multipleActionSpace.add(actionSpace);
			return true;
		}
		return false;
	}

}
