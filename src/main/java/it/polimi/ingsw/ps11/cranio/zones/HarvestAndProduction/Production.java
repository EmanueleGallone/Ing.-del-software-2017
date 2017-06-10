package it.polimi.ingsw.ps11.cranio.zones.HarvestAndProduction;

import it.polimi.ingsw.ps11.cranio.bonus.IncrementResourceBonus;
import it.polimi.ingsw.ps11.cranio.bonus.ResourceExchangeBonus;
import it.polimi.ingsw.ps11.cranio.cards.CardManager;
import it.polimi.ingsw.ps11.cranio.cards.list.YellowCard;
import it.polimi.ingsw.ps11.cranio.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.cranio.player.Player;

public class Production extends CardAttivator {
	
	@Override
	public void activeCard(FamilyMember familyMember, Player player) {
		CardManager cardManager = player.getCardManager();
		for(YellowCard card : cardManager.getCardList(YellowCard.class))
			for(int i = 0; i < card.getPermanentBonus().size(); i++){
				if (card.getActiveValue() <= familyMember.getValue()){
					if(card.getPermanentBonus().get(i).getClass() == IncrementResourceBonus.class){
					IncrementResourceBonus temp = (IncrementResourceBonus) card.getPermanentBonus().get(i);
					player.getResourceList().sum(temp.getResourceList());
					}
					if(card.getPermanentBonus().get(i).getClass() == ResourceExchangeBonus.class){
						//fai scegliere al giocatore la risorsa
					}
				}
				
			}
	}
	
	@Override
	public void activeCard(int value, Player player){
		CardManager cardManager = player.getCardManager();
		for(YellowCard card : cardManager.getCardList(YellowCard.class))
			for(int i = 0; i < card.getPermanentBonus().size(); i++)
			if (card.getActiveValue() <= value){
				if(card.getPermanentBonus().get(i).getClass() == IncrementResourceBonus.class){
					IncrementResourceBonus temp = (IncrementResourceBonus) card.getPermanentBonus().get(i);
					player.getResourceList().sum(temp.getResourceList());
					}
					if(card.getPermanentBonus().get(i).getClass() == ResourceExchangeBonus.class){
						//fai scegliere al giocatore la risorsa
					}
			}
	}
}
