package it.polimi.ingsw.ps11.model.gameLogics.actions.affecter;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Affecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.GetCardAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInFloorAction;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/**
 * <h3> CardCostAffecter </h3>
 * <p> Bonus: modifica le reosurceLists dei costi di una carta attraverso una <code>GetCardAction</code>.</p>
 * @param  DevelopmentCard (carta a cui va modificato il costo), resourceList (valori delle risorse che modificano le
 * resourceList dei costi della carta).</p>
 * @see Affecter
 * @see GetCardAction
 */
public class CardCostAffecter implements Affecter<FamilyInFloorAction> {

	private String cardType;
	private ResourceList modifier;	
	
	public CardCostAffecter(String cardType, ResourceList resource) {
		this.cardType = cardType;
		this.modifier = resource;
	}
	
	@Override
	public String target() {
		return FamilyInFloorAction.class.toString();
	}

	@Override
	public FamilyInFloorAction affect(FamilyInFloorAction action) {
		DevelopmentCard card = action.getCardAction().getCard();
		if(card != null && card.getId().equals(cardType)){
			action.getCardAction().addDiscount(modifier);
		}
		return action;
	}

}
