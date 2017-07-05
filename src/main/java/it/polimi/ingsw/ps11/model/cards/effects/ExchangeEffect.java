package it.polimi.ingsw.ps11.model.cards.effects;

import java.util.ArrayList;
import java.util.HashMap;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.ExchangeAction;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

public class ExchangeEffect implements Effect{

	private HashMap<ResourceList, ResourceList> exchange;
	private ArrayList<ResourceList> res1 = new ArrayList<>();
	private ArrayList<ResourceList> res2 = new ArrayList<>();
	
	public ExchangeEffect() {
		
	}
	
	public ExchangeEffect(HashMap<ResourceList, ResourceList> exchange) {
		this.exchange = exchange;
	}

	public void addExchange(ResourceList cost, ResourceList reward){
		//exchange.put(cost, reward);
		res1.add(cost);
		res2.add(reward);
	}
	
	@Override
	public ExchangeAction get(ActionManager aManager) {
		
		exchange = new HashMap<>();
		for(int i = 0; i < res1.size() && i < res2.size(); i++)
			exchange.put(res1.get(i), res2.get(i));
		
		return new ExchangeAction(aManager, exchange);
	}

	@Override
	public void attach(ActionManager aManager) {

	}
	
}
