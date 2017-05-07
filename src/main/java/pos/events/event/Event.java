package pos.events.event;

public class Event<SUBJECT_TYPE> {
	
	private SUBJECT_TYPE subject;
	
	public Event(SUBJECT_TYPE subject) {
		this.subject = subject;
	}
}
