package it.polimi.ingsw.ps11.model.gameLogics.actions.affecter;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Affecter;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.EndGameAction;
/** <h3> EndGameAffecter </h3>
 * <p> Classe che rappresenta il bonus che ha il compito di modificare le azioni compiute a fine 
 * partita. </p>
 * @see EndGameAction
 */
public class EndGameAffecter implements Affecter<EndGameAction>{

	private Action doAtTheEnd;
	
	public EndGameAffecter(Action doAtTheEnd) {
		this.doAtTheEnd = doAtTheEnd;
	}
	
	
	@Override
	public Class<EndGameAction> target() {
		return EndGameAction.class;
	}

	@Override
	public EndGameAction affect(EndGameAction action) {
		action.add(doAtTheEnd);
		return action;
	}

}
