package it.polimi.ingsw.ps11.model.gameLogics.actions.effects;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.affecter.FamilyInFloorAffecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.affecter.PlaceFamilyYieldAffecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.FamilyInFloorAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.PlaceFamilyYieldAction;

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
	public PlaceFamilyYieldAction get(ActionManager aManager) {
		return new PlaceFamilyYieldAffecter(cardType, value);
	}

}
