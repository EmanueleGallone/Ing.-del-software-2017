package pos.bonus;

import pos.cards.Cards;
import pos.events.EventListener;
import pos.players.Player;

public class GetAnotherCardBonus extends Bonus<Cards, Player> implements EventListener<Player>{

	public GetAnotherCardBonus(Cards cardType) {
		super(cardType);
	}

	@Override
	public void behavior(Player player) {
		//card = ScegliCarta
		//card.take(player);
	}

	@Override
	public void handle(Player player) {
		behavior(player);
	}
}
