package pos.bonus;

import pos.cards.Cards;
import pos.players.Player;
import pos.resources.Resources;

/**
 *  
 * Rappresenta quel bonus per cui ricevi una moneta (o una qualsiasi altra risorsa)
 * per ogni carta blu (o qualsiasi altro colore) che il giocatore possiede
 * @Parametri
 * Ha bisogno del subject (ovvero il giocatore in questione), del tipo della carta che deve andare
 * a contare (ad esempio Territori, carte blu, gialle ecc...), della risorsa che deve andare ad aumentare
 * (tipo monete, pietre ecc..), e del value ovvero di quanto aumentarla per ogni carta che si possiede 
 */
public class IncrementForAnyCardBonus extends Bonus<Player>{

	private int value;
	private Cards card;
	private Resources resources;
	
	public IncrementForAnyCardBonus(Player subject,Cards whichCard,Resources whichResource,int value) {
		super(subject);
		this.value = value;
		this.card = whichCard;
	}

	/**
	 * Praticamente prende la lista di carte (del tipo specificato nel costruttore), conta
	 * quante ce ne sono e incrementa la risorsa indicata di value * numeroCarte
	 */
	@Override
	public void behavior() {
		int cardNumber = this.subjects.getCardsByType(card).size();
		this.subjects.incrementResource(resources, cardNumber * value);
	}
	
}
