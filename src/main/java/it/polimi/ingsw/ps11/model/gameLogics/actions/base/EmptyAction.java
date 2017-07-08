package it.polimi.ingsw.ps11.model.gameLogics.actions.base;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
/**
 * <h3> EmptyAction </h3>
 * <p> Azione vuota: contiene <p>isLegal(),</p> <p>perform(),</p> <p>clone().</p>
 * @see Affecter
 * @see 
 */
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
