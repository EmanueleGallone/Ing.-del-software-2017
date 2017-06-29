package it.polimi.ingsw.ps11.view.viewEvents;

public class EndTurnEvent extends ViewEvent{

	public EndTurnEvent() {
	
	}
	
	@Override
	public void accept(ViewListener listener) {
		listener.handle(this);
	}

}
