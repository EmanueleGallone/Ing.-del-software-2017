package it.polimi.ingsw.ps11.model.zones;

import java.io.Serializable;
import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.actions.effects.CouncilPrivilege;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.model.zones.actionSpace.MultipleActionSpace;
/**
 * <h3>CouncilPalace</h3>
 * <p> Classe che rappresenta il palazzo del consiglio. Permette di variare l'ordine in cui i giocatori possono compiere azioni.
 * </p>
 * 
 * @version 1.0
 * @see it.polimi.ingsw.ps11.model.zones.actionSpace.MultipleActionSpace MultipleActionSpace
 */
public class CouncilPalace extends MultipleActionSpace  implements Serializable{
	
	private final int COST = 1;
	
	public ArrayList<Player> getNewOrder(){
		ArrayList<Player> newOrder = new ArrayList<>();
		for(ActionSpace space : multipleActionSpace){
			if(!newOrder.contains(space.getOwner())) //altrimenti se un giocatore ha posizionato più di un familiare, si avranno più players uguali nell'array
				newOrder.add(space.getOwner());
		}
		return newOrder;
	}
	
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
