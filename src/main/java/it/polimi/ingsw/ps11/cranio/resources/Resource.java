package it.polimi.ingsw.ps11.cranio.resources;

public class Resource {
	protected static final int DEFAULT = 0;
	protected int value;
	
	//start constructor
	public Resource(){
		this(DEFAULT);
	}
	
	public Resource(int value){
		this.value = value;
	}
	//end constructor
	
	public int getValue(){
		return this.value;
	}
	
	public void setValue(int value){
		this.value = value;
	}
	
	public void increment(int value){
		this.value += value;
	}
}
