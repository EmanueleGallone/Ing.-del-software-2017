package it.polimi.ingsw.ps11.mvc.components;

import it.polimi.ingsw.ps11.cranio.events.EventHandler;
import it.polimi.ingsw.ps11.cranio.player.Player;
import it.polimi.ingsw.ps11.mvc.view.events.FloorSelectedEvent;

public class FloorView implements TextualComponent{

	EventHandler<FloorSelectedEvent> floorSelectedEvent = new EventHandler<>();
	
	@Override
	public void selected() {
		floorSelectedEvent.invoke(new FloorSelectedEvent(this));
	}

	@Override
	public <T> void print(T arg) {
		if (Player.class == arg.getClass()){
			System.out.println("daje");
		}
	}

}
