package it.polimi.ingsw.ps11.model.gameLogics.actions.base;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.ActionManager;

public class DoSeveralTimes implements Action<DoSeveralTimes>{

	private ActionManager aManager;
	private Action<?> action;
	private int iterationNumber;
	
	public DoSeveralTimes(ActionManager aManager, Action<?> action, int iterationNumber) {
		this.aManager = aManager;
		this.action = action;
		this.iterationNumber = iterationNumber;
	}
	
	@Override
	public boolean isLegal() {
		return action.isLegal();
	}

	@Override
	public void perform() {
		for(int i = 0; i < iterationNumber; i++){
			action.perform();
		}
	}

	@Override
	public DoSeveralTimes decore(DoSeveralTimes action) {
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
