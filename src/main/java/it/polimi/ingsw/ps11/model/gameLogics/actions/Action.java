package it.polimi.ingsw.ps11.model.gameLogics.actions;

public interface Action {
	
	public void perform();
	public boolean isLegal();
}
