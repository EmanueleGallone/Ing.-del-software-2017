package it.polimi.ingsw.ps11.model.cards.effects;

import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.affecter.CardCostAffecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.EmptyAction;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/**
 * <h3> CardDiscount </h3>
 * <p> Classe che rappresenta l'effetto di una carta: modifica permanentemente il costo di un tipo di carta attraverso <code>CardCostAffecter</code>.</p>
 * @param  string (tipo della carta su cui è applicabile la modifica del costo), resourceList (valore delle risorse che 
 * modificano i costi delle carte).</p>
 * @see Effect
 * @see CardCostAffecter
 */
public class CardDiscount implements Effect {

	private String cardType;
	private ResourceList discount;
	
	public CardDiscount(String cardType,ResourceList discount) {
		this.discount = discount;
		this.cardType = cardType;
	}
	
	@Override
	public EmptyAction get(ActionManager aManager) {
		CardCostAffecter affecter = new CardCostAffecter(cardType, discount);
		aManager.add(affecter);
		return new EmptyAction();
	}
}
