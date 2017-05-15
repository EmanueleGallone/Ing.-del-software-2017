package it.polimi.ingsw.ps11.cranio.bonus;

import it.polimi.ingsw.ps11.cranio.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.cranio.player.Player;

public class GetAnotherCardBonus extends Bonus{

	
	private DevelopmentCard card;
	
	public GetAnotherCardBonus(DevelopmentCard card) {
		this.card = card;
	}
	
	@Override
	public void behavior(Player player) {
		//Attiva il metodo che ti permette di prendere un'altra carta, per esempio..
	}


}
