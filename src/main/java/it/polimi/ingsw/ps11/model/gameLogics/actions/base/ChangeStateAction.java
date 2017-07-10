package it.polimi.ingsw.ps11.model.gameLogics.actions.base;

import it.polimi.ingsw.ps11.model.gameLogics.State;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
/** <h3> ChangeStateAction </h3>
 * <p> Azione di cambiamento di stato.</p>
 * @see Action
 */
public class ChangeStateAction implements Action {
	
	private ActionManager aManager;
	private State nextState;
	
	public ChangeStateAction(ActionManager aManager, State state) {
		this.aManager = aManager;
		this.nextState = state;
	}
	
	
	
	@Override
	public boolean isLegal() {
		return true;
	}

	@Override
	public void perform() {
		aManager.state().nextState(nextState);
	}

	
//	@Override
//	public ChangeStateAction clone() {
//		return new ChangeStateAction(aManager, nextState);
//	}
}
