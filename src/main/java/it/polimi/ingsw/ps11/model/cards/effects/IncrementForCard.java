package it.polimi.ingsw.ps11.model.cards.effects;

import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.DoSeveralTimeAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.resources.IncrementAction;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/**
 * <h3> IncrementForCard </h3>
 * <p> Classe che rappresenta l'effetto di una carta: attiva l'azione <code>IncrementAction</code> per ogni carta di un certo tipo.</p>
 * @param  string (tipo delle carte che attivano l'azione), resourceList (valori delle risorse che ogni chiamata aumenta)</p>
 * @see Effect
 * @see IncrementAction
 * @see DoSeveralTimeAction
 */
public class IncrementForCard implements Effect {

	private String cardType;
	private ResourceList resource;
	
	public IncrementForCard(String cardType, ResourceList resource) {
		this.cardType = cardType;
		this.resource = resource;
	}
	

	@Override
	public DoSeveralTimeAction get(ActionManager aManager) {
		IncrementAction action = new IncrementAction(aManager, resource);
		action = aManager.affect(action);
		int iterationNumber = aManager.state().getPlayer().getCardManager().getCardList(cardType).size();
		return new DoSeveralTimeAction(aManager, action, iterationNumber);
	}
}
