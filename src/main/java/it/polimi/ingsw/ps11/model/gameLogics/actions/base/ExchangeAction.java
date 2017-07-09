package it.polimi.ingsw.ps11.model.gameLogics.actions.base;

import java.util.ArrayList;
import java.util.HashMap;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ResourceListener;
import it.polimi.ingsw.ps11.model.gameLogics.actions.resources.DecrementAction;
import it.polimi.ingsw.ps11.model.gameLogics.actions.resources.IncrementAction;
import it.polimi.ingsw.ps11.model.gameLogics.states.WaitResource;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/** <h3> ExchangeAction </h3>
 * <p> Azione di scambio di una ResourceList per un'altra.</p>
 * @see Action
 */
public class ExchangeAction implements Action, ResourceListener {

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
		aManager.state().nextState(new WaitResource(choice, this));
	}
	
	@Override
	public void update(ResourceList resource) {
		ResourceList rewards = exchange.get(resource); // A quanto pare la get() della map non usa l'equals, va fatto manualmente
		for(ResourceList resourceList : exchange.keySet()){
			if(resourceList.equals(resource))
				rewards = exchange.get(resourceList);
		}
		
		
		if(rewards != null){
			DecrementAction decrement = new DecrementAction(aManager,resource);
			IncrementAction increment = new IncrementAction(aManager,rewards);
			decrement = aManager.affect(decrement);
			increment = aManager.affect(increment);
			
			if(decrement.isLegal() && increment.isLegal()){
				decrement.perform();
				increment.perform();
			}
		}
	}

//	@Override
//	public ExchangeAction clone() {
//		return new ExchangeAction(aManager, exchange);
//	}

}
