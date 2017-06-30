package it.polimi.ingsw.ps11.model.gameLogics.actions.effects;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.affecter.FamilyInFloorAffecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.FamilyInFloorAction;

public class FamilyInFloorBonus implements Effect{

	private String cardType;
	private int value;
	
	public FamilyInFloorBonus(Class<? extends DevelopmentCard> cardType, int value) {
		this(cardType.toString(), value);
	}
	
	public FamilyInFloorBonus(String cardType, int value) {
		this.cardType = cardType;
		this.value = value;
	}
	
	@Override
	public FamilyInFloorAction get(ActionManager aManager) {
		return new FamilyInFloorAffecter(cardType, value);
	}

}
