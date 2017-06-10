package it.polimi.ingsw.ps11.cranio.malus.thirdPeriod;

import it.polimi.ingsw.ps11.cranio.bonus.Bonus;
import it.polimi.ingsw.ps11.cranio.bonus.IncrementResourceBonus;
import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.cranio.malus.Excommunication;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.cranio.resources.list.VictoryPoint;

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
