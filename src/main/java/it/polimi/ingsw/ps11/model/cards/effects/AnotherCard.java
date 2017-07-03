package it.polimi.ingsw.ps11.model.cards.effects;

import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.ChangeStateAction;
import it.polimi.ingsw.ps11.model.gameLogics.states.WaitCard;

public class AnotherCard implements Effect{

	private String cardType;
	private int value;
	
	public AnotherCard(String cardType, int value) {
		this.cardType = cardType;
		this.value = value;
	}
	
	@Override
	public ChangeStateAction get(ActionManager aManager) {
		return new ChangeStateAction(aManager, new WaitCard(cardType, value));
	}
}
