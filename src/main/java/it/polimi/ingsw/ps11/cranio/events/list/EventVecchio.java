package it.polimi.ingsw.ps11.cranio.events.list;

public class EventVecchio<SUBJECT,PARAMETER> {
	
	protected SUBJECT subject;
	protected PARAMETER parameter;
	
	public EventVecchio(SUBJECT subject,PARAMETER parameter) {
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
