package it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents;

import it.polimi.ingsw.ps11.view.viewEvents.ViewListener;

public class ProductionSelectedEvent extends SpaceSelectedEvent {

	@Override
	public void accept(ViewListener listener) {
		listener.handle(this);
	}

}
