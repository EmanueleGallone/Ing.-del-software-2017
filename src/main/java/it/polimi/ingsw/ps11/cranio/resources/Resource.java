package it.polimi.ingsw.ps11.cranio.resources;

public abstract class Resource {
	protected static final int DEFAULT = 0;
	protected int value;
	protected static int id;
	
	//start constructor
	public Resource(){
		this(DEFAULT);
	}
	
	public Resource(int value){
		this.value = value;
		id = 0;
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
	
	public static int getID(){
		return id;
	}

}
