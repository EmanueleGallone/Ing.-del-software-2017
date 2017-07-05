package it.polimi.ingsw.ps11.model.cards.effects;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.affecter.FamilyInFloorAffecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.EmptyAction;

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
	public EmptyAction get(ActionManager aManager) {
		return new EmptyAction();
	}

	@Override
	public void attach(ActionManager aManager) {
		FamilyInFloorAffecter affecter = new FamilyInFloorAffecter(cardType, value);
		aManager.add(affecter);
	}

}
