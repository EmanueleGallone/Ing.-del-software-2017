package it.polimi.ingsw.ps11.model.gameLogics.actions.base;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.effects.Effect;

public class ActiveYieldAction implements Action<ActiveYieldAction> {

	private ActionManager aManager;
	private int value;
	private String cardType;
	
	public ActiveYieldAction(ActionManager aManager, String cardType ,int value) {
		this.aManager = aManager;
		this.value = value;
		this.cardType = cardType;
	}
	
	@Override
	public boolean isLegal() {
		return true;
	}

	@Override
	public void perform() {
		
		ArrayList<DevelopmentCard> cards = aManager.getSubject().getCardManager().getCardList(cardType);
		if (cards != null){
			for(DevelopmentCard card : cards){
				if(card.getActiveValue() <= value)
					active(card.getPermanentEffect());
			}
		}
	}

	public void active(ArrayList<Effect> effects){
		for(Effect effect : effects){
			Action<?> action = effect.get(aManager);
			if(action.isLegal())
				action.perform();
		}
	}
	
//______________________________________________________________
	
	@Override
	public ActiveYieldAction decore(ActiveYieldAction action) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void attach(ActionManager aManager) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<? extends Action<?>> target() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Action<?> clone() {
		// TODO Auto-generated method stub
		return null;
	}

}
