package it.polimi.ingsw.ps11.model.events.list;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;

public class ScegliCartaEvent {
	
	private DevelopmentCard card;
	
	public void setCard(DevelopmentCard card) {
		this.card = card;
	}
	
	public DevelopmentCard getCard() {
		return card;
	}

}
