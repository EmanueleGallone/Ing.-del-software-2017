package it.polimi.ingsw.ps11.model.gameLogics.actions.effects;

import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.ActiveYieldAction;

public class ActiveYieldEffect implements Effect {

	private String cardType;
	private int value;

	public ActiveYieldEffect(String cardType, int value) {
		this.cardType = cardType;
		this.value = value;
	}
	
	@Override
	public ActiveYieldAction get(ActionManager aManager) {
		return aManager.newActiveYield(cardType, value);
	}

}
