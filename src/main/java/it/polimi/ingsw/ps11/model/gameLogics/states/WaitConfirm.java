package it.polimi.ingsw.ps11.model.gameLogics.states;

import it.polimi.ingsw.ps11.model.gameLogics.actions.NeedConfirm;
import it.polimi.ingsw.ps11.model.modelEvents.ConfirmEvent;
import it.polimi.ingsw.ps11.model.zones.Floor;
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
	
	@Override
	public void notifyToClient() {
		stateHandler().invoke(action.getConfirm());
	}
}
