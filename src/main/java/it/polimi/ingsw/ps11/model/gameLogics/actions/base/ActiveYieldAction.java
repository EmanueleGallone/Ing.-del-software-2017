package it.polimi.ingsw.ps11.model.gameLogics.actions.base;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.cards.DevelopmentCard;
import it.polimi.ingsw.ps11.model.cards.effects.Effect;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.modelEvents.GameUpdateEvent;
/** <h3> ActiveYieldAction </h3>
 * <p> Azione di attivazione delle carte appartenenti alla classe "Territorio" o "Edificio", 
 * dovuto al piazzamento di un familiare nella zona racolta o Produzione o all'attivazione di una carta</p>
 * @see Action
 */
public class ActiveYieldAction implements Action {

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
		boolean update = true;
		ArrayList<DevelopmentCard> cards = aManager.state().getPlayer().getCardManager().getCardList(cardType,true);
		for(DevelopmentCard card : cards){
			if(card.getActiveValue() <= value){
				active(card.getPermanentEffect());
				update = false;
			}
		}
		if(update){
			GameUpdateEvent event = new GameUpdateEvent(aManager.state().getGame());
			aManager.state().getGameLogic().notifyAllClients(event);	
		}
	}

	public void active(ArrayList<Effect> effects){
		for(Effect effect : effects){
			Action action = effect.get(aManager); 
			if(action.isLegal()){
				action.perform();
			}
		}
	}

//	@Override
//	public ActiveYieldAction clone() {
//		return new ActiveYieldAction(aManager, cardType, value);
//	}

}
