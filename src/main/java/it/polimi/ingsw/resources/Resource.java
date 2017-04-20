package it.polimi.ingsw.resources;

import event.Decrementable;
import event.Event;
import event.Incrementable;
import event.Observable;
import event.Observers;

public class Resource implements Incrementable,Decrementable {
	protected int value;
	
	protected Event<Resource> incrementEvent;
	protected Event<Resource> decrementEvent;
	
	/*public Resource(){
		//initialized value for any type of resource
		this.value=0;
	}*/
	
	public Resource(){
		//initialized value for any type of resource
		this.value=0;
		
		incrementEvent = new Event<Resource>(this);
		decrementEvent = new Event<Resource>(this);
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
		@Override
		public void increment(int value) {
			incrementEvent.preEventNotify();
			this.value += value;
			incrementEvent.postEventNotify();
		}


		@Override
		public Event IncrementEvent() {
			return this.incrementEvent;
		}
	
		//fine per increment event

		
		// metodi per Decrement event
		@Override
		public void decrease(int value) {
			decrementEvent.preEventNotify();
			this.value -= value;
			decrementEvent.postEventNotify();		
		}

		@Override
		public Event DecrementEvent() {
			return this.decrementEvent;
		}
		//fine metodi Decrement event

}
