package it.polimi.ingsw.ps11.model.gameLogics.actions.base;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.actions.effects.Effect;
/** <h3> ActiveYieldAction </h3>
 * <p> Classe che rappresenta l'azione di attivazione delle carte appartenenti alla classe "Territorio" o "Edificio", 
 * dovuto al piazzamento di un familiare nella zona racolta o Produzione o all'attivazione di una carta</p>
 * @see Action
 */
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
	
// _________________________ Method for action system ________________________


	@Override
	public ActiveYieldAction decore(ActiveYieldAction action) {
		if(action != this){
			return action.decore(this);
		}
		return this;
	}
	
	@Override
	public void attach(ActionManager aManager){
		ActiveYieldAction action = aManager.get(target());
		if(action == null){
			action = this;
		}
		aManager.add(action.decore(this));
	}

	@Override
	public Class<ActiveYieldAction> target() {
		return ActiveYieldAction.class;
	}
	
// ___________________________________________________
	
	@Override
	public ActiveYieldAction clone(){
		ActiveYieldAction copy = new ActiveYieldAction(aManager,cardType,value);
		return copy;
	}

}
