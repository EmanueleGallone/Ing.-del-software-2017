package it.polimi.ingsw.ps11.model.cards.effects;

import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.affecter.DecrementAffecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.affecter.FamilyInTowerAffecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.EmptyAction;
/**
 * <h3> CostIncrementEffect </h3>
 * <p> Classe che rappresenta l'effetto di una carta: modifica permanentemente il costo di un tipo di carta attraverso una <code>DecrementAffecter</code>.</p>
 * <p> Richiede: String (Id della carta a cui viene aumentato il costo), int (quantità di incremento).</p>
 * @see Effect
 * @see DecrementAffecter
 */
public class CostIncrementEffect implements Effect{

	private String condiction;
	private int increment;
	
	public CostIncrementEffect(String condiction, int increment) {
		this.condiction = condiction;
		this.increment = increment;
	}
	
	@Override
	public EmptyAction get(ActionManager aManager) {
		DecrementAffecter affecter = new DecrementAffecter(condiction,increment);
		aManager.add(affecter);
		return new EmptyAction();
	}
}
