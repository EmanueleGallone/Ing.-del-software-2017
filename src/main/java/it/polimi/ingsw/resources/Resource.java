package it.polimi.ingsw.resources;

public class Resource {

	protected int value;
	
	public Resource(){
		//initialized value for any type of resource
		this.value=0;
	}
	
	public Resource(int value){
		this.value = value;
	}
	
	public  int getValue(){
		return this.value;
	}
	
	public void setValue(int value){
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Resource [value=" + value + "]";
	}


	public void increment(int value) {
		this.value += value;
		if (this.value < 0)
			this.value = 0;
	}
}
