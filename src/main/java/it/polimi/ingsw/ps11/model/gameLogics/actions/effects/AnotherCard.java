package it.polimi.ingsw.ps11.model.gameLogics.actions.effects;

import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.ChangeState;
import it.polimi.ingsw.ps11.model.gameLogics.states.WaitCard;

public class AnotherCard implements Effect{

	private String cardType;
	
	@Override
	public ChangeState get(ActionManager aManager) {
		return new ChangeState(aManager, new WaitCard(cardType));
	}
}
