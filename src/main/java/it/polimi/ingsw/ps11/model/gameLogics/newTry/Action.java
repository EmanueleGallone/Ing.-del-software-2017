package it.polimi.ingsw.ps11.model.gameLogics.newTry;

public interface Action<T extends Action<?>> {

	public boolean isLegal(ActionManager actionManager);
	public void perform(ActionManager actionManager);
	public T decore(T action);
	public T take(Class<T> kClass);
	public Class<T> target();
}
