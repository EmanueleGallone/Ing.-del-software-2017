package it.polimi.ingsw.ps11.model.gameLogics.newActions.base;

import it.polimi.ingsw.ps11.model.gameLogics.newActions.Action;

public class EmptyAction implements Action {

	@Override
	public boolean isLegal() {
		return false;
	}

	@Override
	public void perform() {
		
	}

	@Override
	public Action clone() {
		return new EmptyAction();
	}

}
