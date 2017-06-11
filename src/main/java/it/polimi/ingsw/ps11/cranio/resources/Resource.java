package it.polimi.ingsw.ps11.cranio.resources;

public abstract class Resource {
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
		if (this.value < 0)
			this.value = 0;
	}
	
	protected abstract Resource clone();
	
	@Override
	public boolean equals(Object obj) {
		if(obj.getClass() == this.getClass() && ((Resource)obj).getValue() == value){
			return true;
		}
		return false;
	}
}
