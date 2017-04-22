package event.active;

import event.empty.EmptyEventHandler;

public interface Activable{
	
	public void Active();
	public EmptyEventHandler getActiveEvent();
}
