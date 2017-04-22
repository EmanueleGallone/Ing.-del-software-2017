package it.polimi.ingsw.resources;

import event.Event;

public abstract class Resource {
	protected int value;
	
	protected Event<Resource> incrementEvent;
	protected Event<Resource> decrementEvent;
	
	public Resource(){
		//initialized value for any type of resource
		this.value=0;
		
		incrementEvent = new Event(this);
		decrementEvent = new Event(this);
	}
	
	public  int getValue(){
		return this.value;
	}
	
	public void setValue(int value){ //scomodo per i FamilyMember. non lo uso. devo capire cosa inventarmi. ema
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Resource [value=" + value + "]";
	}

		//metodi per Increment event

		public void increment(int value) {
			incrementEvent.preEventNotify();
			this.value += value;
			incrementEvent.postEventNotify();
		}


		public Event IncrementEvent() {
			return this.incrementEvent;
		}
	
		//fine per increment event

		
		// metodi per Decrement event
		public void decrease(int value) {
			decrementEvent.preEventNotify();
			this.value -= value;
			decrementEvent.postEventNotify();		
		}

		public Event DecrementEvent() {
			return this.decrementEvent;
		}
		//fine metodi Decrement event

}
