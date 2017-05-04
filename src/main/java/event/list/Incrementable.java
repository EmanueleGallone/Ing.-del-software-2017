package event.list;

import event.Event;

public interface Incrementable {
	public void increment(Integer value);
	public Event<Integer> getIncrementEvent();
}
