package it.polimi.ingsw.ps11.model.cards.leaderCards.requires;

import java.util.ArrayList;
import java.util.HashMap;

import it.polimi.ingsw.ps11.model.cards.CardManager;
import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.player.Player;
/**
 * <h3> CardNumberRequirement </h3>
 * <p> Classe che rappresenta i requisiti di attivazione di una carta leader: richiede un numero di carte per tipo di carta.</p>
 * @param  Hashmap<String, int> (Id delle carte, quantità delle carte).</p>
 * @see ActionManager
 */
public class CardNumberRequirement implements Requirement{
	
	private HashMap<String, Integer> requirement;
		
	public CardNumberRequirement(HashMap<String, Integer> requirement) {
		this.requirement = requirement;
	}
	
	public CardNumberRequirement(String cardType , int value) {
		requirement = new HashMap<>();
		requirement.put(cardType, value);
	}

	@Override
	public boolean isSatisfied(Player player) {
	
		CardManager cManager = player.getCardManager();
		for(String cType : requirement.keySet()){
			ArrayList<DevelopmentCard> cards = player.getCardManager().getCardList(cType);
			if (cards == null || cards.size() < requirement.get(cType))
				return false;
		}
		return true;
	}

}
