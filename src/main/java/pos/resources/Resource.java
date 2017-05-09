package pos.resources;

import pos.events.EventHandler;
import pos.interfaceList.Incrementable;

public class Resource implements Incrementable {
	private static final int DEFAULT_VALUE = 0;
	private static final int MINIMUM_VALUE = 0;
	
	private int value;
	
	EventHandler<Void> incrementEvent = new EventHandler<>();
	
//Start constructor
	
	public Resource(){
		this(DEFAULT_VALUE);
	}
	
	public Resource(int value) {
		this.value = value;
	}	
	
//End constructor
//Start logics

	@Override
	public void increment(int value) {
		this.increment(value,true);
	}
	@Override
	public void increment(int value,boolean invokeEvent) {
		this.value += value;
		if (invokeEvent)
			incrementEvent.invoke(null);
		if (this.value < MINIMUM_VALUE){
			this.value = MINIMUM_VALUE;
		}
	}
	
	@Override
	public EventHandler<Void> getIncrementEvent() {
		return incrementEvent;
	}
	
//End logics
//Start setters
	public void setValue(int value) {
		this.value = value;
	}

//End setters
//Start getters
	
	public int getValue() {
		return value;
	}
//End getters
}
