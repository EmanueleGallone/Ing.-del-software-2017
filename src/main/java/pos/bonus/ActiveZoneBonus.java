package pos.bonus;

import pos.events.EventListener;
import pos.games.Player;
import pos.zones.CardsAttivatorZone;

public class ActiveZoneBonus extends Bonus<CardsAttivatorZone, Player> implements EventListener<Player>{

	public ActiveZoneBonus(CardsAttivatorZone subject) {
		super(subject);
	}

	@Override
	public void behavior(Player player) {
		subjects.ActiveCards(player);
	}

	@Override
	public void handle(Player player) {
		behavior(player);
	}
	
}
