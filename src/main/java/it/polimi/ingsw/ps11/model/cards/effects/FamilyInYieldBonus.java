package it.polimi.ingsw.ps11.model.cards.effects;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.affecter.FamilyInFloorAffecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.affecter.FamilyInYieldAffecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.family.FamilyInFloorAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.family.FamilyInYieldAction;

public class FamilyInYieldBonus implements Effect{

	private String cardType;
	private int value;
	
	public FamilyInYieldBonus(Class<? extends DevelopmentCard> cardType, int value) {
		this(cardType.toString(), value);
	}
	
	public FamilyInYieldBonus(String cardType, int value) {
		this.cardType = cardType;
		this.value = value;
	}
	
	@Override
	public FamilyInYieldAction get(ActionManager aManager) {
		return new FamilyInYieldAffecter(cardType, value);
	}

}
