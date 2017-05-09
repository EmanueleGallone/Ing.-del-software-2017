package pos.bonus;

import pos.events.EventListener;
import pos.players.Player;
import pos.zones.HarvastAndProduction;

public class ActiveZoneBonus extends Bonus<HarvastAndProduction, Player> implements EventListener<Player>{

	public ActiveZoneBonus(HarvastAndProduction subject) {
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
