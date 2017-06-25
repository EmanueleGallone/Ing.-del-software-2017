package it.polimi.ingsw.ps11.model.gameLogics.actions;

public class DefaultDecorator extends ActionDecorator<Action> {

	public DefaultDecorator(Action action) {
		super(action);
	}

	@Override
	public void perform() {
		action.perform();
	}

	@Override
	public boolean isLegal() {
		return action.isLegal();
	}

	@Override
	public Action enable(ActionManager aManager) {
		return this;
	}

	@Override
	public ActionDecorator<Action> decore(Action action) {
		this.action = action;
		return this;
	}

}
