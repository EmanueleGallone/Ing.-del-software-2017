package it.polimi.ingsw.ps11.model.cards.effects;

import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.ActiveYieldAction;
/**
 * <h3> ActiveYieldEffect </h3>
 * <p> Classe che rappresenta l'effetto di una carta: attiva l'azione <code>ActiveYieldAction</code>.</p>
 * @param  string (tipo delle carte da attivare, raccolta o produzione)
 * @param  int value (valore di attivazione)
 * @see Effect
 * @see ActiveYieldAction
 */
public class ActiveYieldEffect implements Effect {

	private String cardType;
	private int value;

	public ActiveYieldEffect(String cardType, int value) {
		this.cardType = cardType;
		this.value = value;
	}
	
	@Override
	public ActiveYieldAction get(ActionManager aManager) {
		ActiveYieldAction action = new ActiveYieldAction(aManager, cardType, value);
		return aManager.affect(action);
	}

}
