package it.polimi.ingsw.ps11.model.gameLogics.states;

import it.polimi.ingsw.ps11.model.gameLogics.actions.NeedConfirm;
import it.polimi.ingsw.ps11.view.viewEvents.ConfirmViewEvent;

public class WaitConfirm extends PlayState {

	private NeedConfirm action;
	
	public WaitConfirm(NeedConfirm action) {
		this.action = action;
	}
	
	@Override
	public void handle(ConfirmViewEvent confirmEvent) {
		action.notifyConfirm(confirmEvent);
	}
}
