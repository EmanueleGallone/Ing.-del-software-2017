package it.polimi.ingsw.ps11.model.cards.effects;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.gameLogics.newActions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.newActions.affecter.FamilyInYieldAffecter;
import it.polimi.ingsw.ps11.model.gameLogics.newActions.base.EmptyAction;

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
	public EmptyAction get(ActionManager aManager) {
		return new EmptyAction();
	}

	@Override
	public void attach(ActionManager aManager) {
		FamilyInYieldAffecter affecter = new FamilyInYieldAffecter(cardType, value);
		aManager.add(affecter);	
	}

}
