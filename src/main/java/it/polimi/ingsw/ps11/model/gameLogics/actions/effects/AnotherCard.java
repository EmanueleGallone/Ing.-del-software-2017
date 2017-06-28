package it.polimi.ingsw.ps11.model.gameLogics.actions.effects;

import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.SelectACard;

public class AnotherCard implements Effect{

	private String cardType;
	
	@Override
	public SelectACard get(ActionManager aManager) {
		return new SelectACard(aManager, cardType);
	}

}
