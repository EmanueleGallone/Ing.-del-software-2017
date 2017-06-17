package it.polimi.ingsw.ps11.model.game.actionsEma;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.malus.ActionConditionAffecter;

public abstract class Action {
	
	protected ArrayList<ActionConditionAffecter> conditionAffecters = new ArrayList<>();
	
	public abstract void perform();
	public abstract boolean isLegal();


}
