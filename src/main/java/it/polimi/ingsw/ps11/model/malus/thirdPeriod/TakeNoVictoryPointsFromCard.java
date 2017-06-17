package it.polimi.ingsw.ps11.model.malus.thirdPeriod;

import it.polimi.ingsw.ps11.model.bonus.Bonus;
import it.polimi.ingsw.ps11.model.bonus.IncrementResourceBonus;
import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.malus.Excommunication;
import it.polimi.ingsw.ps11.model.player.Player;
import it.polimi.ingsw.ps11.model.resources.list.VictoryPoint;

public class TakeNoVictoryPointsFromCard extends Excommunication {
	
	private String cardType;
	
	public TakeNoVictoryPointsFromCard(Player player, Class<? extends DevelopmentCard> card) {
		this.owner = player;
		this.cardType = card.toString();
		setPeriod(3);
		
	}
	
	
	public void behaviour(){ //pare che funzioni
		for(DevelopmentCard cards : getOwner().getCardManager().getCardList(cardType)){
			
			for(Bonus bonus : cards.getPermanentBonus())
				if (bonus.getClass() == IncrementResourceBonus.class){
					((IncrementResourceBonus) bonus).getResourceList().setResource(new VictoryPoint(0));
				}
			
		}
		
	}
	

}
