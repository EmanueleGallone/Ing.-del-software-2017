package it.polimi.ingsw.ps11.model.bonus.ema.actionsEma;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.bonus.ema.malus.ActionConditionAffecter;

public abstract class Action {
	
	protected ArrayList<ActionConditionAffecter> conditionAffecters = new ArrayList<>();
	
	public abstract void perform();
	public abstract boolean isLegal();


}
