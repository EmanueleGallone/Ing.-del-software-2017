package event;

public class Event<SUBJECT_TYPE> {
	protected SUBJECT_TYPE subject;
	
	public Event(SUBJECT_TYPE subject){
		this.subject = subject;
	}
	
	public SUBJECT_TYPE getSubject() {
		return (SUBJECT_TYPE)subject;
	}
}
