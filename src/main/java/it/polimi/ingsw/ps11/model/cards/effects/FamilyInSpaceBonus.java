package it.polimi.ingsw.ps11.model.cards.effects;

import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.affecter.FamilyInSpaceAffecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.EmptyAction;
/**
 * <h3> FamilyInSpaceBonus </h3>
 * <p> Classe che rappresenta l'effetto di una carta: modifica permanentemente il bonus ricevuto in seguito al posizionamento di un familiare su un
 * qualsiasi actionspace attraverso un <code>FamilyInSPaceAffecter</code>.</p>
 * @param  string (Id del familiare che riceve il bonus), in (valore del bonus)</p>
 * @see Effect
 * @see FamilyInSpaceAffecter
 */
public class FamilyInSpaceBonus implements Effect {

	protected String familyType;
	protected int value;
	
	public FamilyInSpaceBonus(String familyType, int value) {
		this.value = value;
		this.familyType = familyType;
	}
	
	@Override
	public EmptyAction get(ActionManager aManager) {
		FamilyInSpaceAffecter affecter = new FamilyInSpaceAffecter(familyType, value);
		aManager.add(affecter);
		return new EmptyAction();
	}
}
