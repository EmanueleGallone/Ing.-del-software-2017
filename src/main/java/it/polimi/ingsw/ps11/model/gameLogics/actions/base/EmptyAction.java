package it.polimi.ingsw.ps11.model.gameLogics.actions.base;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;

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
