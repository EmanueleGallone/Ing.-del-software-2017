package it.polimi.ingsw.ps11.model.cards.effects;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.affecter.DecrementAffecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.affecter.FamilyInTowerAffecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.EmptyAction;

public class CostIncrementEffect implements Effect{

	private String condiction;
	private int increment;
	
	public CostIncrementEffect(String condiction, int increment) {
		this.condiction = condiction;
		this.increment = increment;
	}
	
	@Override
	public EmptyAction get(ActionManager aManager) {
		return new EmptyAction();
	}

	@Override
	public void attach(ActionManager aManager) {
		DecrementAffecter affecter = new DecrementAffecter(condiction,increment);
		aManager.add(affecter);
	}

}
