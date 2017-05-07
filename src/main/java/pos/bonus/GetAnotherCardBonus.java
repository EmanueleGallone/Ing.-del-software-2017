package pos.bonus;

import pos.cards.Card;
import pos.events.EventListener;
import pos.players.Player;

public class GetAnotherCardBonus extends Bonus<Card, Player> implements EventListener<Player>{

	public GetAnotherCardBonus(Card subject) {
		super(subject);
	}

	@Override
	public void behavior(Player player) {
		subjects.take(player);
	}

	@Override
	public void handle(Player player) {
		behavior(player);
	}
}
