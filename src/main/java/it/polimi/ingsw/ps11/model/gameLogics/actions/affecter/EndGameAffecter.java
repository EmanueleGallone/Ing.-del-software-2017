package it.polimi.ingsw.ps11.model.gameLogics.actions.affecter;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Affecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.endGame.EndGameAction;
/**
 * <h3> EndGameAffecter </h3>
 * <p> Bonus: modifica le azioni che vengo eseguite automaticamente a fine partita attraverso una <code>EndGameAction</code>.</p>
 * @param  action (azione eseguita a fine partita).</p>
 * @see Affecter
 * @see EndGameAction
 */
public class EndGameAffecter implements Affecter<EndGameAction>{

	private Action doAtTheEnd;
	
	public EndGameAffecter(Action doAtTheEnd) {
		this.doAtTheEnd = doAtTheEnd;
	}
	
	@Override
	public String target() {
		return EndGameAction.class.toString();
	}

	@Override
	public EndGameAction affect(EndGameAction action) {
		action.add(doAtTheEnd);
		return action;
	}

}
