package it.polimi.ingsw.ps11.model.gameLogics.actions.affecter;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Affecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInFloorAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInSpaceAction;
/**
 * <h3> FamilyInFloorAffecter </h3>
 * <p> Bonus: modifica il valore di un familiare se questo viene posizionato sull'actionspace di un piano contenente un determinato
 * tipo di carta attraverso un <code>FamilyInFloorAction</code>.</p>
 * @param  string (tipo di carta contenuta nel piano), int (quantità che modifica il valore del familiare).</p>
 * @see Affecter
 * @see FamilyInFloorAction
 */
public class FamilyInFloorAffecter implements Affecter<FamilyInFloorAction>{
	
	private String cardType;
	private int value;
	
	public FamilyInFloorAffecter(String cardType, int value) {
		this.cardType = cardType;
		this.value = value;
	}
	
	@Override
	public String target() {
		return FamilyInFloorAction.class.toString();
	}

	@Override
	public FamilyInFloorAction affect(FamilyInFloorAction action) {
		FamilyInSpaceAction spaceAction = action.getSpaceAction();
		DevelopmentCard card = action.getCardAction().getCard();
	
		if(card.getId().equals(this.cardType)){
			spaceAction.addModifier(value);
		}
		return action;
	}

}
