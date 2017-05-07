package pos.bonus;

import pos.cards.Cards;
import pos.events.EventListener;
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
public class IncrementForAnyCardBonus extends Bonus<Cards, Player> implements EventListener<Player>{

	private int value;
	private Resources resources;
	
	public IncrementForAnyCardBonus(Cards whichCard,Resources whichResource,int value) {
		super(whichCard);
		this.value = value;
		this.resources = whichResource;
	}

	/**
	 * Praticamente prende la lista di carte (del tipo specificato nel costruttore), conta
	 * quante ce ne sono e incrementa la risorsa indicata di value * numeroCarte
	 */
	@Override
	public void behavior(Player player) {
		int cardNumber = player.getCardsByType(subjects).size();
		player.incrementResource(resources, cardNumber * value);
	}

	@Override
	public void handle(Player player) {
		behavior(player);
	}
	
}
