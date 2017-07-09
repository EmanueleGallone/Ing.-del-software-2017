package it.polimi.ingsw.ps11.model.gameLogics.states;

import java.util.ArrayList;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.NeedConfirm;
import it.polimi.ingsw.ps11.view.viewEvents.ConfirmViewEvent;

public class WaitConfirm extends PlayState {

	private NeedConfirm action;
	private ArrayList<Action> doAfter;
	
	public WaitConfirm(NeedConfirm action) {
		this.action = action;
	}
	
	public WaitConfirm(NeedConfirm action, ArrayList<Action> doAfter) {
		this(action);
		this.doAfter = doAfter;
	}
	
	@Override
	public void handle(ConfirmViewEvent confirmEvent) {
		if(action.notifyConfirm(confirmEvent))
			doAfterAction(doAfter);
	}
	
	private void doAfterAction(ArrayList<Action> actions){
		for(Action action: actions ){
			if(action!=null && action.isLegal())
				action.perform();
		}
	}
	
	@Override
	public void notifyToClient() {
		stateHandler().invoke(action.getConfirm());
	}
}
