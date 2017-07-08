package it.polimi.ingsw.ps11.model.gameLogics.actions.affecter;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Affecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInSpaceAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInYieldAction;
/**
 * <h3> FamilyInYieldAffecter </h3>
 * <p> Bonus: modifica il valore di un familiar se questo viene posizionato sull'actionspace appartenente alla zona Raccolta
 * o Produzione attraverso una <code>FamilyInYieldAction</code>.</p>
 * <p> Richiede: string (tipo della carta associato alla zona dell'actionspace), int (quantità del modificatore del valore 
 * del familiare).</p>
 * @see Affecter
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
			action.getSpaceAction().addModifier(value);
		}
		return action;
	}

}
