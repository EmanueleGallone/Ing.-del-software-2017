package it.polimi.ingsw.resources;

import event.Decrementable;
import event.Event;
import event.Incrementable;
import event.Observers;

public class Resource implements Incrementable,Decrementable {
	protected int value;
	
	protected Event incrementEvent;
	protected Event decrementEvent;
	
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
		@Override
		public void increment(int value) {
			incrementEvent.preEventNotify();
			this.value += value;
			incrementEvent.postEventNotify();
		}

		@Override
		public void observIncrementEvent(Observers observer) {
			incrementEvent.attach(observer);
		}

		@Override
		public void deobservIncrementEvent(Observers observer) {
			incrementEvent.detach(observer);
		} //fine per increment event

		
		// metodi per Decrement event
		@Override
		public void decrease(int value) {
			decrementEvent.preEventNotify();
			this.value -= value;
			decrementEvent.postEventNotify();		
		}

		@Override
		public void observDecreaseEvent(Observers observer) {
			decrementEvent.attach(observer);
		}

		@Override
		public void deobservDecreaseEvent(Observers observer) {
			decrementEvent.detach(observer);
			
		} //fine metodi Decrement event
	
	
	

}
