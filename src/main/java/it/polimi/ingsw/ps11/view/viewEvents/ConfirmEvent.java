package it.polimi.ingsw.ps11.view.viewEvents;

public class ConfirmEvent extends ViewEvent{

	@Override
	public void accept(ViewListener listener) {
		listener.handle(this);
	}

}
