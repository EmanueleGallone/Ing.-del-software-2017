package it.polimi.ingsw.ps11.model.gameLogics.actions.effects;

import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.affecter.FamilyMemberAffecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.FamilyInFloorAction;

public class FamilyInFloorBonus implements Effect{

	private String tower;
	private int value;
	
	public FamilyInFloorBonus(String tower, int value) {
		this.tower = tower;
		this.value = value;
	}
	
	@Override
	public FamilyInFloorAction get(ActionManager aManager) {
		return new FamilyMemberAffecter(tower, value);
	}

}
