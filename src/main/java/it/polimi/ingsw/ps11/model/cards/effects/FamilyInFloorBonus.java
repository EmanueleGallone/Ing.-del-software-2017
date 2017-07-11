package it.polimi.ingsw.ps11.model.cards.effects;

import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.affecter.FamilyInFloorAffecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.EmptyAction;
/**
 * <h3> FamilyInFloorBonus </h3>
 * <p> Classe che rappresenta l'effetto di una carta: modifica permanentemente il bonus ricevuto in seguito al posizionamento di un familiare su una torre 
 * attraverso un <code>FamilyInFloorAffecter</code>.</p>
 * @param  DevelopmentCard (Id della carta presente sulla torre che attiva il bonus), int (valore della risorsa bonus).</p>
 * @see Effect
 * @see FamilyInFloorAffecter
 */
public class FamilyInFloorBonus implements Effect{

	private String cardType;
	private int value;
	
	public FamilyInFloorBonus(String cardType, int value) {
		this.cardType = cardType;
		this.value = value;
	}
	
	@Override
	public EmptyAction get(ActionManager aManager) {
		FamilyInFloorAffecter affecter = new FamilyInFloorAffecter(cardType, value);
		aManager.add(affecter);
		return new EmptyAction();
	}
}
