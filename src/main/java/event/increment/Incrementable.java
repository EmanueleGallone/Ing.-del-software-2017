package event.increment;

import event.EventHandler;

public interface Incrementable<SUBJECT_TYPE> {
	
	public void increment(int value);
	public EventHandler<IncrementEvent<SUBJECT_TYPE>> getIncrementEvent();
}
