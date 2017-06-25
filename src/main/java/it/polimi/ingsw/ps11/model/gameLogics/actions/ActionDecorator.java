package it.polimi.ingsw.ps11.model.gameLogics.actions;

import it.polimi.ingsw.ps11.model.player.Player;

public abstract class ActionDecorator<T extends Action> implements Action{

	protected T action;
	protected String target;
	
	public ActionDecorator(Class<T> target) {
		this.target = target.toString();
	}
	
	public ActionDecorator(T action) {
		this.action = action;
	}
	
	public String getTarget() {
		return target;
	}
	
	@Override
	public Player getSource() {
		return action.getSource();
	}
	
	public abstract ActionDecorator<T> decore(T action);
}
