package pos.bonus;

import pos.events.EventListener;
import pos.players.Player;
import pos.zones.ActivableZone;

public class ActiveZoneBonus extends Bonus<ActivableZone, Player> implements EventListener<Player>{

	public ActiveZoneBonus(ActivableZone subject) {
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
