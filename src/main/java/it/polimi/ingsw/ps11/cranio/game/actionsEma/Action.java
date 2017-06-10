package it.polimi.ingsw.ps11.cranio.game.actionsEma;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.cranio.malus.ActionConditionAffecter;

public abstract class Action {
	
	protected ArrayList<ActionConditionAffecter> conditionAffecters = new ArrayList<>();
	
	public abstract void perform();
	public abstract boolean isLegal();


}
