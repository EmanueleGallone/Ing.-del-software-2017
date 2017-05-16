package it.polimi.ingsw.ps11.cranio.bonus.istant;

import it.polimi.ingsw.ps11.cranio.bonus.Bonus;
import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.cranio.player.Player;

public class GetAnotherCard extends Bonus {
	
	private DevelopmentCard card;
	private Player player;
	private int value;

	public GetAnotherCard(int value) {
		this.value = value;
	}

	@Override
	public void behavior() {
		
		card.take(player);
		
		/*ScegliCartaEvent scegliCartaEvent = new ScegliCartaEvent();
		GlobalEventHandler.getScegliCarta().invoke(scegliCartaEvent);
		DevelopmentCard card = scegliCartaEvent.getCard();
		//card.take(player);
		System.out.println(card.getId());
		*/
	}
}
