package it.polimi.ingsw.ps11.model.gameLogics.newActions.affecter;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.gameLogics.newActions.Affecter;
import it.polimi.ingsw.ps11.model.gameLogics.newActions.base.GetCardAction;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/** <h3> CardCostAffecter </h3>
 * <p> Classe che rappresenta il bonus che ha il compito di modificare il costo della ResourceList di una carta</p>
 * @see GetCardAction
 */
public class CardCostAffecter implements Affecter<GetCardAction> {

	private String cardType;
	private ResourceList modifier;	
	
	public CardCostAffecter(Class<? extends DevelopmentCard> cardType, ResourceList resource) {
		this(cardType.toString(), resource);
	}
	
	public CardCostAffecter(String cardType, ResourceList resource) {
		this.modifier = resource;
	}
	
	@Override
	public Class<GetCardAction> target() {
		return GetCardAction.class;
	}

	@Override
	public GetCardAction affect(GetCardAction action) {
		String card = action.getCard().getClass().toString();
		if(card.equals(cardType)){
			GetCardAction cardAction = action.clone();
			cardAction.getCost().subtract(modifier);
			return cardAction;
		}
		return action;
	}

}
