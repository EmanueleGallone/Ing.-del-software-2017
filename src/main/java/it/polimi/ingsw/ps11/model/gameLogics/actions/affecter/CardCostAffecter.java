package it.polimi.ingsw.ps11.model.gameLogics.actions.affecter;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.events.EventListener;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.GetCardAction;
import it.polimi.ingsw.ps11.model.modelEvents.ModelEvent;
import it.polimi.ingsw.ps11.model.resources.ResourceList;
/** <h3> CardCostAffecter </h3>
 * <p> Classe che rappresenta il bonus che ha il compito di modificare il costo della ResourceList di una carta</p>
 * @see GetCardAction
 */
public class CardCostAffecter extends GetCardAction {
	
	private final boolean FORWARD = true;
	private boolean forward = FORWARD;
	
	private String cardType;
	private ResourceList discount;
	private GetCardAction action;
	
	
	public CardCostAffecter(String cardType, ResourceList resource) {
		this.discount = resource;
	}
	
	@Override
	public boolean isLegal() {
		return action.isLegal();
	}
	
	@Override
	public void perform() {
		String card = action.getCard().getClass().toString();
		if(card.equals(cardType))
			action.getCostModifier().sum(discount);
		forward();
	}
	
	@Override
	public DevelopmentCard getCard() {
		return action.getCard();
	}
	
	@Override
	public ResourceList getCostModifier() {
		return action.getCostModifier();
	}
	
	@Override
	public void attach(EventListener<ModelEvent> listener){
		action.attach(listener);
	}
	
	@Override
	public void setCost(ResourceList cost) {
		action.setCost(cost);
	}
	
// Method for action system ____________	
	
	@Override
	public GetCardAction decore(GetCardAction action) {
		if(this.action == null && action != this){
			this.action = action;
			return this;
		}
		else if(this.action != null){
			this.action.decore(action);
			return this;
		}
		return this;
	}

	public void forward(){
		if (action!= null)
			action.perform(forward && FORWARD);
		this.forward = FORWARD;
	}
	
	@Override
	public void perform(boolean forward) {
		this.forward = forward;
		perform();
	}
	
// __________________________
	
	@Override
	public CardCostAffecter clone(){
		CardCostAffecter copy = new CardCostAffecter(cardType, discount.clone());
		copy.aManager = aManager;
		if(action != null)
			copy.action = action.clone();
		return copy;
	}
}
