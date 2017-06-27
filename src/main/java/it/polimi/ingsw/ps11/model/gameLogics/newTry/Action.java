package it.polimi.ingsw.ps11.model.gameLogics.newTry;

public interface Action {

	public boolean isLegal();
	public void perform();
	
	public void attach(ActionManager aManager);
	public Class<? extends Action> target();
}
