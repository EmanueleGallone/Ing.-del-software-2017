package it.polimi.ingsw.ps11.model.gameLogics.actions.affecter;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Affecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInFloorAction;
/** <h3> Nome </h3>
 * <p> Classe che rappresenta il bonus che ha il compito di modificare il valore di un familiare se quest'ultimo viene 
 * posizionato sull'actionSpace di un piano con una carta di un certo colore</p>
 * @see PlaceFamilyYieldAction
 */
public class FamilyInFloorAffecter implements Affecter<FamilyInFloorAction>{
	
	private String cardType;
	private int value;
	
	public FamilyInFloorAffecter(String cardType, int value) {
		this.cardType = cardType;
		this.value = value;
	}
	
	@Override
	public Class<FamilyInFloorAction> target() {
		return FamilyInFloorAction.class;
	}

	@Override
	public FamilyInFloorAction affect(FamilyInFloorAction action) {
		FamilyMember familyMember = action.getSpaceAction().getFamilyMember();
		DevelopmentCard card = action.getCardAction().getCard();
		if(card.getClass().toString().equals(this.cardType)){
			familyMember.setModifier(familyMember.getModifier() + value);
			return action.clone();
		}
		return action;
	}

}
