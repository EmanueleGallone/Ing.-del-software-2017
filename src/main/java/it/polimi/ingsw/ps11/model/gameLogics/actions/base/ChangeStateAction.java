package it.polimi.ingsw.ps11.model.gameLogics.actions.base;

import it.polimi.ingsw.ps11.model.gameLogics.State;
import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;

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

	@Override
	public ChangeStateAction decore(ChangeStateAction action) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void attach(ActionManager aManager) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<? extends Action<?>> target() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Action<?> clone() {
		// TODO Auto-generated method stub
		return null;
	}

}
