package it.polimi.ingsw.ps11.model.gameLogics.actions;

public interface Action {

	public boolean isLegal();
	public void perform();
	public Action clone();
}
