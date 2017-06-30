package it.polimi.ingsw.ps11.model.gameLogics.actions.effects;

import java.util.HashMap;

import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.ExchangeAction;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class ExchangeEffect implements Effect{

	private HashMap<ResourceList, ResourceList> exchange;
	public ExchangeEffect() {
		exchange = new HashMap<>();
	}
	
	public ExchangeEffect(HashMap<ResourceList, ResourceList> exchange) {
		this.exchange = exchange;
	}

	public void addExchange(ResourceList cost, ResourceList reward){
		exchange.put(cost, reward);
	}
	
	@Override
	public ExchangeAction get(ActionManager aManager) {
		return new ExchangeAction(aManager, exchange);
	}
	
}
