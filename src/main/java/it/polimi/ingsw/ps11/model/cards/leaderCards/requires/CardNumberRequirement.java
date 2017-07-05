package it.polimi.ingsw.ps11.model.cards.leaderCards.requires;

import java.util.ArrayList;
import java.util.HashMap;

import it.polimi.ingsw.ps11.model.cards.CardManager;
import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.player.Player;

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
