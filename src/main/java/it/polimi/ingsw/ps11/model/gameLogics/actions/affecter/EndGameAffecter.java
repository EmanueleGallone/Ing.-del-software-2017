package it.polimi.ingsw.ps11.model.gameLogics.actions.affecter;

import it.polimi.ingsw.ps11.model.gameLogics.actions.Action;
import it.polimi.ingsw.ps11.model.gameLogics.actions.base.EndGameAction;

public class EndGameAffecter extends EndGameAction {

	private final boolean FORWARD = true;
	private boolean forward = FORWARD;
	
	private Action<?> actionToDo;
	private EndGameAction action;
	
	public EndGameAffecter(Action<?> action) {
		this.actionToDo = action;
	}
	
	@Override
	public boolean isLegal() {
		return actionToDo.isLegal() && action.isLegal();
	}
	
	@Override
	public void perform() {
		actionToDo.perform();
		forward();
	}
	
// Method for decorator system ____________	

	@Override
	public EndGameAction decore(EndGameAction action) {
		if(this.action == null && action != this){
			this.action = action;
			return this;
		}
		else if(this.action != null){
			this.action.decore(action);
			return this;
		}
		return this;
	}

	public void forward(){
		if (action!= null)
			action.perform(forward && FORWARD);
		this.forward = FORWARD;
	}
	
	@Override
	public void perform(boolean forward) {
		this.forward = forward;
		perform();
	}
	
// __________________________
	
	@Override
	public EndGameAffecter clone(){
		EndGameAffecter copy = new EndGameAffecter(actionToDo.clone());
		if(action != null)
			copy.action = action.clone();
		return copy;
	}
}
