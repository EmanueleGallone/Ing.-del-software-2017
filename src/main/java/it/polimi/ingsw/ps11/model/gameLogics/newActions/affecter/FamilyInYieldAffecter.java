package it.polimi.ingsw.ps11.model.gameLogics.newActions.affecter;

import it.polimi.ingsw.ps11.model.gameLogics.newActions.Affecter;
import it.polimi.ingsw.ps11.model.gameLogics.newActions.family.FamilyInYieldAction;
/** <h3> Nome </h3>
 * <p> Classe che rappresenta il bonus che ha il compito di modificare il valore di un familiare se quest'ultimo viene 
 * posizionato sull'actionSpace di una zona Raccolta o Produzione </p>
 * @see FamilyYieldAction
 */
public class FamilyInYieldAffecter implements Affecter<FamilyInYieldAction> {

	private String cardType;
	private int value;
	
	public FamilyInYieldAffecter(String cardType, int value) {
		this.cardType = cardType;
		this.value = value;
	}
	
	@Override
	public Class<FamilyInYieldAction> target() {
		return FamilyInYieldAction.class;
	}

	@Override
	public FamilyInYieldAction affect(FamilyInYieldAction action) {
		String cType = action.getYield().getActiveCard();
		if(cType.equals(cardType)){
			action.getFamilyMember().setModifier(value);
			return action.clone();
		}
		return action;
	}

}
