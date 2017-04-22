package event.list.increment;

import event.EventHandler;

public interface Incrementable{
	
	public void increment(int value);
	public EventHandler<IncrementEvent> getIncrementEvent();
}
