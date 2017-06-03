package it.polimi.ingsw.ps11.cranio.game.actions;

public interface Action {
	
	public void perform();
	public boolean isLegal();
	public void accept(ActionVisitor visitor);
}
