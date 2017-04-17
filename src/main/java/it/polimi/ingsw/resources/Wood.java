package it.polimi.ingsw.resources;

public class Wood extends Resource {
	
	public Wood (){
		super();
	}

	@Override
	public int getValue() {
		return this.value;
	}

	@Override
	public void setValue(int value) {
		this.value=value;
	}

	@Override
	public String toString() {
		return "Wood [value=" + value + "]";
	}
	
	

}
