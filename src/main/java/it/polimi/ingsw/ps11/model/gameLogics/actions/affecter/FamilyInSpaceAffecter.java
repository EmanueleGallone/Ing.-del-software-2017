package it.polimi.ingsw.ps11.model.gameLogics.actions.affecter;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Affecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInFloorAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInSpaceAction;
/**
 * <h3> FamilyInSpaceAffecter </h3>
 * <p> Bonus: modifica il valore di un familiare se questo viene posizionato su un qualunque actionspace 
 * attraverso un <code>FamilyInFloorAction</code>.</p>
 * @param  string (tipo del familiare), int (quantità che modifica il valore del familiare).</p>
 * @see Affecter
 * @see FamilyInFloorAction
 */
public class FamilyInSpaceAffecter implements Affecter<FamilyInSpaceAction> {

	protected String familyType;
	protected int value;
	
	public FamilyInSpaceAffecter(String familyType, int value) {
		this.value = value;
		this.familyType = familyType;
	}
	
	@Override
	public String target() {
		return FamilyInSpaceAction.class.toString();
	}

	@Override
	public FamilyInSpaceAction affect(FamilyInSpaceAction action) {
		FamilyMember familyMember = action.getFamilyMember();
		if(familyMember != null && familyMember.getId().equals(familyType))
			action.addModifier(value);
		return action;
	}

}
