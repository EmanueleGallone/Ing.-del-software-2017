package it.polimi.ingsw.ps11.model.gameLogics.actions.base;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.effects.Effect;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class GetCardAction implements Action<GetCardAction>{

	protected ActionManager aManager;
	protected DevelopmentCard card;
	protected ResourceList cost;
	
	public GetCardAction() {
	
	}

	public GetCardAction(ActionManager aManager, DevelopmentCard card, ResourceList cost) {
		this.aManager = aManager;
		this.card = card;
		this.cost = cost.clone();
	}
	
	@Override
	public boolean isLegal() {
		//boolean result = this.card.getCosts().contains(cost);
		DecrementAction pay = aManager.newDecrementAction(cost);
		//boolean result = result && pay.isLegal();
		return pay.isLegal() && aManager.getSubject().getCardManager().canAdd(card) ;
	}

	@Override
	public void perform() {
		DecrementAction pay = aManager.newDecrementAction(cost);
		pay.perform();
		aManager.getSubject().getCardManager().addCard(card);
		
		for(Effect effect: card.getIstantEffect()){
			Action action = effect.get(aManager);
			if(action.isLegal())
				action.perform();
		}
		for(Action permaEffect: card.getPermanentEffect()){
			permaEffect.attach(aManager);
		}
	}
	
	
	public DevelopmentCard getCard() {
		return card;
	}
	public ResourceList getCost() {
		return cost;
	}
	

	// _________________________ Method for action system ________________________
	
	@Override
	public void attach(ActionManager aManager) {
		GetCardAction increment = aManager.get(target());
		if(increment == null){
			increment = this;
		}
		aManager.add(increment.decore(this));
	}

	@Override
	public Class<GetCardAction> target() {
		return GetCardAction.class;
	}
	
	@Override
	public GetCardAction decore(GetCardAction action) {
		if(action != this){
			return action.decore(this);
		}
		return this;
	}
	
	@Override
	public GetCardAction clone() {
		// TODO Auto-generated method stub
		return null;
	}

}
