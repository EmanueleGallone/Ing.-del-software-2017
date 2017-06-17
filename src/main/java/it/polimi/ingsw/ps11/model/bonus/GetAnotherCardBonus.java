package it.polimi.ingsw.ps11.model.bonus;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;

public class GetAnotherCardBonus extends PlayerBonus {

	private String cardType;
	private DevelopmentCard card;
	
	public <T extends DevelopmentCard> GetAnotherCardBonus(Class<T> cardType) {
		this.cardType = cardType.toString(); //to.string! se si usa .getName non va; conflitti con hashmap e varie
	}
	
	@Override
	public void behavior() {
		//new TakeCardAction().perform(this);
	}
	
}
