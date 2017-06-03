package it.polimi.ingsw.ps11.cranio.bonus;

import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.cranio.events.EventHandler;
import it.polimi.ingsw.ps11.cranio.events.EventListener;

public class GetAnotherCardBonus extends Bonus {

	
	//private Class<? extends DevelopmentCard> cardType; ora con la serializzazione json va
	private String cardType;
	private DevelopmentCard card;
	
	private EventHandler<GetAnotherCardBonus> scegliCarta = new EventHandler<>();
	
	
	
	public <T extends DevelopmentCard> GetAnotherCardBonus(Class<T> cardType) {
		this.cardType = cardType.getName();
	}
	
	@Override
	public void behavior() {
		
		scegliCarta.invoke(this);
		if(card != null){
			getOwner().getCardManager().addCard(card);
			
		}
	}
	
	public void setCard(DevelopmentCard card) {
		this.card = card;
	}
	
	public void addScegliCartaListener(EventListener<GetAnotherCardBonus> listener){
		scegliCarta.attach(listener);
	}
	
}
