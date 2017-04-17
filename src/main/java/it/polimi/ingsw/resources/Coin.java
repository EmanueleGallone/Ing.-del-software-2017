package it.polimi.ingsw.resources;

public class Coin extends Resource {
	
	public Coin(){
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
		return "Coin [value=" + value + "]";
	}
	
	
	
	

}
