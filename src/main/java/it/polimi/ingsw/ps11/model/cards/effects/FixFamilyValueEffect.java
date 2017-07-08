package it.polimi.ingsw.ps11.model.cards.effects;

import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.affecter.FixFamilyValue;
/**
 * <h3> FixFamilyValueEffect </h3>
 * <p> Effetto di una carta: modifica permanentemente il valore di un familiare attraverso un <code>FixFamilyValue</code>.</p>
 * <p> Richiede: strin (nome del familiare da andare a modificare), int (valore fissato del familiare).</p>
 * @see Effect
 * @see FixFamilyValue
 */
public class FixFamilyValueEffect extends FamilyInSpaceBonus {

	public FixFamilyValueEffect(String familyType, int value) {
		super(familyType, value);
	}

	@Override
	public void attach(ActionManager aManager) {
		FixFamilyValue affecter = new FixFamilyValue(familyType, value);
		aManager.add(affecter);
	}
}
