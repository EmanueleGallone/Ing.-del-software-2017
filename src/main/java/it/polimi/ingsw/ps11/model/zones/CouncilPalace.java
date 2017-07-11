package it.polimi.ingsw.ps11.model.zones;

import java.io.Serializable;
import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.cards.effects.Effect;
import it.polimi.ingsw.ps11.model.gameLogics.RoundManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.resources.list.Coin;
import it.polimi.ingsw.ps11.model.zones.actionSpace.ActionSpace;
import it.polimi.ingsw.ps11.model.zones.actionSpace.MultipleActionSpace;
/**
 * <h3>CouncilPalace</h3>
 * <p> Classe che rappresenta il palazzo del consiglio. Al posizionmento di un familiare restituisce una lista di ConcilPrivileges che
 * rappresentano bonus tra cui il giocatore può scegliere. Permette di variare l'ordine in cui i giocatori possono compiere azioni.</p>
 * @version 1.0
 * @see it.polimi.ingsw.ps11.model.zones.actionSpace.MultipleActionSpace MultipleActionSpace
 * @see RoundManager
 */
public class CouncilPalace extends MultipleActionSpace  implements Serializable{
	
	private ResourceList bonus = new ResourceList(new Coin(1));
	private ArrayList<Effect> effects = new ArrayList<>();
	
	
	public ArrayList<Player> getNewOrder(){
		ArrayList<Player> newOrder = new ArrayList<>();
		for(ActionSpace space : multipleActionSpace){
			if(!newOrder.contains(space.getOwner())) //altrimenti se un giocatore ha posizionato più di un familiare, si avranno più players uguali nell'array
				newOrder.add(space.getOwner());
		}
		return newOrder;
	}
	
	public ResourceList getBonus() {
		return bonus;
	}
	
	public ArrayList<Action> getEffects(ActionManager aManager) {
		ArrayList<Action> actions = new ArrayList<>();
		for(Effect e : effects){
			actions.add(e.get(aManager));
		}
		return actions;
	}
	
	public void setBonus(ResourceList bonus) {
		this.bonus = bonus;
	}
	
	public void addEffect(Effect effect){
		this.effects.add(effect);
	}

}
