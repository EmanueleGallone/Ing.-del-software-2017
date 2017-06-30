package it.polimi.ingsw.ps11.model.gameLogics.actions.base;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.effects.Effect;
import it.polimi.ingsw.ps11.model.modelEvents.ChooseResourceEvent;
import it.polimi.ingsw.ps11.model.modelEvents.ModelEvent;
import it.polimi.ingsw.ps11.model.modelEvents.TextualEvent;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/** <h3> GetCardAction </h3>
 * <p> Classe che rappresenta l'azione di aggiunta di una carta al mazzo personale di un giocatore dal floor di un piano</p>
 * @see Action
 */
public class GetCardAction implements Action<GetCardAction>{

	protected ActionManager aManager;
	protected DevelopmentCard card;
	protected ResourceList cost;
	
	private ResourceList modifier = new ResourceList();
	
	
	private EventHandler<ModelEvent> eventHandler = new EventHandler<>();
	
	public GetCardAction() {
	
	}

	public GetCardAction(ActionManager aManager, DevelopmentCard card, ResourceList cost) {
		this.aManager = aManager;
		this.card = card;
		if(cost != null)
			this.cost = cost.clone();
	}
	
	@Override
	public boolean isLegal() {
		
		if(card == null)
			return false;
		
		if(!card.isMonoCost() && cost == null ){
			ChooseResourceEvent c = new ChooseResourceEvent(card.getCosts());
			c.setMessage("Seleziona uno dei costi da pagare");
			eventHandler.invoke(c);
			return false;
		}
		else if(cost == null && card.isMonoCost()){
			cost = card.getFirstCost();
		}
		
		boolean result = this.card.getCosts().contains(cost);
		ResourceList temp = cost.clone();
		temp.subtract(modifier);
		DecrementAction pay = aManager.newDecrementAction(temp);
		if(!pay.isLegal()){
			result = false;
			aManager.stateHandler().invoke(new TextualEvent("Non hai abbastanza risorse per prendere la carta"));
		}
		return result && aManager.getSubject().getCardManager().canAdd(card);
	}

	@Override
	public void perform() {
		DecrementAction pay = aManager.newDecrementAction(cost);
		pay.perform();
		aManager.getSubject().getCardManager().addCard(card);
		
		for(Effect effect: card.getInstantEffect()){
			Action<?> action = effect.get(aManager);
			if(action.isLegal())
				action.perform();
		}
		for(Effect permaEffect: card.getPermanentEffect()){
			permaEffect.get(aManager).attach(aManager);
		}
	}
	
	
	public void setCost(ResourceList cost) {
		this.cost = cost;
	}
	public DevelopmentCard getCard() {
		return card;
	}
	public ResourceList getCostModifier() {
		return modifier;
	}

	public void attach(EventListener<ModelEvent> listener){
		eventHandler.attach(listener);
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
		ResourceList resource = null;
		if(cost != null)
			resource = cost.clone();
		GetCardAction copy = new GetCardAction(aManager, card.clone(), cost.clone());
		return copy;
	}

}
