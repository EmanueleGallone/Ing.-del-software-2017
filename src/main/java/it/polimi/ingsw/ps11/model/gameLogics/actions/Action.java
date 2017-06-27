package it.polimi.ingsw.ps11.model.gameLogics.actions;

public interface Action extends Cloneable{

	public boolean isLegal();
	public void perform();
	
	public default void perform(boolean execute){
		if(execute){
			perform();
		}
	}
	
	public void attach(ActionManager aManager);
	public Class<? extends Action> target();
	
	public Action clone();
}
