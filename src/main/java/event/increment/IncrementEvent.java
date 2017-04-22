package event.increment;

import event.Event;

public class IncrementEvent<SUBJECT_TYPE> extends Event<SUBJECT_TYPE> {
	
	private int value;
	
	public IncrementEvent(SUBJECT_TYPE subject, int value) {
		super(subject);
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}
}
