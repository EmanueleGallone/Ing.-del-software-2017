package it.polimi.ingsw.ps11.model.cards.effects;

import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.affecter.FixFamilyValue;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.EmptyAction;
/**
 * <h3> FixFamilyValueEffect </h3>
 * <p> Classe che rappresenta l'effetto di una carta: modifica permanentemente il valore di un familiare attraverso un <code>FixFamilyValue</code>.</p>
 * @param  string (nome del familiare da andare a modificare), int (valore fissato del familiare).</p>
 * @see Effect
 * @see FixFamilyValue
 */
public class FixFamilyValueEffect extends FamilyInSpaceBonus {
	
	public FixFamilyValueEffect(String familyType, int value) {
		super(familyType, value);
	}

	@Override
	public EmptyAction get(ActionManager aManager) {
		FixFamilyValue affecter = new FixFamilyValue(familyType, value);
		aManager.add(affecter);
		return new EmptyAction();
	}
}
