package it.polimi.ingsw.ps11.model.gameLogics.actions.base;

import java.util.ArrayList;
import java.util.HashMap;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ResourceListener;
import it.polimi.ingsw.ps11.model.gameLogics.states.WaitResource;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class ExchangeAction implements Action<ExchangeAction>, ResourceListener {

	private ActionManager aManager;
	private HashMap<ResourceList, ResourceList> exchange = new HashMap<>();
	
	public ExchangeAction(ActionManager aManager, HashMap<ResourceList, ResourceList> exchange) {
		this.aManager = aManager;
		this.exchange = exchange;
	}
	
	
	@Override
	public boolean isLegal() {
		return true;
	}

	@Override
	public void perform() {
		ArrayList<ResourceList> choice = new ArrayList<>(exchange.keySet());
		aManager.changeState(new WaitResource(choice, this));
	}
	
	@Override
	public void update(ResourceList resource) {
		ResourceList rewards = exchange.get(resource);
		if(rewards != null){
			DecrementAction decrement = aManager.newDecrementAction(resource);
			IncrementAction increment = aManager.newIncrementAction(rewards);
			if(decrement.isLegal() && increment.isLegal()){
				decrement.perform();
				increment.perform();
			}
		}
	}
	
// _________________________ Method for action system ________________________


	@Override
	public ExchangeAction decore(ExchangeAction action) {
		if(action != this){
			return action.decore(this);
		}
		return this;
	}
	
	@Override
	public void attach(ActionManager aManager){
		ExchangeAction action = aManager.get(target());
		if(action == null){
			action = this;
		}
		aManager.add(action.decore(this));
	}

	@Override
	public Class<ExchangeAction> target() {
		return ExchangeAction.class;
	}
	
// _______________________S____________________________
	
	@Override
	public ExchangeAction clone(){
		ExchangeAction copy = new ExchangeAction(aManager, exchange);
		return copy;
	}
}
