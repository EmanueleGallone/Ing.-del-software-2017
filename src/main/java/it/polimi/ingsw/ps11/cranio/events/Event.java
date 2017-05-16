package it.polimi.ingsw.ps11.cranio.events;

public class Event {

	private Object source;
	
	public Event() {
		source = null;
	}
	
	public Event(Object source){
		this.source = source;
	}
	
	public void setSource(Object source) {
		this.source = source;
	}
	public Object getSource() {
		return source;
	}

}
