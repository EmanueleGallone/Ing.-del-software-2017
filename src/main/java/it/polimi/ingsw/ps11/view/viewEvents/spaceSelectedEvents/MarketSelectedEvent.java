package it.polimi.ingsw.ps11.view.viewEvents.spaceSelectedEvents;

import it.polimi.ingsw.ps11.view.viewEvents.ViewListener;

public class MarketSelectedEvent extends SpaceSelectedEvent {

	private int actionSpace;
	
	public MarketSelectedEvent(int whichSpace) {
		this.actionSpace = whichSpace;
	}
	
	public int getActionSpace() {
		return actionSpace;
	}
	@Override
	public void accept(ViewListener listener) {
		listener.handle(this);
	}

}
