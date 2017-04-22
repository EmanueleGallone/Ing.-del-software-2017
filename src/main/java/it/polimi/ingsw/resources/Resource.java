package it.polimi.ingsw.resources;


import event.*;
import event.increment.IncrementEvent;
import event.increment.Incrementable;
import event.stringChange.StringChangeEvent;
import event.stringChange.StringChangeInterface;

public class Resource implements Incrementable<Resource>,StringChangeInterface<Resource> {
	protected int value;
	
	protected EventHandler<IncrementEvent<Resource>> incrementEvent;
	protected EventHandler<StringChangeEvent<Resource>> stringChange;
	
	public Resource(){
		//initialized value for any type of resource
		this.value=0;
		incrementEvent = new EventHandler<>();
		stringChange = new EventHandler<>();
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
		incrementEvent.invoke(new IncrementEvent<Resource>(this, value));
		this.value += value;
	}

	@Override
	public EventHandler<IncrementEvent<Resource>> getIncrementEvent() {
		return this.incrementEvent;
	}
	//fine per increment event
	

	@Override
	public void changeString(String newString) {
		System.out.println("Sto per cambiare stringa in: " + newString);
		stringChange.invoke(new StringChangeEvent<Resource>(this, newString));
	}

	@Override
	public EventHandler<StringChangeEvent<Resource>> getStringChangeEvent() {
		// TODO Auto-generated method stub
		return this.stringChange;
	}

}
