package it.polimi.ingsw.ps11.model.gameLogics.actions.base;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
/** <h3> EndGameAction </h3>
 * <p> Classe che rappresenta il termine di un'azione.</p>
 * @see Action
 */
public class EndGameAction implements Action<EndGameAction> {

	public EndGameAction() {
	
	}
	
	@Override
	public boolean isLegal() {
		return true;
	}

	@Override
	public void perform() {
		
	}
	
// _________________________ Method for action system ________________________


	@Override
	public EndGameAction decore(EndGameAction action) {
		if(action != this){
			return action.decore(this);
		}
		return this;
	}
	
	@Override
	public void attach(ActionManager aManager){
		EndGameAction action = aManager.get(target());
		if(action == null){
			action = this;
		}
		aManager.add(action.decore(this));
	}

	@Override
	public Class<EndGameAction> target() {
		return EndGameAction.class;
	}

	@Override
	public EndGameAction clone() {
		return new EndGameAction();
	}

}
