package event.active;

import event.Event;
import event.EventHandler;

public interface Activable<SUBJECT_TYPE> {
	public EventHandler<Event<SUBJECT_TYPE>> getActiveEvent();
}
