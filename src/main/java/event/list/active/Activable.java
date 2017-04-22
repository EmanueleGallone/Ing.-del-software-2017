package event.list.active;

import event.EventHandler;

public interface Activable{
	
	public void Active();
	public EventHandler<Void> getActiveEvent();
}
