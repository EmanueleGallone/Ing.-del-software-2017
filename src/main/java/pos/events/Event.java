package pos.events;

public class Event<SUBJECT,PARAMETER> {
	
	protected SUBJECT subject;
	protected PARAMETER parameter;
	
	public Event(SUBJECT subject,PARAMETER parameter) {
		this.subject = subject;
		this.parameter = parameter;
	}
	
	public SUBJECT getSubject() {
		return (SUBJECT)subject;
	}
	public PARAMETER getParameter() {
		return (PARAMETER)parameter;
	}
}
