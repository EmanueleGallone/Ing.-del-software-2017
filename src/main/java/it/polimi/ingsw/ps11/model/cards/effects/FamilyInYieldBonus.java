package it.polimi.ingsw.ps11.model.cards.effects;

import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.affecter.FamilyInYieldAffecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.EmptyAction;
/**
 * <h3> FamilyInYieldBonus </h3>
 * <p> Classe che rappresenta l'effetto di una carta: modifica permanentemente il valore di attivazione delle carte "Territorio" e/o "Edificio" in seguito
 * al posizionamento di un familiare in una zona Raccolta e/o Produzione attraverso un <code>FamilyInYieldAffecter</code>.</p>
 * @param  DevelopmentCard (tipo di carte da attivare in seguito al posizionamento su raccolta o produzione), int (valore
 * del bonus di attivazione).</p>
 * @see Effect
 * @see FamilyInYieldAffecter
 */
public class FamilyInYieldBonus implements Effect{

	private String cardType;
	private int value;
	
	public FamilyInYieldBonus(String cardType, int value) {
		this.cardType = cardType;
		this.value = value;
	}
	
	@Override
	public EmptyAction get(ActionManager aManager) {
		FamilyInYieldAffecter affecter = new FamilyInYieldAffecter(cardType, value);
		aManager.add(affecter);	
		return new EmptyAction();
	}
}
