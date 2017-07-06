package it.polimi.ingsw.ps11.model.gameLogics.actions.affecter;

import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInSpaceAction;
/**
 * <h3> FixFamilyValue </h3>
 * <p> Bonus: sottotipo di <code>FamilyInSpaceAffecter</code>, fissa il valore di un familiare.</p>
 * <p> Richiede: string (tipo del familiare da modificare), int (valore fissato del familiare).</p>
 * @see FamilyInSpaceAffecter
 */
public class FixFamilyValue extends FamilyInSpaceAffecter {

	public FixFamilyValue(String familyType, int fixedValue) {
		super(familyType, fixedValue);
	}

	@Override
	public FamilyInSpaceAction affect(FamilyInSpaceAction action) {
		FamilyInSpaceAction newAction = action.clone();
		int currentValue = newAction.getFamilyMember().getValue();
		int currentModifier = newAction.getFamilyMember().getModifier(); 	//Serve a tenere conto dell'effetto di altri bonus che hanno alterato il modificatore
		currentValue = currentValue - currentModifier;						//Serve ad ottenere il valore effettivo dei dadi
		int difference = this.value - currentValue;							
		newAction.getFamilyMember().setModifier(difference + currentModifier );
		return newAction;
	}
}
