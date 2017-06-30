package it.polimi.ingsw.ps11.model.gameLogics.actions.base;

import it.polimi.ingsw.ps11.model.game.Game;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;

public class EndTurnAction implements Action<EndTurnAction>{

	protected ActionManager aManager;
	
	/*
	 * Potrebbe non essere necesaria come azione se la logica la si mette
	 * nel nextPlayer in gameLogic
	 */
	public EndTurnAction(){
		
	}
	
	public EndTurnAction(ActionManager actionManager) {
		this.aManager = actionManager;
	}
	
	@Override
	public boolean isLegal() {
		return true;
	}

	@Override
	public void perform() {
		Game game = aManager.getStateHandler().getGame();
		game.getRoundManager().next();
		/*
		 * Va completato
		 */
	}

// _________________________ Method for action system ________________________


	@Override
	public EndTurnAction decore(EndTurnAction action) {
		if(action != this){
			return action.decore(this);
		}
		return this;
	}
	
	@Override
	public void attach(ActionManager aManager){
		EndTurnAction action = aManager.get(target());
		if(action == null){
			action = this;
		}
		aManager.add(action.decore(this));
	}

	@Override
	public Class<EndTurnAction> target() {
		return EndTurnAction.class;
	}
	
// ___________________________________________________
	
	@Override
	public EndTurnAction clone(){
		EndTurnAction copy = new EndTurnAction(aManager);
		return copy;
	}

}
