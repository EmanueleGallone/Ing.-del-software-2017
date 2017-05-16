package it.polimi.ingsw.ps11.cranio.events;

import it.polimi.ingsw.ps11.cranio.events.list.ScegliCartaEvent;

public class GlobalEventHandler {
	
	private static EventHandler<ScegliCartaEvent> scegliCarta = new EventHandler<>();
	
	public static EventHandler<ScegliCartaEvent> getScegliCarta() {
		return scegliCarta;
	}
	
}
