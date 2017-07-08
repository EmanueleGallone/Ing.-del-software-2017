package it.polimi.ingsw.ps11.model.gameLogics.actions.affecter;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Affecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.GetCardAction;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/**
 * <h3> CardCostAffecter </h3>
 * <p> Bonus: modifica le reosurceLists dei costi di una carta attraverso una <code>GetCardAction</code>.</p>
 * <p> Richiede: DevelopmentCard (carta a cui va modificato il costo), resourceList (valori delle risorse che modificano le
 * resourceList dei costi della carta).</p>
 * @see Affecter
 * @see GetCardAction
 */
public class CardCostAffecter implements Affecter<GetCardAction> {

	private String cardType;
	private ResourceList modifier;	
	
	public CardCostAffecter(String cardType, ResourceList resource) {
		this.modifier = resource;
	}
	
	@Override
	public String target() {
		return GetCardAction.class.toString();
	}

	@Override
	public GetCardAction affect(GetCardAction action) {
		String card = action.getCard().getId();
		if(card.equals(cardType)){
			action.getCost().subtract(modifier);
		}
		return action;
	}

}
