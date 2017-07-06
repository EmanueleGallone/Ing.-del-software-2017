package it.polimi.ingsw.ps11.model.gameLogics.actions.affecter;

import it.polimi.ingsw.ps11.model.familyMember.FamilyMember;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Affecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInFloorAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInSpaceAction;
/**
 * <h3> FamilyInSpaceAffecter </h3>
 * <p> Bonus: modifica il valore di un familiare se questo viene posizionato su un qualunque actionspace 
 * attraverso un <code>FamilyInFloorAction</code>.</p>
 * <p> Richiede: string (tipo del familiare), int (quantità che modifica il valore del familiare).</p>
 * @see Affecter
 * @see FamilyInFloorAction
 */
public class FamilyInSpaceAffecter implements Affecter<FamilyInSpaceAction> {

	private String familyType;

	protected int value;
	
	public FamilyInSpaceAffecter(String familyType, int value) {
		this.value = value;
		this.familyType = familyType;
	}
	
	@Override
	public Class<FamilyInSpaceAction> target() {
		return FamilyInSpaceAction.class;
	}

	@Override
	public FamilyInSpaceAction affect(FamilyInSpaceAction action) {
		FamilyInSpaceAction newAction = action.clone();
		FamilyMember familyMember = newAction.getFamilyMember();
		if(familyMember.getClass().toString().equals(familyType))
			familyMember.setModifier(familyMember.getModifier() + value);
		return newAction;
	}

}
