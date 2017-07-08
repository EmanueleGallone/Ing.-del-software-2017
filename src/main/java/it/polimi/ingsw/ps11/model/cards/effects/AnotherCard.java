package it.polimi.ingsw.ps11.model.cards.effects;

import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.ChangeStateAction;
import it.polimi.ingsw.ps11.model.gameLogics.states.WaitCard;
/**
 * <h3> AnotherCard </h3>
 * <p> Effetto di una carta: modifica lo stato di un giocatore in <code>Waitcard</code>.</p>
 * <p> Richiede: string (tipo di carta che è possibile prendere), int (valore massimo del costo dell'actionspace associato
 * alla carta).</p>
 * @see Effect
 * @see WaitCard
 */
public class AnotherCard implements Effect{

	private String cardType;
	private int value;
	
	public AnotherCard(String cardType, int value) {
		this.cardType = cardType;
		this.value = value;
	}
	
	@Override
	public ChangeStateAction get(ActionManager aManager) {
		return new ChangeStateAction(aManager, new WaitCard(cardType, value));
	}

	@Override
	public void attach(ActionManager aManager) {

	}
}
