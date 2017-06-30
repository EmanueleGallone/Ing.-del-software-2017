package it.polimi.ingsw.ps11.model.gameLogics.actions;

import it.polimi.ingsw.ps11.model.modelEvents.ConfirmEvent;
import it.polimi.ingsw.ps11.model.zones.Floor;
import it.polimi.ingsw.ps11.view.viewEvents.ConfirmViewEvent;

public interface NeedConfirm {

	public void notifyConfirm(ConfirmViewEvent confirm);
	public ConfirmEvent getConfirm();
}
