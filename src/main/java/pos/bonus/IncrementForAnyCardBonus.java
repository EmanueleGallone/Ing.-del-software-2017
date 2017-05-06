package pos.bonus;

import pos.cards.Cards;
import pos.interfaceList.Incrementable;
import pos.players.Player;

/**
 *  
 * Rappresenta quel bonus per cui ricevi una moneta (o una qualsiasi altra risorsa)
 * per ogni carta blu (o qualsiasi altro colore) che il giocatore possiede
 */
public class IncrementForAnyCardBonus extends Bonus<Player>{

	private int value;
	private Cards card;
	
	public IncrementForAnyCardBonus(Player subject,Cards whichCard,int value) {
		super(subject);
		this.value = value;
		this.card = whichCard;
	}

	@Override
	public void behavior() {
		
	}
	
}
