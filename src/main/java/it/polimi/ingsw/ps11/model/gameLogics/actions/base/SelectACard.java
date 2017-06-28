package it.polimi.ingsw.ps11.model.gameLogics.actions.base;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;
import it.polimi.ingsw.ps11.model.gameLogics.states.WaitCard;

public class SelectACard implements Action<SelectACard> {

	private ActionManager aManager;
	private String cardType;
	
	public SelectACard(ActionManager aManager, String cardType) {
		this.aManager = aManager;
	}
	
	@Override
	public boolean isLegal() {
		return true;
	}

	@Override
	public void perform() {
		aManager.changeState(new WaitCard(cardType));
	}

	@Override
	public SelectACard decore(SelectACard action) {
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
