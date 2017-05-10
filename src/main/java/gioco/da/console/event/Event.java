package gioco.da.console.event;

public class Event<SUBJECT> {
	
	protected SUBJECT subject;
	
	public Event(SUBJECT subject){
		this.subject = subject;
	}
	
	
	public SUBJECT getSubject(){
		return this.subject;
	}
	
	
	
}
