package it.polimi.ingsw.ps11.model.gameLogics.actions.base;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.cards.effects.Effect;
import it.polimi.ingsw.ps11.model.events.EventHandler;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.resources.DecrementAction;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
import it.polimi.ingsw.ps11.model.zones.Floor;
/** <h3> GetCardAction </h3>
 * <p> Azione di aggiunta di una carta al mazzo personale di un giocatore dal floor di un piano</p>
 * @see Action
 */
public class GetCardAction implements Action {
	
	private ActionManager aManager;
	private DevelopmentCard card;
	private ResourceList cost;
	private Floor floor;
	
	private ResourceList modifier = new ResourceList();
	
	//private ResourceList modifier = new ResourceList();
	
	private EventHandler<ArrayList<ResourceList>> eventHandler = new EventHandler<>();
	
	public GetCardAction(ActionManager aManager, DevelopmentCard card, ResourceList cost) {
		this.aManager = aManager;
		if(card!= null)
			this.card = card.clone();
		if(cost != null)
			this.cost = cost.clone();
	}
	
	public GetCardAction(ActionManager aManager, Floor floor, ResourceList cost) {
		this(aManager,floor.getCard(),cost);
		this.floor = floor;
	}
	
	@Override
	public boolean isLegal() {
		
		if(card == null){
			aManager.state().invoke("Il piano è vuoto");
			return false;
		}
		
		if(isMultipleCost())
			return false;
		else if(card.isMonoCost()){
			cost = card.getFirstCost();
		}

		DecrementAction pay = makePayAction();
		if(!pay.isLegal()){
			aManager.state().invoke("Non hai abbastanza risorse per prendere la carta");
			return false;
		}
		if(!aManager.state().getPlayer().getCardManager().canAdd(card)){
			aManager.state().invoke("Non puoi prendere un'altra carta di questo tipo");
			return false;
		}
		return true;
	}

	private DecrementAction makePayAction(){
		if(floor!= null)
			modifier.sum(floor.getActionSpace().getResources());
		ResourceList totalCost = this.cost.clone();
		totalCost.subtract(modifier);
		DecrementAction pay = new DecrementAction(aManager,totalCost);
		return aManager.affect(pay);
	}
	
	private boolean isMultipleCost(){
		if(!card.isMonoCost() && cost == null ){
			eventHandler.invoke(card.getCosts());  // Non faccio aManager.changeState(new WaitResource(this));	perchè non ci devo mettere "this" altrimenti salterebbe tutta la catena di invocazioni
			return true;
		}
		return false;
	}
	
	@Override
	public void perform() {
		DecrementAction pay = makePayAction();
		pay.perform();
		aManager.state().getPlayer().getCardManager().addCard(card);
		
		if(floor!=null)
			floor.cleanCard();
		
		for(Effect effect: card.getInstantEffect()){
			Action action = effect.get(aManager);
			if(action.isLegal())
				action.perform();
		}
		for(Effect permaEffect: card.getPermanentEffect()){
			permaEffect.get(aManager);
		}
	}
	
	public DevelopmentCard getCard() {
		return card;
	}
	
	public ResourceList getCost() {
		return cost;
	}
	
	public void addModifier(ResourceList modifier){
		this.modifier.sum(modifier);
	}
	
	public void setCost(ResourceList cost) {
		this.cost = cost;
	}

	public void attach(EventListener<ArrayList<ResourceList>> listener){
		eventHandler.attach(listener);
	}

	@Override
	public GetCardAction clone() {
		ResourceList c = cost;
		if(cost != null)
			c = cost.clone();
		return new GetCardAction(aManager, card.clone(), c);
	}

}
