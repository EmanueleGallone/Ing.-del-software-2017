package it.polimi.ingsw.ps11.model.gameLogics.actions.affecter;

import it.polimi.ingsw.ps11.model.gameLogics.actions.family.FamilyInSpaceAction;
/**
 * <h3> FixFamilyValue </h3>
 * <p> Bonus: sottotipo di <code>FamilyInSpaceAffecter</code>, fissa il valore di un familiare.</p>
 * @param  string (tipo del familiare da modificare) int (valore fissato del familiare).</p>
 * @see FamilyInSpaceAffecter
 */
public class FixFamilyValue extends FamilyInSpaceAffecter {

	public FixFamilyValue(String familyType, int fixedValue) {
		super(familyType, fixedValue);
	}

	@Override
	public FamilyInSpaceAction affect(FamilyInSpaceAction action) {
		if(action.getFamilyMember().getId().equals(familyType)){
			int currentValue = action.getFamilyMember().getValue();
			int difference = this.value - currentValue;							
			action.addModifier(difference);	
		}
		return action;
	}
}
