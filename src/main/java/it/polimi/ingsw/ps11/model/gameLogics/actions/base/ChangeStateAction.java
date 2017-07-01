package it.polimi.ingsw.ps11.model.gameLogics.actions.base;

import it.polimi.ingsw.ps11.model.gameLogics.State;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
/** <h3> ChangeStateAction </h3>
 * <p> Classe che rappresenta l'azione di passaggio di stato.</p>
 * @see Action
 */
public class ChangeStateAction implements Action<ChangeStateAction> {

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
		aManager.changeState(nextState);
	}
// _________________________ Method for action system ________________________


	@Override
	public ChangeStateAction decore(ChangeStateAction action) {
		if(action != this){
			return action.decore(this);
		}
		return this;
	}
	
	@Override
	public void attach(ActionManager aManager){
		ChangeStateAction action = aManager.get(target());
		if(action == null){
			action = this;
		}
		aManager.add(action.decore(this));
	}

	@Override
	public Class<ChangeStateAction> target() {
		return ChangeStateAction.class;
	}
	
// ___________________________________________________
	
	@Override
	public ChangeStateAction clone(){
		ChangeStateAction copy = new ChangeStateAction(aManager, nextState);
		return copy;
	}

}
