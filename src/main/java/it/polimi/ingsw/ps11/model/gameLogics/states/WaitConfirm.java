package it.polimi.ingsw.ps11.model.gameLogics.states;

import it.polimi.ingsw.ps11.model.gameLogics.actions.NeedConfirm;
import it.polimi.ingsw.ps11.view.viewEvents.ConfirmEvent;

public class WaitConfirm extends PlayState {

	private NeedConfirm action;
	
	public WaitConfirm(NeedConfirm action) {
		this.action = action;
	}
	
	@Override
	public void handle(ConfirmEvent confirmEvent) {
		action.notifyConfirm(confirmEvent);
	}
}
