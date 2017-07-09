package it.polimi.ingsw.ps11.model.gameLogics.actions;

import it.polimi.ingsw.ps11.model.modelEvents.ConfirmEvent;
import it.polimi.ingsw.ps11.view.viewEvents.ConfirmViewEvent;
/**
 * <h3> NeedConfirm </h3>
 * <p> Interfaccia l'attesa e notifica di conferma di un'azione da parte di un giocatore.</p>
 * @see ConfirmEvent
 */
public interface NeedConfirm {

	public boolean notifyConfirm(ConfirmViewEvent confirm);
	public ConfirmEvent getConfirm();
}
