package pos.interfaceList;

import pos.events.EventHandler;

public interface Incrementable {
	public void increment(int value);
	public void increment(int value,boolean invokeEvent);
	public EventHandler<Void> getIncrementEvent();
}
