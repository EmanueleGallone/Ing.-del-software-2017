package it.polimi.ingsw.resources;

import event.Decrementable;
import event.Event;
import event.Incrementable;
import event.Observers;

public class Stone extends Resource implements Incrementable,Decrementable {
	
	
	public Stone(){
		super();
	}

	@Override
	public void setValue(int value) {
		this.value=value;
	}

	@Override
	public String toString() {
		return "Stone [value=" + value + "]";
	}

	
	
	
	
	
	
	
	

}
