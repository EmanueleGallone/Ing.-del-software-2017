package it.polimi.ingsw.ps11.cranio.events;

public class Event<TYPE> {

	protected TYPE source;
	
	public Event() {
		source = null;
	}
	
	public Event(TYPE source){
		this.source = source;
	}
	
	public void setSource(TYPE source) {
		this.source = source;
	}
	public TYPE getSource() {
		return source;
	}

}
