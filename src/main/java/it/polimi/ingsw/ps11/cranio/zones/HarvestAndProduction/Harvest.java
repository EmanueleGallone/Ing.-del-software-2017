package it.polimi.ingsw.ps11.cranio.zones.HarvestAndProduction;

import it.polimi.ingsw.ps11.cranio.bonus.IncrementResourceBonus;
import it.polimi.ingsw.ps11.cranio.cards.CardManager;
import it.polimi.ingsw.ps11.cranio.cards.list.GreenCard;
import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.player.Player;

public class Harvest extends CardAttivator {
	
	@Override
	public void activeCard(FamilyMember familyMember, Player player) {
		CardManager cardManager = player.getCardManager();
		for(GreenCard card : cardManager.getCardList(GreenCard.class))
			for(int i = 0; i < card.getPermanentBonus().size(); i++) //scorre tutti i bonus (inutile visto che tutte le carte hanno al max 1 bonus)
			if (card.getActiveValue() <= familyMember.getValue()){
				IncrementResourceBonus temp = (IncrementResourceBonus) card.getPermanentBonus().get(i);
				player.getResourceList().sum(temp.getResourceList()); //attiva il bonus e somma al giocatore
			}
	}
	
	@Override
	public void activeCard(int value, Player player){
		CardManager cardManager = player.getCardManager();
		for(GreenCard card : cardManager.getCardList(GreenCard.class))
			for(int i = 0; i < card.getPermanentBonus().size(); i++) //scorre tutti i bonus (inutile visto che tutte le carte hanno al max 1 bonus)
			if (card.getActiveValue() <= value){
				IncrementResourceBonus temp = (IncrementResourceBonus) card.getPermanentBonus().get(i);
				player.getResourceList().sum(temp.getResourceList()); //attiva il bonus e somma al giocatore
			}
	}

}
