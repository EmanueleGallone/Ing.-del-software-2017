package it.polimi.ingsw.ps11.cranio.events.list;

import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;

public class ScegliCartaEvent {
	
	private DevelopmentCard card;
	
	public void setCard(DevelopmentCard card) {
		this.card = card;
	}
	
	public DevelopmentCard getCard() {
		return card;
	}

}
