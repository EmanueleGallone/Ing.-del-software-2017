package it.polimi.ingsw.resources;


import event.*;
import event.increment.*;

public class Resource implements Incrementable {
	protected int value;
	
	protected EventHandler<IncrementEvent> incrementEvent;
	
	public Resource(){
		//initialized value for any type of resource
		this.value=0;
		incrementEvent = new EventHandler<>();
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
		incrementEvent.invoke(new IncrementEvent(value));
		this.value += value;
	}

	@Override
	public EventHandler<IncrementEvent> getIncrementEvent() {
		return this.incrementEvent;
	}
	//fine per increment event



}
