package it.polimi.ingsw.ps11.model.gameLogics.actions.base;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.effects.Effect;
import it.polimi.ingsw.ps11.model.gameLogics.states.WaitResource;
import it.polimi.ingsw.ps11.model.modelEvents.ChooseResourceEvent;
import it.polimi.ingsw.ps11.model.modelEvents.ModelEvent;
import it.polimi.ingsw.ps11.model.modelEvents.TextualEvent;
import it.polimi.ingsw.ps11.model.resources.ResourceList;

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
		
		if(card == null){
			aManager.send("Il piano è vuoto");
			return false;
		}
		
		if(isMultipleCost())
			return false;
		else if(cost == null && card.isMonoCost()){
			cost = card.getFirstCost();
		}

		ResourceList temp = cost.clone();
		temp.subtract(modifier);
		DecrementAction pay = aManager.newDecrementAction(temp);
		
		if(!pay.isLegal()){
			aManager.send("Non hai abbastanza risorse per prendere la carta");
			return false;
		}
		if(!aManager.getSubject().getCardManager().canAdd(card)){
			aManager.send("Non puoi prendere un'altra carta di questo tipo");
		}
		return true;
	}

	
	private boolean isMultipleCost(){
		if(!card.isMonoCost() && cost == null ){
			eventHandler.invoke(null); 			 //Serve solo a notificare il floorSelected state che deve andare in wait resource
			return true;			 			 // Non faccio aManager.changeState(new WaitResource(this));	perchè non ci devo mettere "this" altrimenti salterebbe tutta la catena di invocazioni
		}
		return false;
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
		GetCardAction copy = new GetCardAction(aManager, card.clone(), resource);
		return copy;
	}

}
