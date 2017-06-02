package it.polimi.ingsw.ps11.cranio.malus.thirdPeriod;

import it.polimi.ingsw.ps11.cranio.bonus.Bonus;
import it.polimi.ingsw.ps11.cranio.bonus.IncrementResourceBonus;
import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.cranio.malus.Excommunication;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.resources.list.VictoryPoint;

public class TakeNoVictoryPointsFromCard extends Excommunication {
	
	private Class<? extends DevelopmentCard> cardType;
	
	public TakeNoVictoryPointsFromCard(Player player, Class<? extends DevelopmentCard> card) {
		this.owner = player;
		this.cardType = card;
		
	}
	
	
	public void behaviour(){ //pare che funzioni
		for(DevelopmentCard cards : owner.getCardManager().getCardList(cardType)){
			// per ogni carta del tipo cardType, set victory point = 0; quindi la carta dovrebbe avere una resourceList?
			for(Bonus bonus : cards.getPermanentBonus())
				if (bonus.getClass() == IncrementResourceBonus.class){
					((IncrementResourceBonus) bonus).getResourceList().setResource(new VictoryPoint(0));
				}
			
		}
		
	}
	

}
