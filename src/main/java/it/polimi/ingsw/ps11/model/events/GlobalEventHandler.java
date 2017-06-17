package it.polimi.ingsw.ps11.model.events;

import it.polimi.ingsw.ps11.model.events.list.ScegliCartaEvent;

public class GlobalEventHandler {
	
	private static EventHandler<ScegliCartaEvent> scegliCarta = new EventHandler<>();
	
	public static EventHandler<ScegliCartaEvent> getScegliCarta() {
		return scegliCarta;
	}
	
	public static void newEvent(EventHandler<?> event){
		
	}
	
}
